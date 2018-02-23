/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Client;
import Entite.Contacts;
import Service.ClientService;
import Service.ContactsService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Pagination;
import javafx.scene.control.Separator;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Callback;


/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class MatchingGUIController implements Initializable {

    @FXML
    private Pagination pagination;
    
    private  int PaginationSize = 0;
    private List<Client> LC = new ArrayList<Client>();
    
    @FXML
    private ImageView ImageSpace;
    @FXML
    private Label NameSpace;
    @FXML
    private VBox VboxHolder;
    @FXML
    private JFXButton ProfButton;
    @FXML
    private JFXButton ProfButton2;
    
    public static int CurrentUserID = 2;
    /**
     * Initializes the controller class.
     */
    
    private VBox LoadCharacter( int pageIndex)
    {   Client C = LC.get(pageIndex);
        System.out.println(C.toString());
        Image a1 = new Image("/Presentation/" + C.getPhoto());
        ImageSpace.setImage(a1);
        NameSpace.setText(C.getNom());
        VboxHolder.setAlignment(Pos.CENTER);
        ContactsService CS = new ContactsService();
        List<Contacts> ContactList = CS.GetContacts(C.getID());
        for(Contacts Co: ContactList)
        {
                if((Co.getUserOneID() == C.getID() || Co.getUserTwoID() == C.getID()) && Co.getReqAccepted() == 1)
                {
                    ProfButton2.setText("Message");
                    //ProfButton2.setDisable(true);
                    return VboxHolder;
                }
                if(Co.getUserOneID() == CurrentUserID  && Co.getReqAccepted() == 0)
                {
                    ProfButton2.setText("Pending");
                    ProfButton2.setDisable(true);
                    return VboxHolder;
                }
                if( Co.getUserTwoID() == CurrentUserID && Co.getReqAccepted() == 0)
                {
                    ProfButton2.setText("Accepter");
                    ProfButton2.setDisable(false);
                    return VboxHolder;
                }
                
                
        }
        ProfButton2.setText("Ajouter");
        ProfButton2.setDisable(false);
        
        return VboxHolder;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ClientService CS = new ClientService();
        Client U = CS.SelectClient(CurrentUserID);
        LC = CS.SelectClientWithSameInterest(U);
        PaginationSize = LC.size();
        pagination.setPageCount(PaginationSize);
        pagination.getStyleClass().add(Pagination.STYLE_CLASS_BULLET);
        pagination.setStyle("-fx-page-information-visible: false;");
        
        pagination.setPageFactory(new Callback<Integer, Node>() {
        public Node call(Integer pageIndex)
        {
          
              return LoadCharacter(pageIndex);
        
        }               
        });
    }    
    
    @FXML
    private void ViewProfile() throws IOException
    { 
        
        FXMLLoader  Loader = new FXMLLoader(getClass().getResource("ProfileFXML.fxml"));
        AnchorPane A = Loader.load();
        
        
        ProfileFXMLController PFC = Loader.getController();
       
        Client C = LC.get(pagination.getCurrentPageIndex());
        System.out.println( pagination.getCurrentPageIndex());
        PFC.SetClient(C);
        PFC.LoadProfile();
        Stage S = new Stage();
        JFXDecorator decorator = new JFXDecorator(S, A, false, false, true);
        decorator.setCustomMaximize(false);
        
        Scene scene = new Scene(decorator , 358  , 605);
        scene.getStylesheets().add(MainFX.class.getResource("/Presentation/Styles.css").toExternalForm());
        S.setScene(scene);
        S.initStyle(StageStyle.UNDECORATED);
        S.show();
        
     //   S.setScene(value);
    }
    
    @FXML
    private void ButtonManager() throws IOException
    {
        Client C = LC.get(pagination.getCurrentPageIndex());
        Contacts Contact = new Contacts();
        ContactsService CS = new ContactsService();
        if(ProfButton2.getText().equals("Message"))
        {
            FXMLLoader  Loader = new FXMLLoader(getClass().getResource("ChatGUI.fxml"));
            AnchorPane A = Loader.load();
            
            ChatGUIController CGI = Loader.getController();
            CGI.SetClient(C);
            CGI.LoadPage();
            Stage S = new Stage();
            JFXDecorator decorator = new JFXDecorator(S, A, false, false, true);
            decorator.setCustomMaximize(false);

            Scene scene = new Scene(decorator, 430, 625);
            scene.getStylesheets().add(MainFX.class.getResource("/Presentation/Styles.css").toExternalForm());
            S.setScene(scene);
            S.initStyle(StageStyle.UNDECORATED);
            S.show();
        }
        else if(ProfButton2.getText().equals("Accepter"))
        {
            
            ProfButton2.setText("Message");
            Contact = CS.ReturnContact(C.getID(), CurrentUserID);
            CS.ModifierContact(Contact, 1);
  
        }
        else
        {
            ProfButton2.setText("Pending");
            ProfButton2.setDisable(true);
            Contact.setUserOneID(CurrentUserID);
            Contact.setUserTwoID(C.getID());
            Contact.setReqAccepted(0);
            CS.AjouterContact(Contact);
        }
        
    }
}
