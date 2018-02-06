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
 * @author CorpseRoot
 */
public class MyConnection 
{
    
    private String url="jdbc:mysql://localhost:3306/pidev";
    private String username = "root";
    private String password = "";
    private Connection Con;
    private static MyConnection instance = null;
    
    private MyConnection() {
        
        try
        {
            Con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection OK!");   
        } 
        catch (SQLException ex)
        {
            System.out.println("erreur");
        }
    }
    
    public static MyConnection getInstance()
    {
        if(instance == null)
        {
            instance = new MyConnection();
        }
        return instance;
        
    }

    public Connection getConnection() {
        return Con;
    }
    
   
   
}
