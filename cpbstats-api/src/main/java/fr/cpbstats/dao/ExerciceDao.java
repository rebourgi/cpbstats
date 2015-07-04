package fr.cpbstats.dao;

import java.util.List;

import fr.cpbstats.model.Exercice;

/**
 * The {@link ExerciceDao} class.
 * 
 * @author rebourgi
 * 
 */
public interface ExerciceDao extends GenericDao<Exercice, Integer> {

    // TODO : renvoyer liste par criteres
    /**
     * @param login
     *            the login
     * @return the list of exercice for the user
     */
    List<Exercice> findAllByUser(String login);

}
