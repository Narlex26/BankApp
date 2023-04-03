package dao;

import model.Client;
import model.CompteBancaire;
import model.Conseiller;

import java.sql.*;
import java.util.ArrayList;

public class CompteBancaireDao {

    Connection laConnection=Dao.initConnection();

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Boolean createBankAccount(int id_client, int id_conseiller) {

        Boolean createbankaccountOk = false;

        try {

            Statement st = laConnection.createStatement();
            String sql = "INSERT INTO compte_bancaire (solde_compte_bancaire, id_conseiller, id_client) VALUES (?, ?, ?)";
            PreparedStatement statement = laConnection.prepareStatement(sql);

            statement.setInt(1, 0);
            statement.setInt(2, id_conseiller);
            statement.setInt(3, id_client);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                createbankaccountOk = true;
                System.out.println("le compte a bien été créer et lié au client et conseiller");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return createbankaccountOk;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public ArrayList<CompteBancaire> searchAccountByAttributes(String crit){

        ArrayList<CompteBancaire>listcomptebancaire= new ArrayList();
        try {

            Statement st= laConnection.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM compte_bancaire, client, conseiller WHERE "+crit+" AND compte_bancaire.id_client = client.id_client AND compte_bancaire.id_conseiller = conseiller.id_conseiller");

            while (rs.next()){

                Integer numero_compte_bancaire= Integer.valueOf(rs.getString("numero_compte_bancaire"));
                Double solde_compte_bancaire= Double.valueOf(rs.getString("solde_compte_bancaire"));
                Integer id_client= Integer.valueOf(rs.getString("id_client"));
                String nom_client=rs.getString("nom_client");
                String prenom_client=rs.getString("prenom_client");
                String numero_tel_client=rs.getString("numero_tel_client");
                String adresse_client=rs.getString("adresse_client");
                String code_postal_client	=rs.getString("code_postal_client");
                String ville_client=rs.getString("ville_client");
                Integer id_conseiller= Integer.valueOf(rs.getString("id_conseiller"));
                String nom_conseiller=rs.getString("nom_conseiller");
                String prenom_conseiller=rs.getString("prenom_conseiller");
                String nom_utilisateur_conseiller=rs.getString("nom_utilisateur_conseiller");
                String password_conseiller=rs.getString("password_conseiller");

                CompteBancaire compteBancaire= new CompteBancaire(numero_compte_bancaire, solde_compte_bancaire, new Conseiller(id_conseiller,nom_conseiller,prenom_conseiller,nom_utilisateur_conseiller,password_conseiller), new Client(id_client,nom_client,prenom_client,numero_tel_client,adresse_client,code_postal_client,ville_client));
                listcomptebancaire.add(compteBancaire);

            }
        }catch(SQLException e){

            e.printStackTrace();

        }

        return listcomptebancaire;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public CompteBancaire refreshAccountInfo(CompteBancaire compteBancaire){

        try {

            Statement st= laConnection.createStatement();
            ResultSet rs= st.executeQuery("SELECT * FROM compte_bancaire, client, conseiller WHERE numero_compte_bancaire = "+compteBancaire.getNumero_compte_bancaire()+" AND compte_bancaire.id_client = client.id_client AND compte_bancaire.id_conseiller = conseiller.id_conseiller");

            while (rs.next()){

                Integer numero_compte_bancaire= Integer.valueOf(rs.getString("numero_compte_bancaire"));
                Double solde_compte_bancaire= Double.valueOf(rs.getString("solde_compte_bancaire"));
                Integer id_client= Integer.valueOf(rs.getString("id_client"));
                String nom_client=rs.getString("nom_client");
                String prenom_client=rs.getString("prenom_client");
                String numero_tel_client=rs.getString("numero_tel_client");
                String adresse_client=rs.getString("adresse_client");
                String code_postal_client	=rs.getString("code_postal_client");
                String ville_client=rs.getString("ville_client");
                Integer id_conseiller= Integer.valueOf(rs.getString("id_conseiller"));
                String nom_conseiller=rs.getString("nom_conseiller");
                String prenom_conseiller=rs.getString("prenom_conseiller");
                String nom_utilisateur_conseiller=rs.getString("nom_utilisateur_conseiller");
                String password_conseiller=rs.getString("password_conseiller");

                compteBancaire= new CompteBancaire(numero_compte_bancaire, solde_compte_bancaire, new Conseiller(id_conseiller,nom_conseiller,prenom_conseiller,nom_utilisateur_conseiller,password_conseiller), new Client(id_client,nom_client,prenom_client,numero_tel_client,adresse_client,code_postal_client,ville_client));

            }
        }catch(SQLException e){

            e.printStackTrace();

        }

        return compteBancaire;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Boolean updateAmountIntoAccount(String operation, CompteBancaire compteBancaire) {

        Boolean amountupdatedOk = false;

        try {

            Statement st = laConnection.createStatement();
            String sql = "UPDATE compte_bancaire SET solde_compte_bancaire = solde_compte_bancaire "+operation+" WHERE numero_compte_bancaire = ?";
            PreparedStatement statement = laConnection.prepareStatement(sql);

            statement.setInt(1, compteBancaire.getNumero_compte_bancaire());

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                amountupdatedOk = true;
                System.out.println("le montant a bien été mise a jour");
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return amountupdatedOk;

    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
}

