package controller;

import application.MainApp;

import dao.ConseillerDao;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class LoginController {

    @FXML
    private Button btLogin;
    @FXML
    private TextField tfLogin;
    @FXML
    private PasswordField tfPassword;
    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void onEnterPress() {
        tfPassword.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                handleConnexionOk();
            }
        });
    }

    public void handleConnexionOk() {

        //on crée un nouvel objet conseillerDao
        ConseillerDao conseillerDao= new ConseillerDao();

        //on recupère le contenu des champs login et password
        String login= tfLogin.getText();
        String password= tfPassword.getText();

        //si les infos existent en base on permet à l'utilisateur d'accéder à la fenêtre suivante
        if (conseillerDao.loginRequest(login, password)){

            mainapp.showHome(login);

        } else { //sinon on affiche un message d'erreur

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