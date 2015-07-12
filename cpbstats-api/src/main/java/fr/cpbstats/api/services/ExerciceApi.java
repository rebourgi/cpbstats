package fr.cpbstats.api.services;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import fr.cpbstats.api.model.TypeExercice;
import fr.cpbstats.business.PhysiqueBusiness;

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
    private PhysiqueBusiness exerciceBusiness;

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
        // TODO : A déplacer dans type API ?
        List<TypeExercice> typeExercices = new ArrayList<TypeExercice>();
        for (fr.cpbstats.model.TypeExercice typeExercice : exerciceBusiness.findAllTypeExercices()) {
            typeExercices.add(mapper.map(typeExercice, TypeExercice.class));
        }
        return typeExercices;
    }

}
