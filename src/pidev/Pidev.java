/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entite.Question;
import Entite.Reponse;
import Enum.TypeQuestion;
import Service.QuestionService;
import Service.ReponseService;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author CorpseRoot
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
       
        //Question Q = new Question("Votre conjoint(e) reçoit un appel de son ex :", TypeQuestion.QuestVieCouple, "Vous demandez aussitôt à passer sur liste rouge.", "Vous trouvez très bien qu'ils aient gardé de bons contacts.", "Vous lui dites d'en profiter pour l'inviter à dîner.", 5, 11 , 26);
        //-------------------------------------------------------------------------------------------------------------------
        Question Q1 = new Question("Question1", TypeQuestion.QuestVieCouple, "Reponse1", "Reponse2", "Reponse3", 6, 2, 18);
        Question Q2 = new Question("Question2", TypeQuestion.QuestVieCouple, "Reponse1", "Reponse2", "Reponse3", 4, 16, 2);
        Question Q3 = new Question("Question3", TypeQuestion.QuestVieCouple, "Reponse1", "Reponse2", "Reponse3", 9, 5, 19);
        //-------------------------------------------------------------------------------------------------------------------
        Question Q4 = new Question("Question4", TypeQuestion.QuestPhysique, "Reponse1", "Reponse2", "Reponse3", 15, 5, 7);
        Question Q5 = new Question("Question5", TypeQuestion.QuestPhysique, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);
       
        //-------------------------------------------------------------------------------------------------------------------
        Question Q6 = new Question("Question8", TypeQuestion.QuestPersonalite, "Reponse1", "Reponse2", "Reponse3", 5, 2, 2);
        Question Q7 = new Question("Question9", TypeQuestion.QuestPersonalite, "Reponse1", "Reponse2", "Reponse3", 5, 2, 5);
       
        //--------------------------------------------------------------------------------------------------------------------
         Question Q8 = new Question("Question12", TypeQuestion.QuestSociale, "Reponse1", "Reponse2", "Reponse3", 11, 25, 5);
        Question Q9 = new Question("Question13", TypeQuestion.QuestSociale, "Reponse1", "Reponse2", "Reponse3", 2, 6, 10);
      
       /* QuestionService QS = new QuestionService();
        
        QS.AjouterQuestion(Q1);
        QS.AjouterQuestion(Q2);
        QS.AjouterQuestion(Q3);
        QS.AjouterQuestion(Q4);
        QS.AjouterQuestion(Q5);
        QS.AjouterQuestion(Q6);
        QS.AjouterQuestion(Q7);
        QS.AjouterQuestion(Q8);
        QS.AjouterQuestion(Q9);*/
        
        
        Reponse R1 = new Reponse(1919, 26, new Date(1995, 02, 11), "Reponse3", 18);
        Reponse R2 = new Reponse(1919, 27, new Date(1995, 02, 11), "Reponse1", 4);
        Reponse R3 = new Reponse(1919, 28, new Date(1995, 02, 11), "Reponse2", 5);
        Reponse R4 = new Reponse(1919, 29, new Date(1995, 02, 11), "Reponse3", 7);
        Reponse R5 = new Reponse(1919, 30, new Date(1995, 02, 11), "Reponse1", 5);
        Reponse R6 = new Reponse(1919, 31, new Date(1995, 02, 11), "Reponse2", 2);
        Reponse R7 = new Reponse(1919, 32, new Date(1995, 02, 11), "Reponse3", 5);
        Reponse R8 = new Reponse(1919, 33, new Date(1995, 02, 11), "Reponse1", 11);
        Reponse R9 = new Reponse(1919, 34, new Date(1995, 02, 11), "Reponse2", 6);
        
        ReponseService RS = new ReponseService();
        /*RS.AjouterReponse(R1);
        RS.AjouterReponse(R2);
        RS.AjouterReponse(R3);
        RS.AjouterReponse(R4);
        RS.AjouterReponse(R5);
        RS.AjouterReponse(R6);
        RS.AjouterReponse(R7);
        RS.AjouterReponse(R8);
        RS.AjouterReponse(R9);*/
        
        RS.CalculerScore(1919);
        
        /*Q.setScoreRep1(3);
        Q.setScoreRep2(6);
        Q.setScoreRep3(25);
        QS.ModifierQuestion(Q);
        System.out.println(Q.toString());
        QS.SupprimerQuestion(Q);*/
        
        
       /* System.out.println("----");
        List<Question> List = QS.SelectQuestion(TypeQuestion.QuestPhysique);
        List.forEach((i) -> {
            System.out.println(i.toString());
        });
        System.out.println("----");*/
    }
    
}
