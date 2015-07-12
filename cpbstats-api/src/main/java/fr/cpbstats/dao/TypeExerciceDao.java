package fr.cpbstats.dao;

import java.util.List;

import fr.cpbstats.model.TypeExercice;

/**
 * The {@link TypeExerciceDao} class.
 * 
 * @author rebourgi
 * 
 */
public interface TypeExerciceDao extends GenericDao<TypeExercice, Integer> {

    /**
     * @param login
     * @return
     */
    List<TypeExercice> findTypeExercicesByUser(String login);

}
