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
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(QuestionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
    }

    @Override
    public void ModifierQuestion(Question Q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SupprimerQuestion(Question Q) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Question> SelectQuestion(TypeQuestion T) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
