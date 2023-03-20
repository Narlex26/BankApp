package application;

import controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CompteBancaire;

import java.io.IOException;

public class MainApp extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("BankApp");

        initRootLayout();

        showLogin();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the view inside the root layout.
     */
    public void showLogin() {
        try {
            // Load login form view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/LoginView.fxml"));
            AnchorPane loginview = (AnchorPane) loader.load();

            // Set login view  into the center of root layout.
            rootLayout.setCenter(loginview);

            LoginController logincontroller = loader.getController();

            //Appels des méthodes du controller
            logincontroller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showHome(String login) {
        try {
            // Load home view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/HomeView.fxml"));
            AnchorPane homeview = (AnchorPane) loader.load();

            // Set home view into the center of root layout.
            rootLayout.setCenter(homeview);

            HomeController homecontroller = loader.getController();

            //Appels des méthodes du controller
            homecontroller.setMainApp(this);

            homecontroller.setLogin(login);
            homecontroller.showNamePersonConnected();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showBankAccountDetails (CompteBancaire compteBancaire, String login) {
        try {
            // Load BankAccountDetails view.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("/view/BankAccountDetailsView.fxml"));
            AnchorPane bankaccountdetailsview = (AnchorPane) loader.load();

            // Set BankAccountDetails view into the center of root layout.
            rootLayout.setCenter(bankaccountdetailsview);

            BankAccountDetailsController bankAccountDetailsController = loader.getController();

            //Appels des méthodes du controller
            bankAccountDetailsController.setMainApp(this);

            bankAccountDetailsController.setCompteBancaire(compteBancaire);
            bankAccountDetailsController.setLogin(login);
            bankAccountDetailsController.showInfoBankAccount();
            bankAccountDetailsController.showTransactionBankAccount();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMoneyDepositPopUp(CompteBancaire compteBancaire){

        try {
            // Load MoneyDepositView.
            FXMLLoader loader= new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/view/MoneyDepositView.fxml"));
            AnchorPane moneydepositview = (AnchorPane) loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Ajouter des fonds au compte");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(moneydepositview);
            dialogStage.setScene(scene);

            MoneyDepositController moneyDepositController = loader.getController();

            //Appels des méthodes du controller
            moneyDepositController.setDialogStage(dialogStage);
            moneyDepositController.setMainApp(this);

            moneyDepositController.setCompteBancaire(compteBancaire);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showMoneyWithdrawalPopUp(CompteBancaire compteBancaire){

        try {
            // Load MoneyDepositView.
            FXMLLoader loader= new FXMLLoader();

            loader.setLocation(MainApp.class.getResource("/view/MoneyWithdrawalView.fxml"));
            AnchorPane moneywithdrawalview = (AnchorPane) loader.load();

            // Create the dialog Stage
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Retirer des fonds au compte");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(moneywithdrawalview);
            dialogStage.setScene(scene);

            MoneyWithdrawalController moneyWithdrawalController = loader.getController();

            //Appels des méthodes du controller
            moneyWithdrawalController.setDialogStage(dialogStage);
            moneyWithdrawalController.setMainApp(this);

            moneyWithdrawalController.setCompteBancaire(compteBancaire);

            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
