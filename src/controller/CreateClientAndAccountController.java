package controller;

import application.MainApp;

import dao.ClientDao;
import dao.CompteBancaireDao;
import dao.ConseillerDao;
import model.Conseiller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class CreateClientAndAccountController {

    @FXML
    private Button btConfirmedCreateClient;
    @FXML
    private TextField tfSurname;
    @FXML
    private TextField tfName;
    @FXML
    private TextField tfNumtel;
    @FXML
    private TextField tfAdress;
    @FXML
    private TextField tfZipcode;
    @FXML
    private TextField tfCity;
    private String  login;
    ConseillerDao conseillerDao = new ConseillerDao();
    private int id_conseiller; // Stock l'id du conseiller identifié par la fonction getIdPersonConnected() en utilisant le nom d'utilisateur "login"
    private Stage dialogStage;
    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setLogin(String login) {
        this.login=login;
    }

    public int getIdPersonConnected() {
        Conseiller conseiller = conseillerDao.recupInfosConseiller(this.login);

        this.id_conseiller = conseiller.getId_conseiller();

        return this.id_conseiller;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void CreateClientAndAccount() {

        ClientDao clientDao = new ClientDao();
        CompteBancaireDao compteBancaireDao = new CompteBancaireDao();
        int id_conseiller = this.id_conseiller;

        //on recupère le contenu des champs
        String surname= tfSurname.getText();
        String name= tfName.getText();
        int numtel= Integer.parseInt(tfNumtel.getText());
        String adress= tfAdress.getText();
        int zipcode= Integer.parseInt(tfZipcode.getText());
        String city= tfCity.getText();

        int id_client = clientDao.createClient(surname, name, numtel, adress, zipcode, city); // Récupère l'id du client qui a été créer

        if (id_client != 0) {

            if (compteBancaireDao.createBankAccount(id_client, id_conseiller)) {

                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                confirmation.initOwner(mainapp.getPrimaryStage());
                confirmation.setTitle("Confirmation");
                confirmation.setHeaderText("Le profil du client a été créé avec succès et un compte bancaire lui été enregistré avec succès");
                confirmation.setContentText("Vous pouvez dès maintenant admninistrer son compte");

                confirmation.showAndWait();

                // Fermer le dialog stage lorsque l'utilisateur a cliqué sur OK et que le client/compte ont été créé
                if (confirmation.getResult() == ButtonType.OK) {
                    dialogStage.close();
                }

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainapp.getPrimaryStage());
                alert.setTitle("Erreur");
                alert.setHeaderText("Il y a eu une erreur lors de la création du compte");
                alert.setContentText("Merci de vérifier que les informations saisies sont correct ou réessayer plus tard");

                alert.showAndWait();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainapp.getPrimaryStage());
            alert.setTitle("Erreur");
            alert.setHeaderText("il y a eu une erreur lors de la création du client");
            alert.setContentText("Merci de vérifier que les informations saisies sont correct ou réessayer plus tard");

            alert.showAndWait();
        }

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
}