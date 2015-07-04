package fr.cpbstats.dao;

import fr.cpbstats.model.Utilisateur;

/**
 * The {@link UtilisateurDao} class.
 * 
 * @author rebourgi
 * 
 */
public interface UtilisateurDao extends GenericDao<Utilisateur, Integer> {

    /**
     * @param login
     *            the login
     * @return the user if it exist, null otherwise
     */
    Utilisateur findUtilisateurByLogin(String login);

}
