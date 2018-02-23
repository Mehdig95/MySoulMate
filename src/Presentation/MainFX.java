/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author CorpseRoot
 */
public class MainFX extends Application {
    
    @Override
    
    public void start(Stage primaryStage) throws IOException {
       
        //Parent root = FXMLLoader.load(getClass().getResource("FormulaireGUI.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("PublicChatGUI.fxml"));
        JFXDecorator decorator = new JFXDecorator(primaryStage, root, false, false, true);
        decorator.setCustomMaximize(false);
        
        Scene scene = new Scene(decorator , 750  , 560);
        scene.getStylesheets().add(MainFX.class.getResource("/Presentation/Styles.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
