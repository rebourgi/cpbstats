package fr.cpbstats.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.cpbstats.business.PhysiqueBusiness;
import fr.cpbstats.dao.ExerciceDao;
import fr.cpbstats.dao.ObjectifDao;
import fr.cpbstats.dao.ObjectifExerciceDao;
import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.dao.UtilisateurDao;
import fr.cpbstats.model.Exercice;
import fr.cpbstats.model.Objectif;
import fr.cpbstats.model.ObjectifExercice;
import fr.cpbstats.model.TypeExercice;
import fr.cpbstats.model.Utilisateur;

/**
 * The {@link PhysiqueBusinessImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Component
@Transactional
public class PhysiqueBusinessImpl implements PhysiqueBusiness {

    /** The typeExerciceDao. */
    @Autowired
    private TypeExerciceDao typeExerciceDao;

    /** The exerciceDao. */
    @Autowired
    private ExerciceDao exerciceDao;

    /** The objectifDao. */
    @Autowired
    private ObjectifDao objectifDao;

    /** The objectifExerciceDao. */
    @Autowired
    private ObjectifExerciceDao objectifExerciceDao;

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
    public List<TypeExercice> findTypeExercicesByUser(String login) {
        return typeExerciceDao.findAll();
    }

    /** {@inheritDoc} */
    @Override
    public void addExercice(String login, Exercice exercice) {
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

    /** {@inheritDoc} */
    @Override
    public List<Objectif> findObjectifsByUtilisateur(String login) {
        return objectifDao.findAllByLogin(login);
    }

    /** {@inheritDoc} */
    @Override
    public Objectif addObjectif(String login, Objectif objectif) {
        Utilisateur utilisateur = utilisateurDao.findUtilisateurByLogin(login);
        objectif.setUtilisateur(utilisateur);
        objectif.setObjectifExercices(null);
        objectifDao.persist(objectif);
        return objectif;
    }

    /** {@inheritDoc} */
    @Override
    public Objectif updateObjectif(Objectif objectif) {
        return objectifDao.merge(objectif);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteObjectif(int id) {
        objectifDao.remove(objectifDao.find(id));
    }

    /** {@inheritDoc} */
    @Override
    public ObjectifExercice addObjectifExercice(String login, ObjectifExercice objectifExercice) {
        objectifExerciceDao.persist(objectifExercice);
        return objectifExercice;
    }

    /** {@inheritDoc} */
    @Override
    public ObjectifExercice updateObjectifExercice(ObjectifExercice objectifExercice) {
        return objectifExerciceDao.merge(objectifExercice);
    }

    /** {@inheritDoc} */
    @Override
    public void deleteObjectifExercice(int id) {
        objectifExerciceDao.remove(objectifExerciceDao.find(id));
    }

}
