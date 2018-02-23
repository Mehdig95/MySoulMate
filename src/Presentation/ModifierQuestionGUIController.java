/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Question;
import Enum.TypeQuestion;
import Service.QuestionService;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.controlsfx.control.CheckComboBox;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class ModifierQuestionGUIController implements Initializable {

    @FXML
    private TableView<Question> tableView;
    @FXML
    private JFXTextField QuestionLabel;
    @FXML
    private JFXTextField Rep1Label;
    @FXML
    private JFXTextField Rep2Label;
    @FXML
    private JFXTextField Rep3Label;
    @FXML
    private JFXTextField Score1;
    @FXML
    private JFXTextField Score2;
    @FXML
    private JFXTextField Score3;
    @FXML
    private JFXComboBox ComboBox;
    @FXML
    private TableColumn<Question, Integer> ColumnID;
    @FXML
    private TableColumn<Question, String> ColumnQuestion;
    @FXML
    private TableColumn<Question, Integer> ColumnType;
    @FXML
    private JFXTextField IDLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBox.getItems().add(TypeQuestion.QuestPersonalite);
        ComboBox.getItems().add(TypeQuestion.QuestPhysique);
        ComboBox.getItems().add(TypeQuestion.QuestVieCouple);
        ComboBox.getItems().add(TypeQuestion.QuestPersonalite);

        LoadFromDatabase();
        
       // tableView.getSelectionModel().setCellSelectionEnabled(true);
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Question>(){
            @Override
            public void changed(ObservableValue<? extends Question> observable, Question oldValue, Question newValue) {
               QuestionLabel.setText(observable.getValue().getQuestion());
               Rep1Label.setText(observable.getValue().getReponse1());
               Rep2Label.setText(observable.getValue().getReponse2());
               Rep3Label.setText(observable.getValue().getReponse3());
               Score1.setText(Integer.toString(observable.getValue().getScoreRep1()));
               Score2.setText(Integer.toString(observable.getValue().getScoreRep2()));
               Score3.setText(Integer.toString(observable.getValue().getScoreRep3()));
               ComboBox.setPromptText(observable.getValue().getType().getNomDeType());
               IDLabel.setText(Integer.toString(observable.getValue().getID()));
            }
            
        });
    }
    
    private void LoadFromDatabase()
    {
        QuestionService QS = new QuestionService();
        ObservableList<Question> QOL = FXCollections.observableArrayList(QS.SelectQuestion());
        ColumnID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        ColumnQuestion.setCellValueFactory(new PropertyValueFactory<>("Question"));
        ColumnType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        tableView.setItems(QOL);
        
    }

    @FXML  
    private void SupprimerQuestion()
    {
        Question Q = new Question();
        Q.setID(Integer.parseInt(IDLabel.getText()));
        Q.setQuestion(QuestionLabel.getText());
        Q.setReponse1(Rep1Label.getText());
        Q.setReponse2(Rep2Label.getText());
        Q.setReponse3(Rep3Label.getText());
        Q.setScoreRep1(Integer.parseInt(Score1.getText()));
        Q.setScoreRep2(Integer.parseInt(Score2.getText()));
        Q.setScoreRep3(Integer.parseInt(Score3.getText()));
        Q.setType((TypeQuestion) ComboBox.getValue());
        QuestionService QS = new QuestionService();
        QS.SupprimerQuestion(Q);
        LoadFromDatabase();
    }
    
    @FXML
    private void ModifierQuestion()
    {
        Question Q = new Question();
        Q.setID(Integer.parseInt(IDLabel.getText()));
        Q.setQuestion(QuestionLabel.getText());
        Q.setReponse1(Rep1Label.getText());
        Q.setReponse2(Rep2Label.getText());
        Q.setReponse3(Rep3Label.getText());
        Q.setScoreRep1(Integer.parseInt(Score1.getText()));
        Q.setScoreRep2(Integer.parseInt(Score2.getText()));
        Q.setScoreRep3(Integer.parseInt(Score3.getText()));
        Q.setType((TypeQuestion) ComboBox.getValue());
        QuestionService QS = new QuestionService();
        QS.ModifierQuestion(Q);
        LoadFromDatabase();
        
        
    }
    
}
