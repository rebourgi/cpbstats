package fr.cpbstats.business;

import fr.cpbstats.model.Utilisateur;

/**
 * The {@link UtilisateurBusiness} class.
 * 
 * @author rebourgi
 * 
 */
public interface UtilisateurBusiness {

    /**
     * @param login
     * @return
     */
    Utilisateur findUtilisateur(String login);

}
