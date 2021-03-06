package fr.cpbstats.model;

// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Rencontre generated by hbm2java
 */
@Entity
@Table(name = "rencontre")
public class Rencontre implements java.io.Serializable {

    private int id;
    private Utilisateur utilisateur;
    private String nom;
    private String prenom;
    private String classement;
    private Boolean victoire;
    private String analysePositive;
    private String analyseNegative;

    public Rencontre() {}

    public Rencontre(int id, Utilisateur utilisateur) {
        this.id = id;
        this.utilisateur = utilisateur;
    }

    public Rencontre(int id, Utilisateur utilisateur, String nom, String prenom, String classement,
            Boolean victoire, String analysePositive, String analyseNegative) {
        this.id = id;
        this.utilisateur = utilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.classement = classement;
        this.victoire = victoire;
        this.analysePositive = analysePositive;
        this.analyseNegative = analyseNegative;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "utilisateur_id", nullable = false)
    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Column(name = "nom", length = 45)
    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name = "prenom", length = 45)
    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name = "classement", length = 45)
    public String getClassement() {
        return this.classement;
    }

    public void setClassement(String classement) {
        this.classement = classement;
    }

    @Column(name = "victoire")
    public Boolean getVictoire() {
        return this.victoire;
    }

    public void setVictoire(Boolean victoire) {
        this.victoire = victoire;
    }

    @Column(name = "analyse_positive", length = 16777215)
    public String getAnalysePositive() {
        return this.analysePositive;
    }

    public void setAnalysePositive(String analysePositive) {
        this.analysePositive = analysePositive;
    }

    @Column(name = "analyse_negative", length = 16777215)
    public String getAnalyseNegative() {
        return this.analyseNegative;
    }

    public void setAnalyseNegative(String analyseNegative) {
        this.analyseNegative = analyseNegative;
    }

}
