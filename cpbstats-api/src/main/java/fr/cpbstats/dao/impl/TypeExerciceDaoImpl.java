package fr.cpbstats.dao.impl;

import org.springframework.stereotype.Repository;

import fr.cpbstats.dao.TypeExerciceDao;
import fr.cpbstats.model.TypeExercice;

/**
 * The {@link TypeExerciceDaoImpl} class.
 * 
 * @author rebourgi
 * 
 */
@Repository
public class TypeExerciceDaoImpl extends GenericDaoImpl<TypeExercice, Integer> implements
        TypeExerciceDao {

}
