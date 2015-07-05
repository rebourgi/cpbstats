package fr.cpbstats.api.services;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import fr.cpbstats.api.model.UserGroup;
import fr.cpbstats.business.UtilisateurBusiness;
import fr.cpbstats.model.Utilisateur;

/**
 * @author hkaramok
 * 
 */
@Path("/authentication")
@Api(value = "Authentication",
        description = "Restful Web Service to manage the log in and the log out")
public class SecurityApiService {

    /** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityApiService.class);

    /** The mapper. */
    @Autowired
    private DozerBeanMapper mapper;

    /** The authenticationManager. */
    @Autowired
    protected AuthenticationManager authenticationManager;

    /** The utilisateurBusiness. */
    @Autowired
    protected UtilisateurBusiness utilisateurBusiness;

    /**
     * Allows user to log in. If the given information are not correct, the operation fails.
     * However, if in success, the service returns the user and the list of his groups.
     * 
     * @param httpRequest
     *            Request Information context.
     * @param username
     *            User's login.
     * @param password
     *            User's password.
     * 
     * @return Request state.
     * 
     * @throws BadCredentialsException
     *             when the username or the password is wrong.
     * 
     * @throws MappingException
     *             when trying to return the result.
     */
    @GET
    @Path("/login")
    @ApiOperation("Login")
    @ApiResponses(value = { @ApiResponse(code = 403, message = "Forbidden") })
    public UserGroup login(@Context HttpServletRequest httpRequest,
            @ApiParam("Username") @QueryParam("username") String username,
            @ApiParam("User's password") @QueryParam("password") String password) {

        try {
            SecurityContext securityContext = SecurityContextHolder.getContext();
            LOGGER.debug("Security context : {}", securityContext);

            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                    username, password);
            Authentication authentication = authenticationManager.authenticate(token);
            securityContext.setAuthentication(authentication);

            httpRequest.getSession().setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    securityContext);

            // TODO : Mettre utilisateur dans authent

            Utilisateur utilisateur = utilisateurBusiness.findUtilisateur(username);

            return mapper.map(utilisateur, UserGroup.class);

        } catch (BadCredentialsException bce) {
            LOGGER.error("Authentication failed.", bce);
            throw new ForbiddenException();
        } catch (MappingException me) {
            LOGGER.error("The response cannot be return because of the mapper", me);
            throw new InternalServerErrorException();
        }
    }

    /**
     * Allows user to log out.
     * 
     * @param httpRequest
     *            Request Information context.
     * 
     * @return Request state.
     */
    @GET
    @Path("/logout")
    @ApiOperation("Logout")
    @ApiResponses(value = { @ApiResponse(code = 403, message = "Forbidden") })
    public Response logout(@Context HttpServletRequest httpRequest) {

        SecurityContext securityContext = SecurityContextHolder.getContext();
        LOGGER.debug("Security context before : {}", securityContext);

        if (securityContext != null) {
            LOGGER.info("Log out succeeded");
            httpRequest.getSession().removeAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
            securityContext.setAuthentication(null);
        }
        LOGGER.debug("Security context after : {}", securityContext);
        return Response.ok().build();
    }

    @GET
    @Path("/status")
    @ApiOperation("Statut")
    @ApiResponses(value = { @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 500, message = "Error") })
    public Response status() {
        try {
            SecurityContextHolder.getContext().getAuthentication();
            return Response.ok().build();
        } catch (BadCredentialsException e) {
            throw new ForbiddenException();
        }
    }
}
