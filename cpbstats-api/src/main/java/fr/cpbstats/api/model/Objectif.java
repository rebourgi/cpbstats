package fr.cpbstats.api.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * The {@link Exercice} class.
 * 
 * @author rebourgi
 * 
 */
@ApiModel
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Objectif {

    /** The id. */
    @ApiModelProperty(value = "Identifiant de l'objectif")
    private Integer id;

    /** The libelle. */
    @ApiModelProperty(value = "Libelle de l'objectif", required = true)
    private String libelle;

    @ApiModelProperty(value = "Date début", required = true)
    private Date dateDebut;

    @ApiModelProperty(value = "Date fin")
    private Date dateFin;

    /** The objectifExercices. */
    @ApiModelProperty(value = "Liste des exercices à effectuer")
    private List<ObjectifExercice> objectifExercices = new ArrayList<>();

    /**
     * Return the Objectif id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the Objectif id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Return the Objectif libelle.
     * 
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the Objectif libelle.
     * 
     * @param libelle
     *            the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Return the Objectif dateDebut.
     * 
     * @return the dateDebut
     */
    public Date getDateDebut() {
        return dateDebut;
    }

    /**
     * Set the Objectif dateDebut.
     * 
     * @param dateDebut
     *            the dateDebut to set
     */
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Return the Objectif dateFin.
     * 
     * @return the dateFin
     */
    public Date getDateFin() {
        return dateFin;
    }

    /**
     * Set the Objectif dateFin.
     * 
     * @param dateFin
     *            the dateFin to set
     */
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    /**
     * Return the Objectif objectifExercices.
     * 
     * @return the objectifExercices
     */
    public List<ObjectifExercice> getObjectifExercices() {
        return objectifExercices;
    }

    /**
     * Set the Objectif objectifExercices.
     * 
     * @param objectifExercices
     *            the objectifExercices to set
     */
    public void setObjectifExercices(List<ObjectifExercice> objectifExercices) {
        this.objectifExercices = objectifExercices;
    }

}
