package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    private IntegerProperty id_client;
    private StringProperty nom_client;
    private StringProperty prenom_client;
    private StringProperty numero_tel_client;
    private StringProperty adresse_client;
    private StringProperty code_postal_client;
    private StringProperty ville_client;

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Client(IntegerProperty id_client, StringProperty nom_client, StringProperty prenom_client, StringProperty numero_tel_client, StringProperty adresse_client, StringProperty code_postal_client, StringProperty ville_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.numero_tel_client = numero_tel_client;
        this.adresse_client = adresse_client;
        this.code_postal_client = code_postal_client;
        this.ville_client = ville_client;
    }

    public Client(Integer id_client, String nom_client, String prenom_client, String numero_tel_client, String adresse_client, String code_postal_client, String ville_client) {

        this.id_client= new SimpleIntegerProperty(id_client);
        this.nom_client= new SimpleStringProperty(nom_client);
        this.prenom_client= new SimpleStringProperty(prenom_client);
        this.numero_tel_client= new SimpleStringProperty(numero_tel_client);
        this.adresse_client= new SimpleStringProperty(adresse_client);
        this.code_postal_client= new SimpleStringProperty(code_postal_client);
        this.ville_client= new SimpleStringProperty(ville_client);
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getId_client() {
        return id_client.get();
    }

    public IntegerProperty id_clientProperty() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client.set(id_client);
    }

    public String getNom_client() {
        return nom_client.get();
    }

    public StringProperty nom_clientProperty() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client.set(nom_client);
    }

    public String getPrenom_client() {
        return prenom_client.get();
    }

    public StringProperty prenom_clientProperty() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client.set(prenom_client);
    }

    public String getNumero_tel_client() {
        return numero_tel_client.get();
    }

    public StringProperty numero_tel_clientProperty() {
        return numero_tel_client;
    }

    public void setNumero_tel_client(String numero_tel_client) {
        this.numero_tel_client.set(numero_tel_client);
    }

    public String getAdresse_client() {
        return adresse_client.get();
    }

    public StringProperty adresse_clientProperty() {
        return adresse_client;
    }

    public void setAdresse_client(String adresse_client) {
        this.adresse_client.set(adresse_client);
    }

    public String getCode_postal_client() {
        return code_postal_client.get();
    }

    public StringProperty code_postal_clientProperty() {
        return code_postal_client;
    }

    public void setCode_postal_client(String code_postal_client) {
        this.code_postal_client.set(code_postal_client);
    }

    public String getVille_client() {
        return ville_client.get();
    }

    public StringProperty ville_clientProperty() {
        return ville_client;
    }

    public void setVille_client(String ville_client) {
        this.ville_client.set(ville_client);
    }
}
