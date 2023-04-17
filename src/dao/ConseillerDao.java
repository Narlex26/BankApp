package dao;

import model.Conseiller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

public class ConseillerDao {
    Connection laConnection = Dao.initConnection();

    public Boolean loginRequest(String login, String password) {

        Boolean connexionOk = false;

        try {

            // Hash password using sha256
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder hashBuilder = new StringBuilder();
            for (byte b : hashBytes) {
                hashBuilder.append(String.format("%02x", b));
            }
            String hashedPassword = hashBuilder.toString();

            //requête de connexion
            String sql = "SELECT * FROM conseiller WHERE nom_utilisateur_conseiller=? and password_conseiller=?";
            PreparedStatement statement = laConnection.prepareStatement(sql);

            statement.setString(1, login);
            statement.setString(2, hashedPassword);

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                connexionOk = true;
                System.out.println("Le conseiller est bien présent en base de données");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return connexionOk;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public Conseiller recupInfosConseiller (String login) {
        Conseiller conseiller = new Conseiller();

        try {
            Statement st = laConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conseiller WHERE nom_utilisateur_conseiller = '"+login+"'");

            if (rs.next()) {
                Integer id_conseiller= Integer.valueOf(rs.getString("id_conseiller"));
                String nom_conseiller=rs.getString("nom_conseiller");
                String prenom_conseiller=rs.getString("prenom_conseiller");
                String nom_utilisateur_conseiller=rs.getString("nom_utilisateur_conseiller");
                String password_conseiller=rs.getString("password_conseiller");

                conseiller = new Conseiller(id_conseiller, nom_conseiller, prenom_conseiller, nom_utilisateur_conseiller, password_conseiller);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conseiller;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
}
