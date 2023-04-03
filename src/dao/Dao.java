package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Dao {

    static Connection laConnection;

    public Dao() {
        try
        {
            //Connection au driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


            //Connection à la BDD
            Dao.laConnection= DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root","xg9U9SdMv4M5");

            System.out.println("Connexion with the database OK");

        }
        catch(Exception e)
        {
            System.out.println("Connexion with the database fail");
            System.out.println(e.getMessage());
        }

    }

    //vérifie s'il n'y a pas déjà des connections et puis ensuite établir une connection
    public static Connection initConnection(){

        if(laConnection==null)
        {
            new Dao();
        }
        return laConnection;
    }

}