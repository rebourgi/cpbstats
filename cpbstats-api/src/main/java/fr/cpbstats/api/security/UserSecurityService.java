package fr.cpbstats.api.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

/**
 * The {@link UserSecurityService} class.
 * 
 * @author rebourgi
 */
@Component(value = "userDetailsService")
public class UserSecurityService implements UserDetailsService {

    /** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSecurityService.class);

    /** {@inheritDoc} */
    @Override
    public UserDetails loadUserByUsername(String username) {
        LOGGER.info("username : {}", username);

        return null;
    }

}
