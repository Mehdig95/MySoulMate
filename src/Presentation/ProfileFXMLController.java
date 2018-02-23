/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Client;
import Entite.Publication;
import Service.CommentaireService;
import Service.JaimeService;
import Service.PublicationService;
import com.jfoenix.controls.JFXScrollPane;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class ProfileFXMLController implements Initializable {

    @FXML
    private Label AgeSpace;
    @FXML
    private Label NameSpace;
    @FXML
    private VBox profileSpace;
    @FXML
    private ImageView ImageSpace;
    @FXML
    private ScrollPane scroll;
    Client Cl = new Client();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }   
    
    @FXML
    public void LoadProfile()
    {
        System.out.println("C1:" + Cl.getNom());
        Image I = new Image("/Presentation/"+Cl.getPhoto());
        ImageSpace.setImage(I);
        
        NameSpace.setText(Cl.getNom());
        AgeSpace.setText(Cl.getAge() +" ans");
        System.out.println(Cl.getID());
        PublicationService PS = new PublicationService();
        CommentaireService CS = new CommentaireService();
        JaimeService JS = new JaimeService();
        List<Publication> List = PS.afficher(Cl.getID());
        if(List.size()==0)
        {
            System.out.println("aucun pub");
        }
        
        for(Publication x: List)
        {
            Label LabelName = new Label(Cl.getNom());
            Label PublicationLabel = new Label(x.getText());
            int Com = CS.AfficherByIDPub(x.getId_pub());
            int Jaime = JS.calculerJaime(x.getId_pub());
            Separator S = new Separator();
            Label Space1 = new Label(Integer.toString(Com));
            Label Space2 = new Label(Integer.toString(Jaime));
            Image ComIcon = new Image("/Presentation/commentaire.png");
            ImageView ComIconView = new ImageView();
            Image JaimeIcon = new Image("/Presentation/like.png");
            ImageView JaimeIconView = new ImageView();
            JaimeIconView.setImage(JaimeIcon);
            ComIconView.setImage(ComIcon);
            
            Label Space = new Label("             ");
            VBox box = new VBox();
            
            HBox box2 = new HBox();
            box2.getChildren().add(Space2);
            box2.getChildren().add(JaimeIconView);
            box2.getChildren().add(Space1);
            box2.getChildren().add(ComIconView);
            box.setStyle("-fx-padding: 10;"+
                      "-fx-border-style: solid inside;" + 
                      "-fx-border-radius: 5;" + 
                      "-fx-border-color: #FFFFFF;"+
                      "-fx-background-color: #FEF3F3;");
            box2.setStyle("-fx-background-color: #FEF3F3;");
            box.getChildren().add(LabelName);
            box.getChildren().add(PublicationLabel);
            box.getChildren().add(Space);
            box.getChildren().add(S);
           // box.getChildren().add(Space1);
            Label Space3 = new Label("     ");
            profileSpace.getChildren().add(box);
            box.getChildren().add(box2);
            profileSpace.getChildren().add(Space3);
            scroll.setContent(profileSpace);
            
        }
    }
    
    public void SetClient(Client C)
    {
        Cl=C;
    }
    
}
