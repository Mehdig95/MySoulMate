/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entite.Question;
import Enum.TypeQuestion;
import Service.QuestionService;
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
        
       
      /*  Question Q = new Question("Votre conjoint(e) reçoit un appel de son ex :", TypeQuestion.QuestVieCouple, "Vous demandez aussitôt à passer sur liste rouge.", "Vous trouvez très bien qu'ils aient gardé de bons contacts.", "Vous lui dites d'en profiter pour l'inviter à dîner.", 5, 11 , 26);
        Question Q1 = new Question("Question1", TypeQuestion.QuestFamille, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);
        Question Q2 = new Question("Question2", TypeQuestion.QuestFamille, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);
        Question Q3 = new Question("Question3", TypeQuestion.QuestVieCouple, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);
        Question Q4 = new Question("Question4", TypeQuestion.QuestFamille, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);
        Question Q5 = new Question("Question5", TypeQuestion.QuestVieCouple, "Reponse1", "Reponse2", "Reponse3", 5, 2, 19);*/
        QuestionService QS = new QuestionService();
       /* QS.AjouterQuestion(Q);
        QS.AjouterQuestion(Q1);
        QS.AjouterQuestion(Q2);
        QS.AjouterQuestion(Q3);
        QS.AjouterQuestion(Q4);
        QS.AjouterQuestion(Q5);
        
        System.out.println(Q.toString());
        Q.setScoreRep1(3);
        Q.setScoreRep2(6);
        Q.setScoreRep3(25);
        QS.ModifierQuestion(Q);
        System.out.println(Q.toString());
        QS.SupprimerQuestion(Q);*/
        System.out.println("----");
        List<Question> List = QS.SelectQuestion(TypeQuestion.QuestFamille);
        List.forEach((i) -> {
            System.out.println(i.toString());
        });
        System.out.println("----");
    }
    
}
