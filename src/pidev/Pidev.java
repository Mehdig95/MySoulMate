/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entite.Question;
import Enum.TypeQuestion;
import Service.QuestionService;

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
        
        Question Q = new Question("Votre conjoint(e) reçoit un appel de son ex :", TypeQuestion.QuestVieCouple, "Vous demandez aussitôt à passer sur liste rouge.", "Vous trouvez très bien qu'ils aient gardé de bons contacts.", "Vous lui dites d'en profiter pour l'inviter à dîner.", 5, 11 , 26);
        QuestionService Q1 = new QuestionService();
        Q1.AjouterQuestion(Q);
    }
    
}
