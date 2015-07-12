package fr.cpbstats.api.model;

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
public class ObjectifExercice {

    @ApiModelProperty(value = "Identifiant du type d'exercice")
    private Integer idTypeExercice;

    @ApiModelProperty(value = "Type d'exercice")
    private String libelleTypeExercice;

    @ApiModelProperty(value = "Donnée")
    private String data;

    @ApiModelProperty(value = "Date")
    private String date;

    @ApiModelProperty(value = "Récurrent toutes les semaines ou non")
    private Boolean recurrentSemaine;

    @ApiModelProperty(value = "Récurrent toutes les mois ou non")
    private Boolean recurrentMois;

    /**
     * Return the ObjectifExercice idTypeExercice.
     * 
     * @return the idTypeExercice
     */
    public Integer getIdTypeExercice() {
        return idTypeExercice;
    }

    /**
     * Set the ObjectifExercice idTypeExercice.
     * 
     * @param idTypeExercice
     *            the idTypeExercice to set
     */
    public void setIdTypeExercice(Integer idTypeExercice) {
        this.idTypeExercice = idTypeExercice;
    }

    /**
     * Return the ObjectifExercice libelleTypeExercice.
     * 
     * @return the libelleTypeExercice
     */
    public String getLibelleTypeExercice() {
        return libelleTypeExercice;
    }

    /**
     * Set the ObjectifExercice libelleTypeExercice.
     * 
     * @param libelleTypeExercice
     *            the libelleTypeExercice to set
     */
    public void setLibelleTypeExercice(String libelleTypeExercice) {
        this.libelleTypeExercice = libelleTypeExercice;
    }

    /**
     * Return the ObjectifExercice data.
     * 
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Set the ObjectifExercice data.
     * 
     * @param data
     *            the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Return the ObjectifExercice date.
     * 
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * Set the ObjectifExercice date.
     * 
     * @param date
     *            the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Return the ObjectifExercice recurrentSemaine.
     * 
     * @return the recurrentSemaine
     */
    public Boolean getRecurrentSemaine() {
        return recurrentSemaine;
    }

    /**
     * Set the ObjectifExercice recurrentSemaine.
     * 
     * @param recurrentSemaine
     *            the recurrentSemaine to set
     */
    public void setRecurrentSemaine(Boolean recurrentSemaine) {
        this.recurrentSemaine = recurrentSemaine;
    }

    /**
     * Return the ObjectifExercice recurrentMois.
     * 
     * @return the recurrentMois
     */
    public Boolean getRecurrentMois() {
        return recurrentMois;
    }

    /**
     * Set the ObjectifExercice recurrentMois.
     * 
     * @param recurrentMois
     *            the recurrentMois to set
     */
    public void setRecurrentMois(Boolean recurrentMois) {
        this.recurrentMois = recurrentMois;
    }

}
