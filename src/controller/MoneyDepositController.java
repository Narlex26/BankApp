package controller;

import application.MainApp;

import dao.CompteBancaireDao;
import dao.OperationBancaireDao;
import model.CompteBancaire;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class MoneyDepositController {

    @FXML
    private Button btConfirmedDeposit;
    @FXML
    private TextField tfAmountDeposit;
    @FXML
    private DatePicker dpDateOfDeposit;
    @FXML
    CompteBancaire comptebancaire;
    private MainApp mainapp;

    public void setMainApp(MainApp mainapp) {
        this.mainapp = mainapp;
    }

    public void setCompteBancaire(CompteBancaire compteBancaire) {
        this.comptebancaire = compteBancaire;
    }

    public void setDialogStage(Stage dialogStage) {
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public void DepositIntoAccount() {

        OperationBancaireDao operationBancaireDao = new OperationBancaireDao();
        CompteBancaireDao compteBancaireDao = new CompteBancaireDao();

        Integer.parseInt(tfAmountDeposit.getText());
        Double amount = Double.parseDouble(tfAmountDeposit.getText());

        LocalDate dateofdeposit= dpDateOfDeposit.getValue();

        String operation = "+" + amount;

        if (operationBancaireDao.DepositIntoAccount(amount, dateofdeposit, this.comptebancaire)) {

            if (compteBancaireDao.updateAmountIntoAccount(operation, this.comptebancaire)) {

                Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                confirmation.initOwner(mainapp.getPrimaryStage());
                confirmation.setTitle("Confirmation");
                confirmation.setHeaderText("Le montant a bien été crédité");
                confirmation.setContentText("Merci de réactualiser pour consulter le nouveau soldes");

                confirmation.showAndWait();

            } else {

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.initOwner(mainapp.getPrimaryStage());
                alert.setTitle("Erreur lors de la mise a jour de votre soldes");
                alert.setHeaderText("Il y'a eu une erreur lors de la mise a jour de votre solde");
                alert.setContentText("Merci de vérifier que le montant ou la date soit correct ou réessayer plus tard");

                alert.showAndWait();
            }

        } else {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainapp.getPrimaryStage());
            alert.setTitle("Erreur lors de l'opération");
            alert.setHeaderText("Il y'a eu une erreur lors de l'opération");
            alert.setContentText("Merci de vérifier que le montant ou la date soit correct ou réessayer plus tard");

            alert.showAndWait();
        }

    }
}

//-------------------------------------------------------------------------------------------------------------------------------------------------------------