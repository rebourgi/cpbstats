package fr.cpbstats.api.model;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * The {@link TypeExercice} class.
 * 
 * @author rebourgi
 * 
 */
@ApiModel
public class TypeExercice {

    /** The id. */
    @ApiModelProperty(value = "Identifiant du type d'exercice")
    private Integer id;

    /** The libelle. */
    @ApiModelProperty(value = "Libelle du type d'exercice")
    private String libelle;

    /** The unite. */
    @ApiModelProperty(value = "Unité")
    private String unite;

    /** The format. */
    @ApiModelProperty(value = "Format de validation")
    private String format;

    /** The description. */
    @ApiModelProperty(value = "Description du type d'exercice")
    private String description;

    /**
     * Return the TypeExercice id.
     * 
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Set the TypeExercice id.
     * 
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Return the TypeExercice libelle.
     * 
     * @return the libelle
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * Set the TypeExercice libelle.
     * 
     * @param libelle
     *            the libelle to set
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * Return the TypeExercice unite.
     * 
     * @return the unite
     */
    public String getUnite() {
        return unite;
    }

    /**
     * Set the TypeExercice unite.
     * 
     * @param unite
     *            the unite to set
     */
    public void setUnite(String unite) {
        this.unite = unite;
    }

    /**
     * Return the TypeExercice format.
     * 
     * @return the format
     */
    public String getFormat() {
        return format;
    }

    /**
     * Set the TypeExercice format.
     * 
     * @param format
     *            the format to set
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Return the TypeExercice description.
     * 
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the TypeExercice description.
     * 
     * @param description
     *            the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
