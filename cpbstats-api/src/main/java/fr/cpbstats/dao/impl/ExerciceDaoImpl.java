package fr.cpbstats.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.ExerciceDao;
import fr.cpbstats.model.Exercice;

/**
 * The {@link ExerciceDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class ExerciceDaoImpl extends GenericDaoImpl<Exercice, Integer> implements ExerciceDao {

    /** {@inheritDoc} */
    @Override
    public List<Exercice> findAllByUser(String login) {
        TypedQuery<Exercice> query = getEntityManager().createQuery(
                "from Exercice e where e.utilisateur.login = :login", Exercice.class);
        query.setParameter("login", login);
        return query.getResultList();
    }
}
