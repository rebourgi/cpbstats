package fr.cpbstats.api.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The {@link ApiExceptionMapper} class.
 * 
 * @author rebourgi
 */
@Provider
public class ApiExceptionMapper implements ExceptionMapper<Exception> {

    /** The LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionMapper.class);

    /** {@inheritDoc} */
    @Override
    public Response toResponse(Exception exception) {
        LOGGER.error("Erreur lors de l'appel au APIs Rest", exception);
        Response response = Response.serverError().build();
        // Si on gere explicitement une exception Rest, on renvoi le statut
        // renseign�.
        if (exception instanceof WebApplicationException) {
            response = ((WebApplicationException) exception).getResponse();
        }
        return response;
    }
}
