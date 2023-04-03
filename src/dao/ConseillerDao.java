package dao;

import model.Conseiller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConseillerDao {
    Connection laConnection = Dao.initConnection();

    public Boolean loginRequest(String login, String password) {

        Boolean connexionOk = false;

        try {

            Statement st = laConnection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM conseiller WHERE nom_utilisateur_conseiller='" + login
                    + "' and password_conseiller='" + password + "'");

            if (rs.next()) {

                connexionOk = true;
                System.out.println("Le conseiller est bien présent en base de données");

            }

        } catch (SQLException e) {

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
