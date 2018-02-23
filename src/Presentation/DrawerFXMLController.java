/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class DrawerFXMLController implements Initializable {

    private AnchorPane QuestionGUI, FormulaireGUI, QuestionEditGUI;
    
    @FXML
    private JFXButton button1;
    @FXML
    private JFXButton button2;
    @FXML
    private JFXButton button3;
    @FXML
    private JFXButton button4;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            QuestionGUI = FXMLLoader.load(getClass().getResource("AjouterQuestionGUI.fxml"));
            FormulaireGUI = FXMLLoader.load(getClass().getResource("FormulaireGUI.fxml"));
            QuestionEditGUI =  FXMLLoader.load(getClass().getResource("ModifierQuestionGUI.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(DrawerFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    @FXML
    private void NavigateToQuestionGUI()
    {
        DashboardFXMLController.Root.getChildren().clear();
        DashboardFXMLController.Root.getChildren().add(QuestionGUI);
    }
    
    @FXML
    private void NavigateToFormulaireGUI()
    {
        DashboardFXMLController.Root.getChildren().clear();
        DashboardFXMLController.Root.getChildren().add(FormulaireGUI);
    }
    
    @FXML
    private void NavigateToQuestionEditGUI()
    {
        DashboardFXMLController.Root.getChildren().clear();
        DashboardFXMLController.Root.getChildren().add(QuestionEditGUI);
    }

}
