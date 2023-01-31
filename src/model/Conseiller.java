package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Conseiller {
    private IntegerProperty id_conseiller;
    private StringProperty nom_conseiller;
    private StringProperty prenom_conseiller;
    private StringProperty nom_utilisateur_conseiller;
    private StringProperty password_conseiller;

    public Conseiller(IntegerProperty id_conseiller, StringProperty nom_conseiller, StringProperty prenom_conseiller, StringProperty nom_utilisateur_conseiller, StringProperty password_conseiller) {
        this.id_conseiller = id_conseiller;
        this.nom_conseiller = nom_conseiller;
        this.prenom_conseiller = prenom_conseiller;
        this.nom_utilisateur_conseiller = nom_utilisateur_conseiller;
        this.password_conseiller = password_conseiller;
    }

    public Conseiller(Integer id_conseiller, String nom_conseiller, String prenom_conseiller, String nom_utilisateur_conseiller, String password_conseiller) {

        this.id_conseiller= new SimpleIntegerProperty(id_conseiller);
        this.nom_conseiller= new SimpleStringProperty(nom_conseiller);
        this.prenom_conseiller= new SimpleStringProperty(prenom_conseiller);
        this.nom_utilisateur_conseiller= new SimpleStringProperty(nom_utilisateur_conseiller);
        this.password_conseiller= new SimpleStringProperty(password_conseiller);
    }


    public int getId_conseiller() {
        return id_conseiller.get();
    }

    public IntegerProperty id_conseillerProperty() {
        return id_conseiller;
    }

    public void setId_conseiller(int id_conseiller) {
        this.id_conseiller.set(id_conseiller);
    }

    public String getNom_conseiller() {
        return nom_conseiller.get();
    }

    public StringProperty nom_conseillerProperty() {
        return nom_conseiller;
    }

    public void setNom_conseiller(String nom_conseiller) {
        this.nom_conseiller.set(nom_conseiller);
    }

    public String getPrenom_conseiller() {
        return prenom_conseiller.get();
    }

    public StringProperty prenom_conseillerProperty() {
        return prenom_conseiller;
    }

    public void setPrenom_conseiller(String prenom_conseiller) {
        this.prenom_conseiller.set(prenom_conseiller);
    }

    public String getNom_utilisateur_conseiller() {
        return nom_utilisateur_conseiller.get();
    }

    public StringProperty nom_utilisateur_conseillerProperty() {
        return nom_utilisateur_conseiller;
    }

    public void setNom_utilisateur_conseiller(String nom_utilisateur_conseiller) {
        this.nom_utilisateur_conseiller.set(nom_utilisateur_conseiller);
    }

    public String getPassword_conseiller() {
        return password_conseiller.get();
    }

    public StringProperty password_conseillerProperty() {
        return password_conseiller;
    }

    public void setPassword_conseiller(String password_conseiller) {
        this.password_conseiller.set(password_conseiller);
    }
}
