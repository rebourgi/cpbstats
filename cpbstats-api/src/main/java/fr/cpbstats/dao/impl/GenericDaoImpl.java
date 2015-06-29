package fr.cpbstats.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;

import fr.cpbstats.dao.GenericDao;

/**
 * @author rebourgi
 * 
 * @param <T>
 * @param <PK>
 */
public class GenericDaoImpl<T, P> implements GenericDao<T, P> {

    private Class<T> type = null;

    @PersistenceContext
    private EntityManager entityManager;

    protected GenericDaoImpl() {
        this.type = this.getParameterizedType(this.getClass());
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Class<T> getParameterizedType(Class clazz) {
        Class<T> specificType = null;
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return specificType;
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#flush()
     */
    @Override
    public void flush() {
        entityManager.flush();
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#persist(java.lang.Object)
     */
    @Override
    public void persist(T o) {
        if (o != null) {
            entityManager.persist(o);
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#remove(java.lang.Object)
     */
    @Override
    public void remove(T o) {
        if (o != null) {
            entityManager.remove(merge(o));
        }
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#refresh(java.lang.Object)
     */
    @Override
    public void refresh(T o) {
        entityManager.refresh(o);
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#merge(java.lang.Object)
     */
    @Override
    public T merge(T o) {
        return entityManager.merge(o);
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#find(java.lang.Object)
     */
    @Override
    public T find(P primaryKey) {
        return entityManager.find(type, primaryKey);
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#getReference(java.lang.Object)
     */
    @Override
    public T getReference(P primaryKey) {
        return entityManager.getReference(type, primaryKey);
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#findAll()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT x FROM " + type.getSimpleName() + " x")
                .getResultList();
    }

    @SuppressWarnings("unchecked")
    protected List<T> getEntityList(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    protected T getSingleEntity(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return (T) query.getSingleResult();
    }

    /*
     * (non-Javadoc)
     * @see fr.cpbrennestt.dao.GenericDao#findAllOrderBy(java.lang.String, boolean)
     */
    @Override
    public List<T> findAllOrderBy(String filter, boolean asc) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> from = criteriaQuery.from(type);
        CriteriaQuery<T> select = criteriaQuery.select(from);
        Order order;
        if (asc) {
            order = criteriaBuilder.asc(from.get(filter));
        } else {
            order = criteriaBuilder.desc(from.get(filter));
        }
        criteriaQuery.orderBy(order);
        TypedQuery<T> typedQuery = entityManager.createQuery(select);
        return typedQuery.getResultList();
    }

}
