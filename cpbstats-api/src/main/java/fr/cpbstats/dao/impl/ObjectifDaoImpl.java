package fr.cpbstats.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.ObjectifDao;
import fr.cpbstats.model.Objectif;

/**
 * The {@link ObjectifDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class ObjectifDaoImpl extends GenericDaoImpl<Objectif, Integer> implements ObjectifDao {

    /** {@inheritDoc} */
    @Override
    public List<Objectif> findAllByLogin(String login) {
        try {
            TypedQuery<Objectif> query = getEntityManager().createQuery(
                    "from Objectif o where o.utilisateur.login = :login", Objectif.class);
            query.setParameter("login", login);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
