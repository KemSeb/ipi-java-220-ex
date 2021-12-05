package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;
import java.util.HashSet;



public class Manager  extends Employe {
    private HashSet<Technicien> equipe = new HashSet();

    public Manager () {
    }

    public Manager(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire, HashSet<Technicien> equipe, Boolean tempsPartiel, String sexe) {
        super(nom, prenom, matricule, dateEmbauche, salaire,tempsPartiel,sexe);
        this.equipe = equipe;
    }

    public HashSet<Technicien> getEquipe() {
        return equipe;
    }

    public void setEquipe(HashSet<Technicien> equipe) {
        this.equipe = equipe;
    }

    public void ajoutTechnicienEquipe(Technicien technicien){
        equipe.add(technicien);
    }

    public void ajoutTechnicienEquipe(String nom, String prenom,String matricule, LocalDate dateEmbauche,Double salaire,Integer grade,Boolean tempsPartiel, String sexe) throws Exception{
        this.ajoutTechnicienEquipe(new Technicien(nom,prenom,matricule,dateEmbauche,salaire,grade,tempsPartiel, sexe));
    }
    /**
     * Permet l'affectation d'un salaire au manager, en modifiant
     * la valeur du salaire pour qu'elle soit multipliée par l'indice manager
     * auquel on ajoute 10% (sur le salaire passé en paramètre) par membre d'équipe
     * @param salaire
     */
    @Override
    public void setSalaire(Double salaire) {
        super.setSalaire(salaire * Entreprise.INDICE_MANAGER + salaire * equipe.size() * 0.1);
    }
    /**
     Renvoie la prime de base+ prime du manager en fonction du nombres de son équipe (PRIME_MANAGER_PAR_TECHNICIEN)
     */
    @Override
    public Double getPrimeAnnuelle() {
        return Entreprise.primeAnnuelleBase() + equipe.size() * Entreprise.PRIME_MANAGER_PAR_TECHNICIEN;
    }

    public void augmenterSalaire(Double pourcentage) throws Exception {
        super.augmenterSalaire(pourcentage);
        augmenterSalaireEquipe(pourcentage);
    }

    private void augmenterSalaireEquipe(Double pourcentage) throws Exception {
        for (Technicien technicien : equipe){
            technicien.augmenterSalaire(pourcentage);
        }
    }

    };


