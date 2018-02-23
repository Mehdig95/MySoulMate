/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import IService.ICommentaireService;
import Database.MyConnection;
import Entite.Commentaire;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class CommentaireService implements ICommentaireService{
    
    Connection con;
     PreparedStatement st ;
     Statement ste;
     

    public CommentaireService() {
        con = MyConnection.getInstance()
                .getConnection();
        try {
            ste = con.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void AjouterCommentaire(Commentaire Q) {
          try 
        {

            String SQL = "INSERT INTO `commentaire`(`commentaire`,`idUser`,`idPub`) VALUES  (?,?,?)";
            PreparedStatement stm;

            stm = con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setString(1, Q.getCommentaire());
            stm.setInt(2,Q.getIdUser());
             stm.setInt(3,Q.getIdPub());
           
    
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
               Q.getCommentaire();
               Q.getIdUser();
               Q.getIdPub();

                System.out.println(id);
            }
            System.out.println("ajout ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void ModifierCommentaire(Commentaire Q) {
         try 
        {
            String SQL = "UPDATE `Commentaire` SET `commentaire`= ? WHERE `id` = ?";
            PreparedStatement stm;

            stm = con.prepareStatement(SQL);

            stm.setString(1, Q.getCommentaire());
            stm.setInt(2, Q.getId());

            stm.execute();

            System.out.println("modifier ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void SupprimerCommentaire(int id) {
         try{
    
    String req4="DELETE FROM commentaire where id=?";
    st=con.prepareStatement(req4);
   
    st.setInt(1,id);
    st.executeUpdate();
    
     }catch(SQLException ex){
        Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
}   
    }

    @Override
    public List<Commentaire> affichertouslescommentaires() {
        
       List<Commentaire> commentaires = new ArrayList<>();
          Commentaire cc = null;
        try {
            String req="select * from commentaire";
            ResultSet res =  ste.executeQuery(req);
            while (res.next()) {                
       cc = new Commentaire(res.getInt("id"),res.getString("commentaire"));
           commentaires.add(cc);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentaires;
    }
   
    
    @Override
    public int AfficherByIDPub(int id) {
        
       List<Commentaire> commentaires = new ArrayList<>();
     

        try {
            String req = "SELECT * FROM commentaire WHERE idPub=?";
            PreparedStatement stm = con.prepareStatement(req);          
            stm.setInt(1, id);
            
            ResultSet res =  stm.executeQuery();
            
            while (res.next()) {                
            Commentaire cc = new Commentaire();
            cc.setIdPub(res.getInt(1));
            cc.setIdPub(res.getInt(4));
            cc.setIdUser(res.getInt(3));
            cc.setCommentaire(res.getString(2));
            commentaires.add(cc);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommentaireService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return commentaires.size();
    }
    
    }
    

