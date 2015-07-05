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

    /** The type. */
    private Class<T> type = null;

    /** The entityManager. */
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Constructor.
     */
    protected GenericDaoImpl() {
        this.type = this.getParameterizedType(this.getClass());
    }

    /**
     * @return the entityManager
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }

    /**
     * @param clazz
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    private Class<T> getParameterizedType(Class clazz) {
        Class<T> specificType = null;
        ParameterizedType parameterizedType = (ParameterizedType) clazz.getGenericSuperclass();
        specificType = (Class<T>) parameterizedType.getActualTypeArguments()[0];
        return specificType;
    }

    /** {@inheritDoc} */
    @Override
    public void flush() {
        entityManager.flush();
    }

    /** {@inheritDoc} */
    @Override
    public void persist(T o) {
        if (o != null) {
            entityManager.persist(o);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void remove(T o) {
        if (o != null) {
            entityManager.remove(merge(o));
        }
    }

    /** {@inheritDoc} */
    @Override
    public void refresh(T o) {
        entityManager.refresh(o);
    }

    /** {@inheritDoc} */
    @Override
    public T merge(T o) {
        return entityManager.merge(o);
    }

    /** {@inheritDoc} */
    @Override
    public T find(P primaryKey) {
        return entityManager.find(type, primaryKey);
    }

    /** {@inheritDoc} */
    @Override
    public T getReference(P primaryKey) {
        return entityManager.getReference(type, primaryKey);
    }

    /** {@inheritDoc} */
    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        return entityManager.createQuery("SELECT x FROM " + type.getSimpleName() + " x")
                .getResultList();
    }

    /**
     * @param queryString
     * @return
     */
    @SuppressWarnings("unchecked")
    protected List<T> getEntityList(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return query.getResultList();
    }

    /**
     * @param queryString
     * @return
     */
    @SuppressWarnings("unchecked")
    protected T getSingleEntity(String queryString) {
        Query query = entityManager.createQuery(queryString);
        return (T) query.getSingleResult();
    }

    /** {@inheritDoc} */
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
