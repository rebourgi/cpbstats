package fr.cpbstats.dao;

import java.util.List;

/**
 * Interface generique pour les service JPA
 * <p>
 * Toutes les exceptions sont de type RuntimeException (@see
 * org.springframework.dao.DataAccessException)
 * 
 * @author rebourgi
 * 
 * @param <T,PK> Table et primary key
 */
public interface GenericDao<T, P> {

	/**
	 * Synchronise objects entityManager dans la base
	 * 
	 */
	void flush();

	/**
	 * Refresh object persistant
	 * 
	 * @param o
	 */
	void refresh(T o);

	/**
	 * Persist un object dans la base
	 * 
	 * @param o
	 *            l'objet persistant � enregistrer
	 */
	void persist(T o);

	/**
	 * Merge un object dans la base
	 * 
	 * @param o
	 *            l'objet persistant � enregistrer
	 * 
	 */
	T merge(T o);

	/**
	 * Supprime un objet en base
	 * 
	 * @param o
	 *            l'objet persistant � supprimer
	 */
	void remove(T o);

	/**
	 * Charge un objet persistant � partir d'un id, retourne null si il n'existe
	 * pas
	 * 
	 * @param id
	 *            l'id de l'objet persistant
	 * @return T l'objet persistant trouv� en base
	 */
	T find(P id);

	/**
	 * Charge un objet persistant � partir d'un id, retourne une exception si il
	 * n'existe pas
	 * 
	 * @param id
	 *            l'id de l'objet persistant
	 * @return T l'objet persistant trouv� en base
	 */
	T getReference(P id);

	/**
	 * Charge tous les objets
	 * 
	 * @return List liste des objets
	 */
	List<T> findAll();

	/**
	 * 
	 * R�cup�ration de tous les objets par ordre
	 * 
	 * @param filter
	 *            filtre � utiliser
	 * @param asc
	 *            true pour asc, false pour desc
	 * @return List liste des objets
	 */
	List<T> findAllOrderBy(String filter, boolean asc);

}
