/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Client;
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
public class ClientService {

    private Connection Con;
    
    public ClientService()
    {
        Con = MyConnection.getInstance().getConnection();
    }
   
    
    
     public List<Client> SelectClientWithSameInterest(Client I) {
        
          List<Client> L = new ArrayList<>();
          try {
              String SQL = "SELECT * FROM `Client` WHERE (`ID` != ? AND ((`InteretPhy` >= ? AND `InteretPhy` <= ?) OR (`InteretPerso` >= ? AND `InteretPerso` <= ?) OR (`InteretSoc` >= ? AND `InteretSoc` <= ?) OR (`InteretVieC` >= ? AND `InteretVieC` <= ?)) ) ";
              PreparedStatement stm;
              
              stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);
              
              stm.setInt(1, I.getID());
              stm.setInt(2, (I.getPourcentagePhy()-10));
              stm.setInt(3, (I.getPourcentagePhy()+10));
              stm.setInt(4, I.getPourcentagePerso()-10);
              stm.setInt(5, I.getPourcentagePerso()+10);
              stm.setInt(6, I.getPourcentageSoc()-10);
              stm.setInt(7, I.getPourcentageSoc()+10);
              stm.setInt(8, I.getPourcentageVieC()-10);
              stm.setInt(9, I.getPourcentageVieC()+10);
              
               ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Client C = new Client();
                C.setID(Res.getInt(1));
                C.setNom(Res.getString(2));
                C.setAge(Res.getInt(3));
                C.setSexe(Res.getInt(4));
                C.setMail(Res.getString(5));
                C.setAdresse(Res.getString(6));
                C.setTelephone(Res.getString(7));
                C.setMDP(Res.getString(8));
                C.setEtat(Res.getInt(9));
                C.setVerifié(Res.getInt(10));
                C.setIP(Res.getString(11));
                C.setPhoto(Res.getString(12));
                C.setPourcentagePhy(Res.getInt(13));
                C.setPourcentagePerso(Res.getInt(14));
                C.setPourcentageSoc(Res.getInt(15));
                C.setPourcentageVieC(Res.getInt(16));
                L.add(C);
            }
              
              
          } catch (SQLException ex) {
              Logger.getLogger(InterestService.class.getName()).log(Level.SEVERE, null, ex);
          }
          return L;
    }
     
    public void UpdateInterest(int ID, int S1, int S2, int S3, int S4)
    {
        
        try 
        {
            String SQL = "UPDATE `client` SET `InteretPhy`=?,`InteretPerso`=?,`InteretSoc`=?,`InteretVieC`=? WHERE ID =? ";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);

            stm.setInt(1, S1);
            stm.setInt(2, S2);
            stm.setInt(3, S3);
            stm.setInt(4, S4);
            stm.setInt(5, ID);

            stm.execute();

            
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
     public Client SelectClient(int ID)
    { 
        Client C = new Client();
        try
        {
            
            String SQL = "SELECT * FROM `Client` WHERE ID=?";
            PreparedStatement stm = Con.prepareStatement(SQL);          
            
            stm.setInt(1, ID);
            ResultSet Res = stm.executeQuery();
            while (Res.next()) 
            {
              
               C.setID(Res.getInt(1));
               C.setNom(Res.getString(2));
               C.setAge(Res.getInt(3));
               C.setSexe(Res.getInt(4));
               C.setMail(Res.getString(5));
               C.setAdresse(Res.getString(6));
               C.setTelephone(Res.getString(7));
               C.setMDP(Res.getString(8));
               C.setEtat(Res.getInt(9));
               C.setVerifié(Res.getInt(10));
               C.setIP(Res.getString(11));
               C.setPhoto(Res.getString(12));
               C.setPourcentagePhy(Res.getInt(13));
               C.setPourcentagePerso(Res.getInt(14));  
               C.setPourcentageSoc(Res.getInt(15));
               C.setPourcentageVieC(Res.getInt(16));
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ClientService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return C;
        
    }
    
    
}
