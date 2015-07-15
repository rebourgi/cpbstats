package fr.cpbstats.dao.impl;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.ObjectifExerciceDao;
import fr.cpbstats.model.ObjectifExercice;

/**
 * The {@link ObjectifExerciceDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class ObjectifExerciceDaoImpl extends GenericDaoImpl<ObjectifExercice, Integer> implements
        ObjectifExerciceDao {

    /** {@inheritDoc} */
    @Override
    public List<ObjectifExercice> findAllByLogin(String login) {
        try {
            // TODO : Faire impl générique pour recherche par login pour objectif + exercice +
            // objectifEx
            TypedQuery<ObjectifExercice> query = getEntityManager().createQuery(
                    "from ObjectifExercice oe where oe.objectif.utilisateur.login = :login",
                    ObjectifExercice.class);
            query.setParameter("login", login);
            return query.getResultList();
        } catch (NoResultException e) {
            return null;
        }
    }

}
