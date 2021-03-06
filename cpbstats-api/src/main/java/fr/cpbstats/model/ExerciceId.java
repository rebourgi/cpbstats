package fr.cpbstats.model;

// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;

/**
 * ExerciceId generated by hbm2java
 */
@Embeddable
public class ExerciceId implements java.io.Serializable {

    /** The serialVersionUID. */
    private static final long serialVersionUID = 1259394849723339982L;

    private int id;

    private int typeExerciceId;

    public ExerciceId() {}

    public ExerciceId(int id, int typeExerciceId) {
        this.id = id;
        this.typeExerciceId = typeExerciceId;
    }

    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", nullable = false)
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "type_exercice_id", nullable = false)
    public int getTypeExerciceId() {
        return this.typeExerciceId;
    }

    public void setTypeExerciceId(int typeExerciceId) {
        this.typeExerciceId = typeExerciceId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof ExerciceId))
            return false;
        ExerciceId castOther = (ExerciceId) other;

        return (this.getId() == castOther.getId())
                && (this.getTypeExerciceId() == castOther.getTypeExerciceId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getId();
        result = 37 * result + this.getTypeExerciceId();
        return result;
    }

}
