package fr.cpbstats.model;

// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * ObjectifExercice generated by hbm2java
 */
@Entity
@Table(name = "objectif_exercice")
public class ObjectifExercice implements java.io.Serializable {

    private ObjectifExerciceId id;
    private TypeExercice typeExercice;
    private Objectif objectif;
    private String data;
    private String date;
    private Boolean recurrentSemaine;
    private Boolean recurrentMois;

    public ObjectifExercice() {}

    public ObjectifExercice(ObjectifExerciceId id, TypeExercice typeExercice, Objectif objectif) {
        this.id = id;
        this.typeExercice = typeExercice;
        this.objectif = objectif;
    }

    public ObjectifExercice(ObjectifExerciceId id, TypeExercice typeExercice, Objectif objectif,
            String data, String date, Boolean recurrentSemaine, Boolean recurrentMois) {
        this.id = id;
        this.typeExercice = typeExercice;
        this.objectif = objectif;
        this.data = data;
        this.date = date;
        this.recurrentSemaine = recurrentSemaine;
        this.recurrentMois = recurrentMois;
    }

    @EmbeddedId
    @AttributeOverrides({
            @AttributeOverride(name = "objectifId", column = @Column(name = "objectif_id",
                    nullable = false)),
            @AttributeOverride(name = "typeExerciceId", column = @Column(name = "type_exercice_id",
                    nullable = false)) })
    public ObjectifExerciceId getId() {
        return this.id;
    }

    public void setId(ObjectifExerciceId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_exercice_id", nullable = false, insertable = false, updatable = false)
    public TypeExercice getTypeExercice() {
        return this.typeExercice;
    }

    public void setTypeExercice(TypeExercice typeExercice) {
        this.typeExercice = typeExercice;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "objectif_id", nullable = false, insertable = false, updatable = false)
    public Objectif getObjectif() {
        return this.objectif;
    }

    public void setObjectif(Objectif objectif) {
        this.objectif = objectif;
    }

    @Column(name = "data", length = 45)
    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Column(name = "date", length = 45)
    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Column(name = "recurrent_semaine")
    public Boolean getRecurrentSemaine() {
        return this.recurrentSemaine;
    }

    public void setRecurrentSemaine(Boolean recurrentSemaine) {
        this.recurrentSemaine = recurrentSemaine;
    }

    @Column(name = "recurrent_mois")
    public Boolean getRecurrentMois() {
        return this.recurrentMois;
    }

    public void setRecurrentMois(Boolean recurrentMois) {
        this.recurrentMois = recurrentMois;
    }

}