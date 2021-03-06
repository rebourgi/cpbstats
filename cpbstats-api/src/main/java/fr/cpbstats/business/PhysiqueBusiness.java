package fr.cpbstats.business;

import java.util.List;

import fr.cpbstats.model.Exercice;
import fr.cpbstats.model.Objectif;
import fr.cpbstats.model.ObjectifExercice;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link PhysiqueBusiness} class.
 * 
 * @author rebourgi
 * 
 */
public interface PhysiqueBusiness {

    /**
     * @param login
     * @return
     */
    List<Exercice> findAllExercicesByUser(String login);

    /**
     * @param login
     * @return
     */
    List<TypeExercice> findTypeExercicesByUser(String login);

    /**
     * @return
     */
    List<TypeExercice> findAllTypeExercices();

    /**
     * @param exercice
     */
    void addExercice(String login, Exercice exercice);

    /**
     * @param idExercice
     */
    void deleteExercice(int idExercice);

    /**
     * @param login
     * @return
     */
    List<Objectif> findObjectifsByUtilisateur(String login);

    /**
     * @param login
     * @param objectif
     */
    Objectif addObjectif(String login, Objectif objectif);

    /**
     * @param login
     * @param objectif
     */
    Objectif updateObjectif(Objectif objectif);

    /**
     * @param login
     * @param objectif
     */
    void deleteObjectif(int id);

    ObjectifExercice addObjectifExercice(String login, ObjectifExercice objectifExercice);

    ObjectifExercice updateObjectifExercice(ObjectifExercice objectifExercice);

    void deleteObjectifExercice(int id);
}
