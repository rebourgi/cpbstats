package fr.cpbstats.api.services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;

import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link ExerciceApi} class.
 * 
 * @author rebourgi
 * 
 */
@Path("/exercices")
public class ExerciceApi {

    /** The typeExerciceDao. */
    @Autowired
    private TypeExerciceDao typeExerciceDao;

    @GET
    @Path("/types")
    public List<TypeExercice> getTypeExercices() {
        return typeExerciceDao.findAll();
    }

}
