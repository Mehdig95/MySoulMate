/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Question;
import Enum.TypeQuestion;
import Service.QuestionService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class AjouterQuestionGUIController implements Initializable {

    @FXML
    private JFXTextField q;
    @FXML
    private JFXTextField r1;
    @FXML
    private JFXTextField r2;
    @FXML
    private JFXTextField r3;
    @FXML
    private JFXTextField s1;
    @FXML
    private JFXTextField s2;
    @FXML
    private JFXTextField s3;
    @FXML
    private JFXButton button;
    @FXML
    private JFXComboBox ComboType;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ComboType.getItems().add("Question Personalite");
        ComboType.getItems().add("Question Phsycologique");
        ComboType.getItems().add("Question Vie Couple");
        ComboType.getItems().add("Question Sociale");
    }    
    
    
    @FXML
    public void AddQuestion()
    {
        Question Q = new Question();
        Q.setQuestion(q.getText());
        Q.setReponse1(r1.getText());
        Q.setReponse2(r2.getText());
        Q.setReponse3(r3.getText());
        Q.setScoreRep1(Integer.parseInt(s1.getText()));
        Q.setScoreRep2(Integer.parseInt(s2.getText()));
        Q.setScoreRep3(Integer.parseInt(s3.getText()));
        String type = (String) ComboType.getValue();
        switch(type)
        {
            case "Question Personalite": Q.setType(TypeQuestion.QuestPersonalite); break;
            case "Question Physique": Q.setType(TypeQuestion.QuestPhysique); break;
            case "Question Vie Couple": Q.setType(TypeQuestion.QuestVieCouple); break;
            case "Question Sociale": Q.setType(TypeQuestion.QuestSociale); break;
        }
        
        QuestionService QS = new QuestionService();
        QS.AjouterQuestion(Q);
       
    
    }
    
    @FXML
    public void ClearFields()
    {
        q.setText("");
        r1.setText("");
        r2.setText("");
        r3.setText("");
        s1.setText("");
        s2.setText("");
        s3.setText("");
    }
}
