/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Olfa Karoui
 */
public class MyConnexion {
    
     private String url = "jdbc:mysql://localhost:3306/pidev";
     private String login = "root";
     private String pwd ="";
     private Connection con;
     private static MyConnexion instance = null;

    private MyConnexion() {
         try 
        {
        con = DriverManager.getConnection(url, login, pwd);
        System.out.println("connexion ok");
        } catch (SQLException ex) 
        {
            System.out.println("NOT OK");
        }
    }
    public static MyConnexion getInstance()
    {
        if(instance == null)
        { 
            instance = new MyConnexion();
        }
        return instance;
    }

    public Connection getCon() {
        return con;
    }
    
        
        
    }
