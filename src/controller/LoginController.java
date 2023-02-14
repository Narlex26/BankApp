package controller;

import application.MainApp;
import dao.ConseillerDao;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private Button btLogin;
    @FXML
    private TextField tfLogin;
    @FXML
    private TextField tfPassword;
    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void handleConnexionOk()
    {
        //on crée un nouvel objet conseillerDao
        ConseillerDao csdao= new ConseillerDao();
        //on recupère le contenu des champs login et password
        String login= tfLogin.getText();
        String password= tfPassword.getText();
        //on les passe en parametre de la méthode du dao
        csdao.loginRequest(login, password);

        //si les infos existent en base on permet à l'utilisateur d'accéder à la fenêtre suivante
        if (csdao.loginRequest(login, password)){

            mainapp.showHome();

        }

        //sinon on affiche un message d'erreur
        else {

            MainApp mainapp= new MainApp();
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainapp.getPrimaryStage());
            alert.setTitle("Erreur d'authentification");
            alert.setHeaderText("Login ou mot de passe incorrect");
            alert.setContentText("Votre login ou votre mot de passe est incorrect.");

            alert.showAndWait();
        }



    }
}