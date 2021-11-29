package com.ipiecoles.java.java220;


import com.ipiecoles.java.java220.exceptions.TechnicienException;
import org.joda.time.LocalDate;

import java.util.Objects;




public class Technicien extends Employe implements Comparable<Technicien>{

    private Integer grade;

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) throws TechnicienException {
        if(grade <= 0 || grade > 5) {
            throw new TechnicienException(TechnicienException.GRADE, this, grade);
        }
        this.grade = grade;
    }
    @Override
    public void setSalaire(Double salaire){
        super.setSalaire(salaire*(1.0+ grade*0.1));
    }



    public Technicien () {

    }

    public Technicien(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Integer grade,Boolean tempsPartiel, String sexe) {
        super(nom, prenom, matricule, dateEmbauche, salaire,tempsPartiel,sexe);
        this.grade = grade;
    }
    @Override
    public Integer getNbConges(){

        return super.getNbConges()+this.getNombreAnneeAnciennete();
    }
    @Override
    public Double getPrimeAnnuelle() {
        Double primeAnnuelleBase = Entreprise.primeAnnuelleBase();
        return primeAnnuelleBase + primeAnnuelleBase * ((double) grade / 10) + Entreprise.PRIME_ANCIENNETE * this.getNombreAnneeAnciennete();
    }

    @Override
    public String toString() {
        return "Technicien{" +
                "grade=" + grade +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Technicien)) return false;
        if (!super.equals(o)) return false;
        Technicien that = (Technicien) o;
        return Objects.equals(grade, that.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), grade);
    }


    public int CompareTo(Technicien o) {
        return Integer.compare(this.grade, o.getGrade());
    }

    @Override
    public int compareTo(Technicien o) {
        return Integer.compare(this.grade, o.getGrade());
    }

}


