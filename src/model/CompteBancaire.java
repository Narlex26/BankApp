package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

public class CompteBancaire {

    private IntegerProperty numero_compte_bancaire;
    private IntegerProperty solde_compte_bancaire;
    private Conseiller conseiller;
    private Client client;

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public CompteBancaire(IntegerProperty numero_compte_bancaire, IntegerProperty solde_compte_bancaire, Conseiller conseiller, Client client) {
        this.numero_compte_bancaire = numero_compte_bancaire;
        this.solde_compte_bancaire = solde_compte_bancaire;
        this.conseiller = conseiller;
        this.client = client;
    }

    public CompteBancaire(Integer numero_compte_bancaire, Integer solde_compte_bancaire, Conseiller conseiller, Client client){

        this.numero_compte_bancaire = new SimpleIntegerProperty(numero_compte_bancaire);
        this.solde_compte_bancaire =new SimpleIntegerProperty(solde_compte_bancaire);
        this.conseiller = conseiller;
        this.client = client;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getNumero_compte_bancaire() {
        return numero_compte_bancaire.get();
    }

    public IntegerProperty numero_compte_bancaireProperty() {
        return numero_compte_bancaire;
    }

    public void setNumero_compte_bancaire(int numero_compte_bancaire) {
        this.numero_compte_bancaire.set(numero_compte_bancaire);
    }

    public int getSolde_compte_bancaire() {
        return solde_compte_bancaire.get();
    }

    public IntegerProperty solde_compte_bancaireProperty() {
        return solde_compte_bancaire;
    }

    public void setSolde_compte_bancaire(int solde_compte_bancaire) {
        this.solde_compte_bancaire.set(solde_compte_bancaire);
    }

    public Conseiller getConseiller() {
        return conseiller;
    }

    public void setConseiller(Conseiller conseiller) {
        this.conseiller = conseiller;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

}
