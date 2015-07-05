package fr.cpbstats.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.cpbstats.business.UtilisateurBusiness;
import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link UtilisateurBusinessImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Component
@Transactional
public class UtilisateurBusinessImpl implements UtilisateurBusiness {

    /** The utilisateurDao. */
    @Autowired
    private UtilisateurDao utilisateurDao;

    /** {@inheritDoc} */
    @Override
    public Utilisateur findUtilisateur(String login) {
        return utilisateurDao.findUtilisateurByLogin(login);
    }

}
