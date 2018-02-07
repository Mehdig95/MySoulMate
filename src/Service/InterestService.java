/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Interest;
import IService.IInterestService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CorpseRoot
 */
public class InterestService implements IInterestService
{
      private Connection Con;

    public InterestService() 
    {    
        Con = MyConnection.getInstance().getConnection();
    }

    @Override
    public void AjouterInterest(Interest I) 
    {
        
         try 
        {

            String SQL = "INSERT INTO `Interets`(`ID_User`, `InteretPhy`, `InteretPerso`, `InteretSoc`, `InteretVieC`) VALUES (?,?,?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setInt(1, I.getID_User());
            stm.setInt(2, I.getPourcentagePhy());
            stm.setInt(3, I.getPourcentagePerso());
            stm.setInt(4, I.getPourcentageSoc());
            stm.setInt(5, I.getPourcentageVieC());
    
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                I.setID(id);

                System.out.println(id);
            }
            System.out.println("ajout ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(InterestService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
        
    }

    @Override
    public ArrayList<Integer> SelectInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
      
      
      
      
    
}
