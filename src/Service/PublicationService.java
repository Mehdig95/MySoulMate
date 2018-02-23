/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import IService.IPublicationService;
import Database.MyConnection;
import Entite.Publication;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
 
public class PublicationService implements IPublicationService{

    
    private Connection Con;
    
    
 public PublicationService() {
     Con = MyConnection.getInstance().getConnection();
        
    }
    
    
    
    
    @Override
    public void ajouterPublication(Publication e) {
         
           try 
        {

            String SQL = "INSERT INTO `publication`(`text`, `image`, `video`, `id-user`) VALUES (?,?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setString(1, e.getText());
            stm.setString(2, e.getImage());
            stm.setString(3, e.getVideo());
            stm.setInt(4, e.getId_user());
            
            
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                e.setId_pub(id);

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
    public void modifierPublication(Publication e) {
        try 
        {
        String SQL = "UPDATE `publication` SET `text`= ?,`image`= ?,`video`= ?,`id-user`=? WHERE `id_pub` = ?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);

            stm.setString(1, e.getText());
          
            stm.setString(2, e.getImage());
            stm.setString(3, e.getVideo());
            

            stm.execute();

            System.out.println("modifier ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimerPublication(Publication e) {
           try 
        {
            String SQL = "DELETE FROM `publication` WHERE id_pub = ?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);
            stm.setInt(1, e.getId_pub());
            stm.execute();

            System.out.println("Supprimer ok");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  

    @Override
    public List<Publication> afficher(int id) {
        
        List<Publication> P = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `publication` WHERE `id-user`=?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, id);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Publication Q = new Publication();
                Q.setId_pub(Res.getInt(1));
                Q.setText(Res.getString(2));
             
                Q.setImage(Res.getString(3));
                Q.setVideo(Res.getString(4));
                Q.setId_user(Res.getInt(5));
               
                P.add(Q);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(PublicationService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return P;
        
    }
    }
        
    

  
    

