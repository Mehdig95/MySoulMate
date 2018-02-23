/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import IService.IJaimeService;
import Database.MyConnection;
import Entite.Jaime;
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
 * @author USER
 */
public class JaimeService implements IJaimeService{
  private Connection Con;
    
    
 public JaimeService() {
     Con = MyConnection.getInstance().getConnection();
        
    }
    @Override
    public void ajouterJaime(Jaime j) {
           try 
        {

            String SQL = "INSERT INTO `jaime`(`iduser`, `idpub`) VALUES (?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setInt(1, j.getIduser());
            stm.setInt(2, j.getIdpub());
            
            
            
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                j.setId_jaime(id);

                System.out.println(id);
            }
            System.out.println("ajout ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimerJaime(Jaime j) {
            try 
        {
            String SQL = "DELETE FROM `jaime` WHERE id_jaime = ?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);
            stm.setInt(1, j.getId_jaime());
            stm.execute();

            System.out.println("Supprimer ok");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Jaime> afficherJaime(int id) {
              List<Jaime> JJ = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `jaime` WHERE id_jaime = ?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, id);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Jaime J= new Jaime();
                J.setId_jaime(Res.getInt(1));
                J.setIduser(Res.getInt(2));
             
                J.setIdpub(Res.getInt(4));
                
               
                JJ.add(J);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return JJ;
        
    }

    @Override
    public int calculerJaime(int id) {
          List<Jaime> JJ = new ArrayList<>();
        try
        {
            String SQL = "SELECT * FROM `jaime` WHERE idpub = ?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, id);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Jaime J= new Jaime();
                J.setId_jaime(Res.getInt(1));
                J.setIduser(Res.getInt(2));
             
                J.setIdpub(Res.getInt(4));
                
               
                JJ.add(J);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return JJ.size();
        
    }
        
    }
    
    
    
    
    
    






