package fr.cpbstats.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link UtilisateurDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur, Integer> implements
        UtilisateurDao {

    /** {@inheritDoc} */
    @Override
    public Utilisateur findUtilisateurByLogin(String login) {
        try {
            TypedQuery<Utilisateur> query = getEntityManager().createQuery(
                    "from Utilisateur u where u.login = :login", Utilisateur.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

}
