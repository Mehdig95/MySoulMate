/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Database.MyConnection;
import Entite.Interest;
import Entite.Question;
import Entite.Reponse;
import Enum.TypeQuestion;
import IService.IReponseService;
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
public class ReponseService implements IReponseService {
    
    private Connection Con;

    public ReponseService()
    {    
        Con = MyConnection.getInstance().getConnection();
    }
        

    @Override
    public void AjouterReponse(Reponse R) 
    {
        
         try 
        {

            String SQL = "INSERT INTO `reponse`(`ID_User`, `ID_Question`, `DateReponse`, `Reponse`, `Score`) VALUES  (?,?,?,?,?)";
            PreparedStatement stm;

            stm = Con.prepareStatement(SQL, PreparedStatement.RETURN_GENERATED_KEYS);

            stm.setInt(1, R.getID_User());
            stm.setInt(2, R.getID_Question());
            stm.setDate(3, R.getDateReponse());
            stm.setString(4, R.getReponse());
            stm.setInt(5, R.getScore());
    
            stm.execute();
            
            ResultSet Res = stm.getGeneratedKeys();
            int id = 0;
            if (Res.next())
            {
                id = (int) Res.getInt(1);
                R.setID(id);

                System.out.println(id);
            }
            System.out.println("ajout ok");
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    }

    @Override
    public List<Reponse> SelectReponse(int ID) {
         List<Reponse> RL = new ArrayList<>();
        
        try
        {
            String SQL = "SELECT * FROM `reponse` WHERE ID_User = ?";
            PreparedStatement stm = Con.prepareStatement(SQL);
            stm.setInt(1, ID);
            ResultSet Res = stm.executeQuery();
            
            while (Res.next()) 
            {
                Reponse R = new Reponse();
                R.setID(Res.getInt(1));
                R.setID_User(Res.getInt(2));
                R.setID_Question(Res.getInt(3));
                R.setDateReponse(Res.getDate(4));
                R.setReponse(Res.getString(5));
                R.setScore(Res.getInt(6));
               
                RL.add(R);
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(ReponseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RL;
    }

    @Override
    public void CalculerScore(int ID_User)
    {
       ReponseService RS = new ReponseService();
       List<Reponse> RepList = RS.SelectReponse(ID_User);
       QuestionService QS = new QuestionService();
       int ScorePhy = 0, ScorePerso = 0, ScoreVieCouple = 0, ScoreSociale = 0;
       int NombreQPhy = 0, NombreQPerso = 0, NombreQVieCouple = 0, NombreQSociale = 0;
       for(Reponse R: RepList)
       {
           List<Question> QuestList =  QS.SelectQuestion(R.getID_Question());
           for(Question Q: QuestList)
           {
               switch(Q.getType())
               {
                   case QuestPersonalite:
                   {
                       ScorePerso += R.getScore();
                       NombreQPerso++;
                       break;
                   }
                   case QuestPhysique:
                   {
                       ScorePhy += R.getScore();
                       NombreQPhy++;
                       break;
                   }
                   case QuestSociale:
                   {
                       ScoreSociale += R.getScore();
                       NombreQSociale++;
                       break;
                   }
                   case QuestVieCouple:
                   {
                       ScoreVieCouple += R.getScore();
                       NombreQVieCouple++;
                       break;
                   }
                   
               }
           }
       }
       
       int PourcentagePhy = (ScorePhy*NombreQPhy);
       int PourcentagePerso = (ScorePerso*NombreQPerso);
       int PourcentageVieCouple = (ScoreVieCouple*NombreQVieCouple);
       int PourcentageSociale = (ScoreSociale*NombreQSociale);
       
       Interest I = new Interest(ID_User, PourcentagePhy, PourcentagePerso, PourcentageSociale, PourcentageVieCouple);
       InterestService IS = new InterestService();
       IS.AjouterInterest(I);
       
       
       
        
    }
    
     
     
    
}
