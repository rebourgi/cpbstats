package fr.cpbstats.api.services;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import fr.cpbstats.dao.ExerciceDao;
import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Exercice;
import fr.cpbstats.model.TypeExercice;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link ExerciceApi} class.
 * 
 * @author rebourgi
 * 
 */
@Path("/exercices")
@Transactional
@Api(value = "Exercices", description = "API pour les exercices")
public class ExerciceApi {

    /** The typeExerciceDao. */
    @Autowired
    private TypeExerciceDao typeExerciceDao;

    /** The exerciceDao. */
    @Autowired
    private ExerciceDao exerciceDao;

    /** The utilisateurDao. */
    @Autowired
    private UtilisateurDao utilisateurDao;

    /**
     * @return
     */
    @GET
    @Path("/types")
    @ApiOperation("Liste des types d'exercices")
    public List<TypeExercice> getTypeExercices() {
        return typeExerciceDao.findAll();
    }

    /**
     * @return
     */
    @GET
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public List<Exercice> getExercices() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return exerciceDao.findAllByUser(securityContext.getAuthentication().getName());
    }

    @POST
    @ApiOperation("Eregistre un exercice")
    public void addExercices(Exercice exercice) {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        // TODO : Rajouter utilisateur dans auth
        Utilisateur utilisateur = utilisateurDao.findUtilisateurByLogin(securityContext
                .getAuthentication().getName());
        exercice.setUtilisateur(utilisateur);
        exerciceDao.persist(exercice);
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("Liste des exercices de l'utilisateur authentifié")
    public void deleteExercices(@PathParam("id") int id) {
        // TODO : Vérification pour notFoundException
        exerciceDao.remove(exerciceDao.find(id));
    }
}
