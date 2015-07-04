package fr.cpbstats.api.security;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link UserSecurityService} class.
 * 
 * @author rebourgi
 */
@Component(value = "userDetailsService")
public class UserSecurityService implements UserDetailsService {

    /** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityService.class);

    /** The utilisateurDao. */
    @Autowired
    private UtilisateurDao utilisateurDao;

    /** {@inheritDoc} */
    @Override
    public UserDetails loadUserByUsername(String username) {
        LOGGER.info("username : {}", username);
        Utilisateur utilisateur = utilisateurDao.findUtilisateurByLogin(username);

        if (utilisateur != null) {
            LOGGER.info("Utilisateur trouvé");
            List<SimpleGrantedAuthority> authority = new ArrayList<SimpleGrantedAuthority>();
            return new User(utilisateur.getLogin(), utilisateur.getPassword(), authority);
        } else {
            LOGGER.info("Utilisateur non trouvé");
            throw new UsernameNotFoundException("User not found");
        }
    }

}
