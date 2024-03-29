package controller;

import application.MainApp;

import dao.CompteBancaireDao;
import dao.ConseillerDao;
import model.CompteBancaire;
import model.Conseiller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;


public class HomeController {
    @FXML
    private Button search;
    @FXML
    private TextField surname_search;
    @FXML
    private TextField name_search;
    @FXML
    private TextField phone_number_search;
    @FXML
    private TextField city_search;
    @FXML
    private TableView <CompteBancaire> tb_bank_account;
    @FXML
    private TableColumn<CompteBancaire, Number> cl_account_number;
    @FXML
    private TableColumn<CompteBancaire, String> cl_surname;
    @FXML
    private TableColumn<CompteBancaire, String> cl_name;
    @FXML
    private TableColumn<CompteBancaire, String> cl_city;
    @FXML
    private TableColumn<CompteBancaire, String> cl_phone_number;
    @FXML
    private TableColumn<CompteBancaire, String> cl_balance;
    @FXML
    private Label name_person_connected;
    private String  login;
    ConseillerDao conseillerDao = new ConseillerDao();
    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void setLogin(String login) {
        this.login=login;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void showNamePersonConnected() {
        Conseiller conseiller = conseillerDao.recupInfosConseiller(login);

        String nom = conseiller.getPrenom_conseiller()+" "+conseiller.getNom_conseiller();
        name_person_connected.setText(nom);
    }

    public void searchAccountByAttributes() {

        CompteBancaireDao comptebancaireDao= new CompteBancaireDao();

        ArrayList<CompteBancaire> listeCompteBancaire= new ArrayList();

        String crit="";

        //on vient vérifier si le  champ est vide sinon on recupère la valeur

            if(!surname_search.getText().equals("")) {
                String surname=surname_search.getText();
                crit="client.nom_client like '%"+surname+"%'";
            }

//----------------------------------------------------------------------------------------------------

            if (!name_search.getText().equals("")){

                String name= name_search.getText();

                if (crit.equals("")){

                    crit="client.prenom_client like '%"+name+"%'";
                }else{

                    crit=crit+"and client.prenom_client like '%"+name+"%'";
                }
            }

//----------------------------------------------------------------------------------------------------

            if (!phone_number_search.getText().equals("")){

                String name= phone_number_search.getText();

                if (crit.equals("")){

                    crit="client.numero_tel_client like '%"+name+"%'";
                }else{

                    crit=crit+"and client.numero_tel_client like '%"+name+"%'";
                }
            }

//----------------------------------------------------------------------------------------------------

            if (!city_search.getText().equals("")){

                String name= city_search.getText();

                if (crit.equals("")){

                    crit="client.ville_client like '%"+name+"%'";
                }else{

                    crit=crit+"and client.ville_client like '%"+name+"%'";
                }
            }

        listeCompteBancaire=comptebancaireDao.searchAccountByAttributes(crit);

            //permet la conversion d'une arraylist en observablelist utilisée en javafx
            ObservableList<CompteBancaire> data= FXCollections.observableArrayList(listeCompteBancaire);

            tb_bank_account.setItems(data);
            cl_account_number.setCellValueFactory(cellData -> cellData.getValue().numero_compte_bancaireProperty());
            cl_surname.setCellValueFactory(cellData-> cellData.getValue().getClient().nom_clientProperty());
            cl_name.setCellValueFactory(cellData-> cellData.getValue().getClient().prenom_clientProperty());
            cl_city.setCellValueFactory(cellData -> cellData.getValue().getClient().ville_clientProperty());
            cl_phone_number.setCellValueFactory(cellData-> cellData.getValue().getClient().numero_tel_clientProperty());
            cl_balance.setCellValueFactory(cellData -> cellData.getValue().solde_compte_bancaireProperty_with_logo());

    }

    public void newClientAndAccount() {
        mainapp.showCreateClientAndAccountPopUp(this.login);
    }

    public void consulterDetailsCompte(){
        CompteBancaireDao compteBancaireDao = new CompteBancaireDao();

        int selectedIndex= tb_bank_account.getSelectionModel().getSelectedIndex();

        if (selectedIndex >=0) {
            CompteBancaire compteBancaire = tb_bank_account.getItems().get(selectedIndex);
            mainapp.showBankAccountDetails(compteBancaire, this.login);
        }
    }
}