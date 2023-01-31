package dao;

import java.sql.Connection;
import java.sql.DriverManager;



public class Dao {

    static Connection laConnection;


    public Dao()
    {
        try
        {
            //connection au driver jdbc
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();


            //connection � la BDD
            Dao.laConnection= DriverManager.getConnection("jdbc:mysql://localhost/bankapp", "root","xg9U9SdMv4M5");

            System.out.println("Connexion ok");

        }
        catch(Exception e)
        {
            System.out.println("Connexion fail");
            System.out.println(e.getMessage());
        }


    }

    //v�rifie s'il n'y a pas d�j� des connections et puis ensuite �tablie une connection
    public static Connection initConnection(){

        if(laConnection==null)
        {
            new Dao();
        }
        return laConnection;
    }

}