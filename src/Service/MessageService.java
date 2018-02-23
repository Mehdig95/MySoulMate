/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Message;
import Entite.Question;
import Enum.TypeQuestion;
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
public class MessageService {

    
    private Connection Con;
    
    public MessageService() {
        Con = MyConnection.getInstance().getConnection();
    }
    
   
        public void AjouterMessage(Message M)
    {
        try 
        {

            String SQL = "INSERT INTO `message`(`SenderID`, `ReceiverID`, `Message`, `SendTime`) VALUES (?,?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setInt(1, M.getSenderID());
            stm.setInt(2, M.getReceiverID());
            stm.setString(3, M.getMessage());
            stm.setDate(4, M.getSendTime());
           
            
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                M.setID(id);

                System.out.println(id);
            }
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }
        
        
       
    public List<Message> SelectMessage(int id1, int id2)
    {
        
        List<Message> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `message` WHERE (SenderID = ? AND ReceiverID = ?) OR (SenderID = ? AND ReceiverID = ?)";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, id1);
            stm.setInt(2, id2);
            stm.setInt(3, id2);
            stm.setInt(4, id1);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Message M  = new Message();
                M.setID(Res.getInt(1));
                M.setSenderID(Res.getInt(2));
                M.setReceiverID(Res.getInt(3));
                M.setMessage(Res.getString(4));
                M.setSendTime(Res.getDate(5));
                QL.add(M);
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }

}
