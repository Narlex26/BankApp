package dao;

import java.sql.*;

public class ClientDao {

    Connection laConnection=Dao.initConnection();

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

    public int createClient(String nom_client, String prenom_client, int numero_tel_client, String adresse_client, int code_postal_client, String ville_client) {

        int id_client = -1;

        try {

            String sql = "INSERT INTO client (nom_client, prenom_client, numero_tel_client, adresse_client, code_postal_client, ville_client)\n" +
                    "VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = laConnection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, nom_client);
            statement.setString(2, prenom_client);
            statement.setInt(3, numero_tel_client);
            statement.setString(4, adresse_client);
            statement.setInt(5, code_postal_client);
            statement.setString(6, ville_client);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {

                ResultSet rs = statement.getGeneratedKeys();
                if (rs.next()) {
                    id_client = rs.getInt(1);
                }

                System.out.println("Le client a bien été créé avec l'id_client " + id_client);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return id_client;
    }

//-------------------------------------------------------------------------------------------------------------------------------------------------------------

}
