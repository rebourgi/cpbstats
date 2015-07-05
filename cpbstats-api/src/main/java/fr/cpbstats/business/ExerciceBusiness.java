package fr.cpbstats.business;

import java.util.List;

import fr.cpbstats.model.Exercice;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link ExerciceBusiness} class.
 * 
 * @author rebourgi
 * 
 */
public interface ExerciceBusiness {

    /**
     * @param login
     * @return
     */
    List<Exercice> findAllExercicesByUser(String login);

    /**
     * @return
     */
    List<TypeExercice> findAllTypeExercices();

    /**
     * @param exercice
     */
    void addExercice(Exercice exercice, String login);

    /**
     * @param idExercice
     */
    void deleteExercice(int idExercice);

}
