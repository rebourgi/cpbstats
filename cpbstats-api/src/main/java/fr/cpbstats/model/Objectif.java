package fr.cpbstats.model;

// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Objectif generated by hbm2java
 */
@Entity
@Table(name = "objectif")
public class Objectif implements java.io.Serializable {

    private int id;
    private Utilisateur utilisateur;
    private String libelle;
    private Set<ObjectifExercice> objectifExercices = new HashSet<ObjectifExercice>(0);

    public Objectif() {}

    public Objectif(int id, Utilisateur utilisateur) {
        this.id = id;
        this.utilisateur = utilisateur;
    }

    public Objectif(int id, Utilisateur utilisateur, String libelle,
            Set<ObjectifExercice> objectifExercices) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.libelle = libelle;
        this.objectifExercices = objectifExercices;
    }

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Column(name = "libelle", length = 145)
    public String getLibelle() {
        return this.libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "objectif")
    public Set<ObjectifExercice> getObjectifExercices() {
        return this.objectifExercices;
    }

    public void setObjectifExercices(Set<ObjectifExercice> objectifExercices) {
        this.objectifExercices = objectifExercices;
    }

}