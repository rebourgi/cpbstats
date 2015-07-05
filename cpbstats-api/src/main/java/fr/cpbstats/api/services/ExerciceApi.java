package fr.cpbstats.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import fr.cpbstats.api.model.Exercice;
import fr.cpbstats.api.model.TypeExercice;
import fr.cpbstats.business.ExerciceBusiness;

/**
 * The {@link ExerciceApi} class.
 * 
 * @author rebourgi
 * 
 */
@Path("/exercices")
@Api(value = "Exercices", description = "API pour les exercices")
public class ExerciceApi {

    /** The exerciceBusiness. */
    @Autowired
    private ExerciceBusiness exerciceBusiness;

    /** The mapper. */
    @Autowired
    private Mapper mapper;

    /**
     * @return
     */
    @GET
    @Path("/types")
    @ApiOperation("Liste des types d'exercices")
    public List<TypeExercice> getTypeExercices() {
        List<TypeExercice> typeExercices = new ArrayList<TypeExercice>();
        for (fr.cpbstats.model.TypeExercice typeExercice : exerciceBusiness.findAllTypeExercices()) {
            typeExercices.add(mapper.map(typeExercice, TypeExercice.class));
        }
        return typeExercices;
    }

    /**
     * @return
     */
    @GET
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public List<Exercice> getExercices() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<fr.cpbstats.model.Exercice> listeExercices = exerciceBusiness
                .findAllExercicesByUser(securityContext.getAuthentication().getName());
        List<Exercice> listeRetour = new ArrayList<Exercice>();
        for (fr.cpbstats.model.Exercice exercice : listeExercices) {
            listeRetour.add(mapper.map(exercice, Exercice.class));
        }
        return listeRetour;
    }

    @POST
    @ApiOperation("Eregistre un exercice")
    public void addExercices(@ApiParam("Exercice à sauvegarder") Exercice exercice) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // TODO : Rajouter utilisateur dans auth
        exerciceBusiness.addExercice(mapper.map(exercice, fr.cpbstats.model.Exercice.class),
                securityContext.getAuthentication().getName());
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public void deleteExercices(@PathParam("id") int id) {
        // TODO : Vérification pour notFoundException
        exerciceBusiness.deleteExercice(id);
    }
}
