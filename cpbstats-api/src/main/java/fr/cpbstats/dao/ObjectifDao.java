package fr.cpbstats.dao;

import java.util.List;

import fr.cpbstats.model.Objectif;

/**
 * The {@link ObjectifDao} class.
 * 
 * @author rebourgi
 * 
 */
public interface ObjectifDao extends GenericDao<Objectif, Integer> {

    /**
     * @param login
     *            the login
     * @return the list of Objectifs if it exist, null otherwise
     */
    List<Objectif> findAllByLogin(String login);

}
