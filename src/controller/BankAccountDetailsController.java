package controller;

import application.MainApp;

import dao.CompteBancaireDao;
import dao.OperationBancaireDao;
import model.CompteBancaire;
import model.OperationBancaire;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class BankAccountDetailsController {

    @FXML
    private TableView<OperationBancaire> tb_operations_account;
    @FXML
    private TableColumn<OperationBancaire, String> cl_types_operation;
    @FXML
    private TableColumn<OperationBancaire, Number> cl_montant_operation;
    @FXML
    private TableColumn<OperationBancaire, String> cl_date_operation;
    @FXML
    private Label numeros_compte_bancaire;
    @FXML
    private Label noms_client;
    @FXML
    private Label prenoms_client;
    @FXML
    private Label nums_tel_client;
    @FXML
    private Label adresses_client;
    @FXML
    private Label codes_postal_client;
    @FXML
    private Label villes_client;
    @FXML
    private Label soldes_compte_bancaire;
    @FXML
    CompteBancaire comptebancaire;
    private String login;

    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void setLogin(String login) {
        this.login=login;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.comptebancaire = compteBancaire;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void showInfoBankAccount() {

        CompteBancaire compteBancaire = this.comptebancaire;

            Integer numero_compte_bancaire = compteBancaire.getNumero_compte_bancaire();
            numeros_compte_bancaire.setText(numero_compte_bancaire.toString());

            String nom_client = compteBancaire.getClient().getNom_client();
            noms_client.setText(nom_client);

            String prenom_client = compteBancaire.getClient().getPrenom_client();
            prenoms_client.setText(prenom_client);

            String num_tel_client = compteBancaire.getClient().getNumero_tel_client();
            nums_tel_client.setText(num_tel_client);

            String adresse_client = compteBancaire.getClient().getAdresse_client();
            adresses_client.setText(adresse_client);

            String code_postal_client = compteBancaire.getClient().getCode_postal_client();
            codes_postal_client.setText(code_postal_client);

            String ville_client = compteBancaire.getClient().getVille_client();
            villes_client.setText(ville_client);

            Double solde_compte_bancaire = compteBancaire.getSolde_compte_bancaire();
            soldes_compte_bancaire.setText(solde_compte_bancaire.toString()+"€");
    }

    public void showTransactionBankAccount() {

        OperationBancaireDao operationBancaireDao = new OperationBancaireDao();

        ArrayList<OperationBancaire> listoperationbancaire= new ArrayList();

        listoperationbancaire=operationBancaireDao.listAllOperationBancaire(this.comptebancaire);

        //permet la conversion d'une arraylist en observablelist utilisée en javafx
        ObservableList<OperationBancaire> data= FXCollections.observableArrayList(listoperationbancaire);

        tb_operations_account.setItems(data);
        cl_types_operation.setCellValueFactory(cellData -> cellData.getValue().libelle_type_operationProperty());
        cl_montant_operation.setCellValueFactory(cellData-> cellData.getValue().montant_operation_bancaireProperty());
        cl_date_operation.setCellValueFactory(cellData-> cellData.getValue().getDate_operation_bancaire());
    }

    public void refreshInfoAndTransactionBankAccount(){
        CompteBancaireDao compteBancaireDao = new CompteBancaireDao();

        //------------------------------------------------------------------------------------------

        CompteBancaire compteBancaire = compteBancaireDao.refreshAccountInfo(this.comptebancaire);

            Integer numero_compte_bancaire = compteBancaire.getNumero_compte_bancaire();
            numeros_compte_bancaire.setText(numero_compte_bancaire.toString());

            String nom_client = compteBancaire.getClient().getNom_client();
            noms_client.setText(nom_client);

            String prenom_client = compteBancaire.getClient().getPrenom_client();
            prenoms_client.setText(prenom_client);

            String num_tel_client = compteBancaire.getClient().getNumero_tel_client();
            nums_tel_client.setText(num_tel_client);

            String adresse_client = compteBancaire.getClient().getAdresse_client();
            adresses_client.setText(adresse_client);

            String code_postal_client = compteBancaire.getClient().getCode_postal_client();
            codes_postal_client.setText(code_postal_client);

            String ville_client = compteBancaire.getClient().getVille_client();
            villes_client.setText(ville_client);

            Double solde_compte_bancaire = compteBancaire.getSolde_compte_bancaire();
            soldes_compte_bancaire.setText(solde_compte_bancaire.toString()+"€");

        //------------------------------------------------------------------------------------------

        this.showTransactionBankAccount();
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void newDepositIntoAccount() {
        mainapp.showMoneyDepositPopUp(this.comptebancaire);
    }

    public void newWithdrawalIntoAccount() {
        mainapp.showMoneyWithdrawalPopUp(this.comptebancaire);
    }

    public void returnBackToHome() {
        mainapp.showHome(login);
    }
}