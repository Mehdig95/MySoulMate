/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Question;
import Enum.TypeQuestion;
import java.util.List;

/**
 *
 * @author CorpseRoot
 */
public interface IQuestionService 
{
    public void AjouterQuestion(Question Q);
    public void ModifierQuestion(Question Q);
    public void SupprimerQuestion(Question Q);
    public List<Question> SelectQuestion(TypeQuestion T);
    public List<Question> SelectQuestion(int ID);
    
}
