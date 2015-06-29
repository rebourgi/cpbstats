package fr.cpbstats.model;
// Generated 29 juin 2015 23:26:12 by Hibernate Tools 3.2.2.GA


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ObjectifExerciceId generated by hbm2java
 */
@Embeddable
public class ObjectifExerciceId  implements java.io.Serializable {


     private int objectifId;
     private int typeExerciceId;

    public ObjectifExerciceId() {
    }

    public ObjectifExerciceId(int objectifId, int typeExerciceId) {
       this.objectifId = objectifId;
       this.typeExerciceId = typeExerciceId;
    }
   

    @Column(name="objectif_id", nullable=false)
    public int getObjectifId() {
        return this.objectifId;
    }
    
    public void setObjectifId(int objectifId) {
        this.objectifId = objectifId;
    }

    @Column(name="type_exercice_id", nullable=false)
    public int getTypeExerciceId() {
        return this.typeExerciceId;
    }
    
    public void setTypeExerciceId(int typeExerciceId) {
        this.typeExerciceId = typeExerciceId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ObjectifExerciceId) ) return false;
		 ObjectifExerciceId castOther = ( ObjectifExerciceId ) other; 
         
		 return (this.getObjectifId()==castOther.getObjectifId())
 && (this.getTypeExerciceId()==castOther.getTypeExerciceId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getObjectifId();
         result = 37 * result + this.getTypeExerciceId();
         return result;
   }   


}


