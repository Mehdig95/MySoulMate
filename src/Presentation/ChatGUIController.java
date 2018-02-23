/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Client;
import Entite.Message;
import Service.MessageService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Font;
import java.net.URL;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class ChatGUIController implements Initializable {

    @FXML
    private VBox chatVbox;
    @FXML
    private ImageView chatimage;
    @FXML
    private Label labelto;
    
     Client Cl = new Client();
     MessageService MS = new MessageService();
    @FXML
    private JFXTextField input;
    @FXML
    private JFXButton sendbut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }  
    
    public void LoadPage()
    {
        Image Icon = new Image("/Presentation/"+Cl.getPhoto());
        chatimage.setImage(Icon);
        labelto.setText("You are now talking to " + Cl.getNom());  
        List<Message> LM = MS.SelectMessage(1, Cl.getID());
        for(Message x: LM)
        {
            if(x.getSenderID() == Cl.getID())
            {
                Label L = new Label("   " + x.getMessage()+ "    " );
                L.setStyle("-fx-background-color: #FFDCDC;"
                        + "-fx-background-radius: 30;"
                        + "-fx-border-radius: 30;");
                 L.setAlignment(Pos.CENTER_LEFT);
                 L.setTextAlignment(TextAlignment.LEFT);
                 L.setTranslateX(210);
                chatVbox.getChildren().add(L);
            
            }
            else if(x.getReceiverID() == Cl.getID())
            {
                Label L = new Label("   " + x.getMessage()+"   ");
                L.setStyle("-fx-background-color: #FFFFFF;"
                        + "-fx-background-radius: 30;"
                        + "-fx-border-radius: 30;");
                L.setAlignment(Pos.CENTER_RIGHT);
                
                chatVbox.getChildren().add(L);
                
            }
            Label Space = new Label("        ");
            chatVbox.getChildren().add(Space);
        }
    }
    
    @FXML
    public void SendMessage()
    {
        if(input.getText().length() == 0)
        {
            System.out.println("feragh sahbi");
        }
        else
        {
            Date date = new Date(5,12, 2008);
            Message M = new Message(MatchingGUIController.CurrentUserID ,Cl.getID() , input.getText(), date);
            MS.AjouterMessage(M);
            Label lab = new Label("    " + input.getText() + "   ");
            lab.setStyle( "-fx-background-color: #FFFFFF;"+
                          "-fx-background-radius: 30;"+
                          "-fx-border-radius: 30;");
            chatVbox.getChildren().add(lab);
        }
    }
    
    @FXML
    private void Refresh()
    {
        chatVbox.getChildren().clear();
        LoadPage();
    }
    
    public void SetClient(Client C)
    {
        Cl=C;
    }
}
