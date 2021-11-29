package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

public class Commercial extends Employe {
    //Ajout de l'attribut
    private Double  caAnnuel = 0d;
    private Integer performance;


// Créer le constructeur Commercial initialisant les attributs de la classe Employe + initialisation du champ caAnnuel
    public Commercial () {

    }
    public Commercial(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, Double CaAnnuel,Integer performance, Boolean tempsPartiel, String sexe) {
        super(nom, prenom, matricule, dateEmbauche, salaire, tempsPartiel, sexe);
        this.caAnnuel = CaAnnuel;
        this.performance = performance;
    }


    @Override
    public Double getPrimeAnnuelle(){
        if (this.caAnnuel == null) {
            return
            500d;
        }
        return Math.max(Math.ceil(this.getCaAnnuel()*0.05),500);
    }

    public Double getCaAnnuel() {
        return caAnnuel;
    }


    public void setCaAnnuel(Double caAnnuel) {
        this.caAnnuel = caAnnuel;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commercial)) return false;
        if (!super.equals(o)) return false;

        Commercial that = (Commercial) o;

        return Double.compare(that.caAnnuel, caAnnuel) == 0;

    }
    public Boolean performanceEgale(Integer performance){
        return this.performance.equals(performance);
        //return Objects.equals(this.performance,performance);
    }
    public Note equivalenceNote(){
        switch(performance) {
            case 0:
            case 50:
                return Note.INSUFFISANT;
            case 100:
                return Note.PASSABLE;

            case 150:
                return Note.BIEN;
            case 200:
                return Note.TRES_BIEN;
            default:
                return null;


        }
    }
}

