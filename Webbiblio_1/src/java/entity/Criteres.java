package entity;
// Generated 15 janv. 2013 14:47:52 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Criteres generated by hbm2java
 */
public class Criteres  implements java.io.Serializable {


     private Integer idCritere;
     private String nomCritere;
     private Set notationses = new HashSet(0);

    public Criteres() {
    }

    public Criteres(String nomCritere, Set notationses) {
       this.nomCritere = nomCritere;
       this.notationses = notationses;
    }
   
    public Integer getIdCritere() {
        return this.idCritere;
    }
    
    public void setIdCritere(Integer idCritere) {
        this.idCritere = idCritere;
    }
    public String getNomCritere() {
        return this.nomCritere;
    }
    
    public void setNomCritere(String nomCritere) {
        this.nomCritere = nomCritere;
    }
    public Set getNotationses() {
        return this.notationses;
    }
    
    public void setNotationses(Set notationses) {
        this.notationses = notationses;
    }




}

