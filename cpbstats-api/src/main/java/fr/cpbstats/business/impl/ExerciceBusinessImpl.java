package fr.cpbstats.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.cpbstats.business.ExerciceBusiness;
import fr.cpbstats.dao.ExerciceDao;
import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Exercice;
import fr.cpbstats.model.TypeExercice;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link ExerciceBusinessImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Component
@Transactional
public class ExerciceBusinessImpl implements ExerciceBusiness {

    /** The typeExerciceDao. */
    @Autowired
    private TypeExerciceDao typeExerciceDao;

    /** The exerciceDao. */
    @Autowired
    private ExerciceDao exerciceDao;

    /** The utilisateurDao. */
    @Autowired
    private UtilisateurDao utilisateurDao;

    /** {@inheritDoc} */
    @Override
    public List<Exercice> findAllExercicesByUser(String login) {
        return exerciceDao.findAllByUser(login);
    }

    /** {@inheritDoc} */
    @Override
    public List<TypeExercice> findAllTypeExercices() {
        return typeExerciceDao.findAll();
    }

    /** {@inheritDoc} */
    @Override
    public void addExercice(Exercice exercice, String login) {
        Utilisateur utilisateur = utilisateurDao.findUtilisateurByLogin(login);
        exercice.setUtilisateur(utilisateur);
        // TODO : effectuer verif avec typeExercice.format
        exerciceDao.persist(exercice);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteExercice(int idExercice) {
        exerciceDao.remove(exerciceDao.find(idExercice));
    }

}
