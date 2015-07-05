package fr.cpbstats.api.model;

import java.util.Date;

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
public class Exercice {

    /** The id. */
    @ApiModelProperty(value = "Identifiant de l'exercice")
    private Integer id;

    /** The typeExerciceId. */
    @ApiModelProperty(value = "Identifiant du type d'exercice")
    private Integer typeExerciceId;

    /** The donnee. */
    @ApiModelProperty(value = "Donnee")
    private String data;

    /** The date. */
    @ApiModelProperty(value = "Date")
    private Date date;

    /**
     * Return the Exercice id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the Exercice id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Return the Exercice typeExerciceId.
     * 
     * @return the typeExerciceId
     */
    public Integer getTypeExerciceId() {
        return typeExerciceId;
    }

    /**
     * Set the Exercice typeExerciceId.
     * 
     * @param typeExerciceId
     *            the typeExerciceId to set
     */
    public void setTypeExerciceId(Integer typeExerciceId) {
        this.typeExerciceId = typeExerciceId;
    }

    /**
     * Return the Exercice data.
     * 
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * Set the Exercice data.
     * 
     * @param data
     *            the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * Return the Exercice date.
     * 
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Set the Exercice date.
     * 
     * @param date
     *            the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

}
