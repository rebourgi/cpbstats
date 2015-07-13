package fr.cpbstats.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import fr.cpbstats.api.model.Chart;
import fr.cpbstats.api.model.Exercice;
import fr.cpbstats.api.model.Objectif;
import fr.cpbstats.api.model.ObjectifExercice;
import fr.cpbstats.business.PhysiqueBusiness;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link UserDataApi} class.
 * 
 * @author rebourgi
 * 
 */
@Path("/userData")
@Api(value = "User Data", description = "API pour les données utilisateur")
public class UserDataApi {

    /** The exerciceBusiness. */
    @Autowired
    private PhysiqueBusiness physiqueBusiness;

    /** The mapper. */
    @Autowired
    private Mapper mapper;

    @GET
    @Path("/types")
    @ApiOperation("Liste des types d'exercices")
    public Chart getTypeExercicesData() {
        // TODO : API Chart
        SecurityContext securityContext = SecurityContextHolder.getContext();
        String login = securityContext.getAuthentication().getName();
        List<TypeExercice> typesExercices = physiqueBusiness.findTypeExercicesByUser(login);
        Chart chart = new Chart();
        for (fr.cpbstats.model.TypeExercice typeExercice : typesExercices) {
            chart.getData().add(Integer.toString(typeExercice.getExercices().size()));
            chart.getLabels().add(typeExercice.getLibelle());
        }
        return chart;
    }

    /**
     * @return
     */
    @GET
    @Path("/exercices")
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public List<Exercice> getExercices() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<fr.cpbstats.model.Exercice> listeExercices = physiqueBusiness
                .findAllExercicesByUser(securityContext.getAuthentication().getName());
        List<Exercice> listeRetour = new ArrayList<Exercice>();
        for (fr.cpbstats.model.Exercice exercice : listeExercices) {
            listeRetour.add(mapper.map(exercice, Exercice.class));
        }
        return listeRetour;
    }

    @GET
    @Path("/objectifs")
    @ApiOperation("Liste des objectifs de l'utilisateur authentifié")
    public List<Objectif> getObjectifs() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        List<fr.cpbstats.model.Objectif> listeObjectifs = physiqueBusiness
                .findObjectifsByUtilisateur(securityContext.getAuthentication().getName());

        List<Objectif> listeRetour = new ArrayList<Objectif>();
        for (fr.cpbstats.model.Objectif objectif : listeObjectifs) {
            listeRetour.add(mapper.map(objectif, Objectif.class));
        }
        return listeRetour;
    }

    @POST
    @Path("/objectifs")
    @ApiOperation("Enregistre un objectif")
    public Integer addObjectif(@ApiParam("Objectif à sauvegarder") Objectif objectif) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        fr.cpbstats.model.Objectif obj = physiqueBusiness.addObjectifs(securityContext
                .getAuthentication().getName(), mapper.map(objectif,
                fr.cpbstats.model.Objectif.class));

        return obj.getId();
    }

    @POST
    @Path("/objectifs/exercices")
    @ApiOperation("Exercice de l'objectif à sauvegarder")
    public Integer addObjectifExercice(
            @ApiParam("Objectif à sauvegarder") ObjectifExercice objectifExercice) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // TODO
        return 0;
    }

    @PUT
    @Path("/objectifs/exercices")
    @ApiOperation("Enregistre un objectif")
    public void updateObjectifExercice(
            @ApiParam("Exercice de l'objectif à sauvegarder") ObjectifExercice objectifExercice) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // TODO
    }

    @DELETE
    @Path("/objectifs/{id}")
    @ApiOperation("Suppression de l'objectif pour l'utilisateur authentifié")
    public void deleteObjectif(@PathParam("id") int id) {
        // TODO : Vérification pour notFoundException
        physiqueBusiness.deleteObjectif(id);
    }

    @POST
    @Path("/exercices")
    @ApiOperation("Eregistre un exercice")
    public void addExercices(@ApiParam("Exercice à sauvegarder") Exercice exercice) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // TODO : Rajouter utilisateur dans auth
        physiqueBusiness.addExercice(securityContext.getAuthentication().getName(),
                mapper.map(exercice, fr.cpbstats.model.Exercice.class));
    }

    @DELETE
    @Path("/exercices/{id}")
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public void deleteExercices(@PathParam("id") int id) {
        // TODO : Vérification pour notFoundException
        physiqueBusiness.deleteExercice(id);
    }
}
