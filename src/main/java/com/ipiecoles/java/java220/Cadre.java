package com.ipiecoles.java.java220;


import java.util.Objects;

public class Cadre extends Employe{

    public Cadre () {
    }

    public  Double coefficient = 1d;

    public Double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cadre cadre = (Cadre) o;
        return Objects.equals(coefficient, cadre.coefficient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), coefficient);
    }

    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase()*this.coefficient;
    }

    //Redéfinir getNbConges pour que la méthode renvoie le nombre de congés normal des employés plus autant de congés que son coefficient.
    @Override
    public Integer getNbConges () {
        return super.getNbConges()+this.coefficient.intValue();
    }


    }

