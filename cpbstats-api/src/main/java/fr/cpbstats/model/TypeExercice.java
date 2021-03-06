package fr.cpbstats.model;

// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TypeExercice generated by hbm2java
 */
@Entity
@Table(name = "type_exercice")
public class TypeExercice implements java.io.Serializable {

    private int id;
    private String libelle;
    private String unite;
    private String format;
    private String description;
    private Set<ObjectifExercice> objectifExercices = new HashSet<ObjectifExercice>(0);
    private Set<Exercice> exercices = new HashSet<Exercice>(0);

    public TypeExercice() {}

    public TypeExercice(int id) {
        this.id = id;
    }

    public TypeExercice(int id, String libelle, String unite, String format, String description,
            Set<ObjectifExercice> objectifExercices, Set<Exercice> exercices) {
        this.id = id;
        this.libelle = libelle;
        this.unite = unite;
        this.format = format;
        this.description = description;
        this.objectifExercices = objectifExercices;
        this.exercices = exercices;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "libelle", length = 45)
    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Column(name = "unite", length = 20)
    public String getUnite() {
        return this.unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    @Column(name = "format", length = 45)
    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @Column(name = "description", length = 300)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "typeExercice")
    public Set<ObjectifExercice> getObjectifExercices() {
        return this.objectifExercices;
    }

    public void setObjectifExercices(Set<ObjectifExercice> objectifExercices) {
        this.objectifExercices = objectifExercices;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "typeExercice")
    public Set<Exercice> getExercices() {
        return this.exercices;
    }

    public void setExercices(Set<Exercice> exercices) {
        this.exercices = exercices;
    }

}
