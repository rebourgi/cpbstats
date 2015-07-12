package fr.cpbstats.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link TypeExerciceDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class TypeExerciceDaoImpl extends GenericDaoImpl<TypeExercice, Integer> implements
        TypeExerciceDao {

    @Override
    public List<TypeExercice> findTypeExercicesByUser(String login) {
        TypedQuery<TypeExercice> query = getEntityManager().createQuery(
                "from TypeExercice t where t.exercices.utilisateur.login = :login",
                TypeExercice.class);
        query.setParameter("login", login);
        return query.getResultList();
    }

}
