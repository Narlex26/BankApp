package model;

import javafx.beans.property.*;

public class OperationBancaire {

    private IntegerProperty id_operation_bancaire;
    private StringProperty date_operation_bancaire;
    private DoubleProperty montant_operation_bancaire;
    private StringProperty libelle_type_operation;

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public OperationBancaire(IntegerProperty id_operation_bancaire, StringProperty date_operation_bancaire, DoubleProperty montant_operation_bancaire, StringProperty libelle_type_operation) {
        this.id_operation_bancaire = id_operation_bancaire;
        this.date_operation_bancaire = date_operation_bancaire;
        this.montant_operation_bancaire = montant_operation_bancaire;
        this.libelle_type_operation = libelle_type_operation;
    }

    public OperationBancaire(Integer id_operation_bancaire, String date_operation_bancaire, Double montant_operation_bancaire, String libelle_type_operation){

        this.id_operation_bancaire = new SimpleIntegerProperty(id_operation_bancaire);
        this.date_operation_bancaire =new SimpleStringProperty(date_operation_bancaire);
        this.montant_operation_bancaire = new SimpleDoubleProperty(montant_operation_bancaire);
        this.libelle_type_operation = new SimpleStringProperty(libelle_type_operation);
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int getId_operation_bancaire() {
        return id_operation_bancaire.get();
    }

    public IntegerProperty id_operation_bancaireProperty() {
        return id_operation_bancaire;
    }

    public void setId_operation_bancaire(int id_operation_bancaire) {
        this.id_operation_bancaire.set(id_operation_bancaire);
    }

    public StringProperty getDate_operation_bancaire() {
        return date_operation_bancaire;
    }

    public void setDate_operation_bancaire(StringProperty date_operation_bancaire) {
        this.date_operation_bancaire = date_operation_bancaire;
    }

    public Double getMontant_operation_bancaire() {
        return montant_operation_bancaire.get();
    }

    public DoubleProperty montant_operation_bancaireProperty() {
        return montant_operation_bancaire;
    }

    public void setMontant_operation_bancaire(Double montant_operation_bancaire) {
        this.montant_operation_bancaire.set(montant_operation_bancaire);
    }

    public String getLibelle_type_operation() {
        return libelle_type_operation.get();
    }

    public StringProperty libelle_type_operationProperty() {
        return libelle_type_operation;
    }

    public void setLibelle_type_operation(String libelle_type_operation) {
        this.libelle_type_operation.set(libelle_type_operation);
    }
}
