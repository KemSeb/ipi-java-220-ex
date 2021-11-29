package com.ipiecoles.java.java220;

import org.joda.time.LocalDate;

import java.util.Objects;


/**
 * Created by pjvilloud on 21/09/17.
 */
public abstract class Employe {

    //Attributs de la classe
    private String nom;
    private String prenom;
    private String matricule;
    private LocalDate dateEmbauche;
    private Double salaire;

    public Employe() {
    }

    //Constructeur
    public Employe(String nom, String prenom, String matricule, LocalDate dateEmbauche, Double salaire) {

        this.nom = nom;
        this.prenom = prenom;
        this.matricule = matricule;
        this.dateEmbauche = dateEmbauche;
        this.salaire = salaire;

    }

//Getter and setter


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public LocalDate getDateEmbauche() {
        return dateEmbauche;
    }

    //Exception pour gérer le cas ou la date d'embauche est postérieure à la date du jour
    public void setDateEmbauche(LocalDate dateEmbauche) throws Exception {
        if  (dateEmbauche == null) {
            throw new Exception("La date d'embauche ne peut être null");
        }
        if (dateEmbauche.isAfter(LocalDate.now())) {
            throw new Exception("La date d'embauche ne peut être postérieure à la date courante");
        }
        this.dateEmbauche = dateEmbauche;
    }

    public Double getSalaire() {
        return salaire;
    }

    public void setSalaire(Double salaire) {
        this.salaire = salaire;
    }

    //Final permet qu'elle ne soit plus définissable
    public final Integer getNombreAnneeAnciennete() {


        return LocalDate.now().getYear() - this.dateEmbauche.getYear();

    }

    //Methode getNbConges retournant le montant NB conges Bases de la classe Entreprise
    public Integer getNbConges() {

        return Entreprise.NB_CONGES_BASE;

    }


    //Methode getPrimeAnnuelle retournant la prime annuelle définie dans la classe entreprise.
    public  abstract Double getPrimeAnnuelle() ;



    /**
     * Méthode permettant d'augmenter le salaire de l'employé
     *
     * Le salaire devra être renseigné
     * @param pourcentage pourcentage d'augmentation du salaire
     * @throws Exception si le pourcentage est incorrect
     */
    public void augmenterSalaire(Double pourcentage) throws Exception {
        if(pourcentage == null || pourcentage <= 0 || pourcentage > 1){
            throw new Exception("Le pourcentage ne peut être null, égal à 0 ou supérieur à 1");
        }
        this.salaire = this.salaire * (1 + pourcentage);
    }


    //Redéfinir la fonction Tostring pour changer l'ordre

    public String toString() {
        final StringBuilder sb = new StringBuilder("Employe{");
        sb.append("nom='").append(nom).append('\'');
        sb.append(", prenom='").append(prenom).append('\'');
        sb.append(", matricule='").append(matricule).append('\'');
        sb.append(", dateEmbauche=").append(dateEmbauche);
        sb.append(", salaire=").append(salaire);
        sb.append('}');
        return sb.toString();

    }
//Méthode `equals` (héritée d'`Object`) qui test l'égalité sur l'ensemble des attributs de la classe `Employe`
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if(!(o instanceof Employe)) return false;

        Employe employe =(Employe) o;

        if (Double.compare(employe.salaire,salaire) !=0) return false;
        if(nom != null ? ! nom.equals(employe.nom): employe.nom != null) return false;
        if(prenom != null ? ! prenom.equals(employe.prenom): employe.prenom != null) return false;
        if(matricule != null ? ! matricule.equals(employe.matricule): employe.matricule != null) return false;
        return dateEmbauche != null ? dateEmbauche.equals(employe.dateEmbauche): employe.dateEmbauche == null;
    }
// Méthode `hashCode` (héritée d'`Object`) qui utilise`Objects.hash
    @Override
    public int hashCode () {
        return Objects.hash(nom, prenom, matricule, dateEmbauche, salaire);
    }


}



