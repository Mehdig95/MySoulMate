/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Contacts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CorpseRoot
 */
public class ContactsService {
    
    private Connection Con;

    public ContactsService() 
    {    
        Con = MyConnection.getInstance().getConnection();
    }
    
    public void AjouterContact(Contacts C)
    {
        try 
        {

            String SQL = "INSERT INTO `contacts`(`UserOneID`, `UserTwoID`, `ReqStatus`) VALUES (?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setInt(1,C.getUserOneID());
            stm.setInt(2, C.getUserTwoID());
            stm.setInt(3, 0);
            
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                C.setID(id);

                System.out.println(id);
            }
            System.out.println("invitation ajouter");
           
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
    
    //@Override
    public void ModifierContact(Contacts C, int Status) 
    {
        
        try 
        {
            String SQL = "UPDATE `contacts` SET `ReqStatus`=? WHERE ID=?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);

            
            stm.setInt(1,Status);
            stm.setInt(2, C.getID());

            stm.execute();

         
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    // @Override
    public List<Contacts> RecievedInvitations(int ID)
    {
        
        List<Contacts> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `contacts` WHERE UserTwoID = ? AND `ReqStatus`=0";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Contacts C = new Contacts();
                C.setID(Res.getInt(1));
                C.setUserOneID(Res.getInt(2));
                C.setUserTwoID(Res.getInt(3));
                C.setReqAccepted(Res.getInt(4));
                QL.add(C);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
    
    public List<Contacts> SentInvitations(int ID)
    {
        
        List<Contacts> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `contacts` WHERE UserOneID = ? AND `ReqStatus`=0";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Contacts C = new Contacts();
                C.setID(Res.getInt(1));
                C.setUserOneID(Res.getInt(2));
                C.setUserTwoID(Res.getInt(3));
                C.setReqAccepted(Res.getInt(4));
                QL.add(C);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
    
    public List<Contacts> GetContacts(int ID)
    {
        
        List<Contacts> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `contacts` WHERE (UserOneID = ? OR UserTwoID = ?)";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID);
            stm.setInt(2, ID);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Contacts C = new Contacts();
                C.setID(Res.getInt(1));
                C.setUserOneID(Res.getInt(2));
                C.setUserTwoID(Res.getInt(3));
                C.setReqAccepted(Res.getInt(4));
                QL.add(C);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
    
     public Contacts ReturnContact(int ID1, int ID2)
    {
        
       Contacts C = new Contacts();
        
        try
        {
            String SQL = "SELECT * FROM `contacts` WHERE (UserOneID = ? AND UserTwoID = ?)";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID1);
            stm.setInt(2, ID2);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
               
                C.setID(Res.getInt(1));
                C.setUserOneID(Res.getInt(2));
                C.setUserTwoID(Res.getInt(3));
                C.setReqAccepted(Res.getInt(4));
                
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ContactsService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
        
    }


}
