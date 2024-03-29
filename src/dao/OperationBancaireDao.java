package dao;

import model.CompteBancaire;
import model.OperationBancaire;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OperationBancaireDao {

    Connection laConnection=Dao.initConnection();

    public Boolean DepositIntoAccount(Double amount, LocalDate dateofdeposit, CompteBancaire compteBancaire) {

        Boolean depositOk = false;

        try {

            Statement st = laConnection.createStatement();

            String sql = "INSERT INTO operation_bancaire (date_operation_bancaire, montant_operation_bancaire, id_type_operation, numero_compte_bancaire)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = laConnection.prepareStatement(sql);

            java.sql.Date sqlDate = java.sql.Date.valueOf(dateofdeposit);
            statement.setDate(1, sqlDate);
            statement.setDouble(2, amount);
            statement.setInt(3, 1);
            statement.setInt(4, compteBancaire.getNumero_compte_bancaire());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                depositOk = true;
                System.out.println("l'opération a bien été effectué");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return depositOk;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Boolean WithdrawalIntoAccount(Double amount, LocalDate dateofdeposit, CompteBancaire compteBancaire) {

        Boolean withdrawalOk = false;

        try {

            Statement st = laConnection.createStatement();

            String sql = "INSERT INTO operation_bancaire (date_operation_bancaire, montant_operation_bancaire, id_type_operation, numero_compte_bancaire)" +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement statement = laConnection.prepareStatement(sql);

            java.sql.Date sqlDate = java.sql.Date.valueOf(dateofdeposit);
            statement.setDate(1, sqlDate);
            statement.setDouble(2, amount);
            statement.setInt(3, 2);
            statement.setInt(4, compteBancaire.getNumero_compte_bancaire());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                withdrawalOk = true;
                System.out.println("l'opération a bien été effectué");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return withdrawalOk;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<OperationBancaire> listAllOperationBancaire(CompteBancaire compteBancaire){

        ArrayList<OperationBancaire>listoperationbancaire= new ArrayList();
        try {

            Statement st= laConnection.createStatement();
            ResultSet rs= st.executeQuery("SELECT operation_bancaire.id_operation_bancaire, type_operation.libelle_type_operation, operation_bancaire.montant_operation_bancaire, operation_bancaire.date_operation_bancaire FROM operation_bancaire, type_operation WHERE operation_bancaire.id_type_operation = type_operation.id_type_operation AND "+compteBancaire.getNumero_compte_bancaire()+" = operation_bancaire.numero_compte_bancaire");

            while (rs.next()){

                Integer id_operation_bancaire= Integer.valueOf(rs.getString("id_operation_bancaire"));
                String libelle_type_operation=rs.getString("libelle_type_operation");
                Double montant_operation_bancaire= Double.valueOf(rs.getString("montant_operation_bancaire"));
                String date_operation_bancaire= rs.getString("date_operation_bancaire");

                OperationBancaire operationBancaire = new OperationBancaire(id_operation_bancaire,date_operation_bancaire,montant_operation_bancaire,libelle_type_operation);
                listoperationbancaire.add(operationBancaire);

            }
        }catch(SQLException e){

            e.printStackTrace();

        }

        return listoperationbancaire;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Double getTotalOperationsForLastMonth(String type_operation, int id_client) {
        double total_operation = 0;

        try {

            String sql = "SELECT SUM(montant_operation_bancaire) " +
                    "FROM operation_bancaire, type_operation " +
                    "WHERE type_operation.id_type_operation = operation_bancaire.id_type_operation " +
                    "AND type_operation.libelle_type_operation = ? " +
                    "AND operation_bancaire.numero_compte_bancaire = ? " +
                    "AND date_operation_bancaire >= DATE_SUB(NOW(), INTERVAL 1 MONTH)";
            PreparedStatement statement = laConnection.prepareStatement(sql);


            statement.setString(1, type_operation);
            statement.setInt(2, id_client);

            // On exécute la requête et on récupère le résultat
            ResultSet result = statement.executeQuery();

            // Si la requête retourne des résultats, on récupère la somme des opérations bancaires
            if (result.next()) {
                total_operation = result.getDouble(1);
            }

            statement.close();
            result.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return total_operation;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

}