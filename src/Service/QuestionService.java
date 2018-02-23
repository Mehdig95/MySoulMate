/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Question;
import Enum.TypeQuestion;
import IService.IQuestionService;
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
public class QuestionService implements IQuestionService
{
    
    private Connection Con;

    public QuestionService()
    {
       Con = MyConnection.getInstance().getConnection();
    }
    

    @Override
    public void AjouterQuestion(Question Q)
    {
        try 
        {

            String SQL = "INSERT INTO `question`(`Question`, `Type`, `Reponse1`, `Reponse2`, `Reponse3`, `ScoreRep1`, `ScoreRep2`, `ScoreRep3`) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setString(1, Q.getQuestion());
            stm.setInt(2, Q.getType().getTypeID());
            stm.setString(3, Q.getReponse1());
            stm.setString(4, Q.getReponse2());
            stm.setString(5, Q.getReponse3());
            stm.setInt(6, Q.getScoreRep1());
            stm.setInt(7, Q.getScoreRep2());
            stm.setInt(8, Q.getScoreRep3());
            
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                Q.setID(id);

                System.out.println(id);
            }
            System.out.println("ajout ok");
            NotificationService NS = new NotificationService();
            NS.displayNotification("MySoulMate", "Question added successfully!");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @Override
    public void ModifierQuestion(Question Q) 
    {
        
        try 
        {
            String SQL = "UPDATE `question` SET `Question`= ? ,`Type` = ? ,`Reponse1`= ?,`Reponse2`=?,`Reponse3`= ?,`ScoreRep1`= ? ,`ScoreRep2`= ? ,`ScoreRep3`= ? WHERE `ID` = ?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);

            stm.setString(1, Q.getQuestion());
            stm.setInt(2, Q.getType().getTypeID());
            stm.setString(3, Q.getReponse1());
            stm.setString(4, Q.getReponse2());
            stm.setString(5, Q.getReponse3());
            stm.setInt(6, Q.getScoreRep1());
            stm.setInt(7, Q.getScoreRep2());
            stm.setInt(8, Q.getScoreRep3());
            stm.setInt(9, Q.getID());

            stm.execute();

            NotificationService NS = new NotificationService();
            NS.displayNotification("Youssef", "Question modified successfully!");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    @Override
    public void SupprimerQuestion(Question Q)
    {
        try 
        {
            String SQL = "DELETE FROM `question` WHERE ID = ?";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL);
            stm.setInt(1, Q.getID());
            stm.execute();

            NotificationService NS = new NotificationService();
            NS.displayNotification("MySoulMate", "Question deleted successfully!");
        }
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Question> SelectQuestion(TypeQuestion T)
    {
        
        List<Question> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `question` WHERE Type = ?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, T.getTypeID());
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Question Q = new Question();
                Q.setID(Res.getInt(1));
                Q.setQuestion(Res.getString(2));
                int TypeID = Res.getInt(3) - 1;
                Q.setType(TypeQuestion.values()[TypeID]);
                Q.setReponse1(Res.getString(4));
                Q.setReponse2(Res.getString(5));
                Q.setReponse3(Res.getString(6));
                Q.setScoreRep1(Res.getInt(7));
                Q.setScoreRep2(Res.getInt(8));
                Q.setScoreRep3(Res.getInt(9));
                QL.add(Q);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
    
     public List<Question> SelectQuestion(int ID)
    {
        
        List<Question> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `question` WHERE ID = ?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Question Q = new Question();
                Q.setID(Res.getInt(1));
                Q.setQuestion(Res.getString(2));
                int TypeID = Res.getInt(3) - 1;
                Q.setType(TypeQuestion.values()[TypeID]);
                Q.setReponse1(Res.getString(4));
                Q.setReponse2(Res.getString(5));
                Q.setReponse3(Res.getString(6));
                Q.setScoreRep1(Res.getInt(7));
                Q.setScoreRep2(Res.getInt(8));
                Q.setScoreRep3(Res.getInt(9));
                QL.add(Q);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
     
      public List<Question> SelectQuestion()
    {
        
        List<Question> QL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `question` limit 10";
            PreparedStatement stm = Con.prepareStatement(SQL);          
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Question Q = new Question();
                Q.setID(Res.getInt(1));
                Q.setQuestion(Res.getString(2));
                int TypeID = Res.getInt(3) - 1;
                Q.setType(TypeQuestion.values()[TypeID]);
                Q.setReponse1(Res.getString(4));
                Q.setReponse2(Res.getString(5));
                Q.setReponse3(Res.getString(6));
                Q.setScoreRep1(Res.getInt(7));
                Q.setScoreRep2(Res.getInt(8));
                Q.setScoreRep3(Res.getInt(9));
                QL.add(Q);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return QL;
        
    }
    
}
