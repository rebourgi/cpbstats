package fr.cpbstats.dao;

import java.util.List;

import fr.cpbstats.model.ObjectifExercice;

/**
 * The {@link ObjectifExerciceDao} class.
 * 
 * @author rebourgi
 * 
 */
public interface ObjectifExerciceDao extends GenericDao<ObjectifExercice, Integer> {

    /**
     * @param login
     *            the login
     * @return the list of Objectifs if it exist, null otherwise
     */
    List<ObjectifExercice> findAllByLogin(String login);

}
