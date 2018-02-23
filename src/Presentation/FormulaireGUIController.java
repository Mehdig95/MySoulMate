/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Question;
import Service.ClientService;
import Service.QuestionService;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDecorator;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class FormulaireGUIController implements Initializable {

    @FXML
    private VBox vbox1;
    @FXML
    private VBox vbox2;
    @FXML
    private VBox vbox3;
    @FXML
    private VBox vbox4;

    public int ScoreT1 = 0, ScoreT2 = 0, ScoreT3 = 0, ScoreT4 = 0;
    public int i = 1;
    public int type1 = 1;
    public int type2 = 1;
    public int type3 = 1;
    public int type4 = 1;
    @FXML
    private AnchorPane anchor;
    @FXML
    private JFXButton valider;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      /*  for(int i=0;i<60;i++)
        {
            ComboBox CB = (ComboBox) C.lookup
        }*/
        
        QuestionService QS = new QuestionService();
        List<Question> K = new ArrayList<Question>();
        K = QS.SelectQuestion();
        for (Question x : K) {
            if (i < 60) {
                if ((x.getType().getTypeID() == 1) & (type1 <= 3)) {
                    Label L = new Label(x.getQuestion());
                    ComboBox C = new ComboBox();
                    C.getItems().add(x.getReponse1());
                    C.getItems().add(x.getReponse2());
                    C.getItems().add(x.getReponse3());
                    C.setPromptText("Pick one below..");
                    C.setId("c" + i);
                    System.out.println(C.getId());
                    vbox1.getChildren().add(L);
                    vbox1.getChildren().add(C);
                  
                    type1++;
                    C.valueProperty().addListener(new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                            if (newValue == x.getReponse1()) {
                                ScoreT1 += x.getScoreRep1();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT1 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT1 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT1 -= x.getScoreRep2();
                                }
                                System.out.println("S1:"+ScoreT1);
                            } else if (newValue == x.getReponse2()) {
                                ScoreT1 += x.getScoreRep2();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT1 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT1 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT1 -= x.getScoreRep2();
                                }
                                System.out.println("S1:"+ScoreT1);
                            } else if (newValue == x.getReponse3()) {
                                ScoreT1 += x.getScoreRep3();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT1 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT1 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT1 -= x.getScoreRep2();
                                }
                                System.out.println("S1:"+ScoreT1);
                               
                            }
                             
                        }
                    });

                } else if ((x.getType().getTypeID() == 2) & (type2 <= 3)) {
                    Label L = new Label(x.getQuestion());
                    ComboBox C = new ComboBox();
                   
                    C.getItems().add(x.getReponse1());
                    C.getItems().add(x.getReponse2());
                    C.getItems().add(x.getReponse3());
                    C.setPromptText("Pick one below..");
                    C.setId("c" + i);
                    System.out.println(C.getId());
                    vbox2.getChildren().add(L);
                    vbox2.getChildren().add(C);
                    
                    type2++;
                    C.valueProperty().addListener(new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                           
                            if (newValue == x.getReponse1()) {
                                ScoreT2 += x.getScoreRep1();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT2 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT2 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT2 -= x.getScoreRep2();
                                }
                                System.out.println("S2:"+ScoreT2);
                            } else if (newValue == x.getReponse2()) {
                                ScoreT2 += x.getScoreRep2();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT2 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT2 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT2 -= x.getScoreRep2();
                                }
                                System.out.println("S2:"+ScoreT2);
                            } else if (newValue == x.getReponse3()) {
                                ScoreT2 += x.getScoreRep3();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT2 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT2 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT2 -= x.getScoreRep2();
                                }
                                System.out.println("S2:"+ScoreT2);
                               
                            }
                        }
                    });
                } else if ((x.getType().getTypeID() == 3) & (type3 <= 3)) {
                    Label L = new Label(x.getQuestion());
                    ComboBox C = new ComboBox();
                    
                    C.getItems().add(x.getReponse1());
                    C.getItems().add(x.getReponse2());
                    C.getItems().add(x.getReponse3());
                    C.setPromptText("Pick one below..");
                    C.setId("c" + i);
                    System.out.println(C.getId());
                    vbox3.getChildren().add(L);
                    vbox3.getChildren().add(C);
                   
                    type3++;
                    C.valueProperty().addListener(new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                    
                            if (newValue == x.getReponse1()) {
                                ScoreT3 += x.getScoreRep1();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT3 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT3 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT3 -= x.getScoreRep2();
                                }
                                System.out.println("S3:"+ScoreT3);
                            } else if (newValue == x.getReponse2()) {
                                ScoreT3 += x.getScoreRep2();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT3 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT3 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT3 -= x.getScoreRep2();
                                }
                                System.out.println("S3:"+ScoreT3);
                            } else if (newValue == x.getReponse3()) {
                                ScoreT3 += x.getScoreRep3();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT3 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT3 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT3 -= x.getScoreRep2();
                                }
                                System.out.println("S3:"+ScoreT3);
                               
                            }
                        
                               
                        }
                    });

                } else if ((x.getType().getTypeID() == 4) & (type4 <= 3)) {
                    Label L = new Label(x.getQuestion());
                    ComboBox C = new ComboBox();
                    
                    C.getItems().add(x.getReponse1());
                    C.getItems().add(x.getReponse2());
                    C.getItems().add(x.getReponse3());
                    C.setPromptText("Pick one below..");
                    C.setId("c" + i);
                    System.out.println(C.getId());
                    vbox4.getChildren().add(L);
                    vbox4.getChildren().add(C);
                    
                    type4++;
                    C.valueProperty().addListener(new ChangeListener() {
                        @Override
                        public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                            
                            if (newValue == x.getReponse1()) {
                                ScoreT4 += x.getScoreRep1();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT4 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT4 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT4 -= x.getScoreRep2();
                                }
                                System.out.println("S4:"+ScoreT4);
                            } else if (newValue == x.getReponse2()) {
                                ScoreT4 += x.getScoreRep2();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT4 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT4 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT4 -= x.getScoreRep2();
                                }
                                System.out.println("S4:"+ScoreT4);
                            } else if (newValue == x.getReponse3()) {
                                ScoreT4 += x.getScoreRep3();

                                if (oldValue == x.getReponse1()) {
                                    ScoreT4 -= x.getScoreRep1();
                                }
                                if (oldValue == x.getReponse3()) {
                                    ScoreT4 -= x.getScoreRep3();
                                }
                                if (oldValue == x.getReponse2()) {
                                    ScoreT4 -= x.getScoreRep2();
                                }
                                System.out.println("S4:"+ScoreT4);
                              
                            }
                          
           
                        }

                    });

                }
            }
            i++;
            

        }
    }
    
    
    
    @FXML
    private void GetResullts() throws IOException
    {
         boolean FullyDone = true;
         for(int j=1; j<i;j++)
            {
                ComboBox c = (ComboBox) anchor.lookup("#c"+j);
                String s = (String) c.getValue();
                System.out.println(s);
                if(s == null)
                {
                    FullyDone = false;
                    System.out.println(FullyDone);
                    
                   
                }
            }
         if(FullyDone == false)
         {
             Alert alert = new Alert(AlertType.INFORMATION);
             alert.setTitle("Formulaire non terminé");
             alert.setHeaderText(null);
             alert.setContentText("Please, you need to answer all your questions");

             alert.show();
         }
         else
         {
            FXMLLoader  Loader = new FXMLLoader(getClass().getResource("MatchingGUI.fxml"));
            AnchorPane A = Loader.load();
            
            //ChatGUIController CGI = Loader.getController();
            Stage S = new Stage();
            Stage CurrentStage = (Stage) vbox1.getScene().getWindow();
            JFXDecorator decorator = new JFXDecorator(S, A, false, false, true);
            decorator.setCustomMaximize(false);

            Scene scene = new Scene(decorator, 400, 600);
            scene.getStylesheets().add(MainFX.class.getResource("/Presentation/Styles.css").toExternalForm());
            S.setScene(scene);
            S.initStyle(StageStyle.UNDECORATED);
            S.show(); 
            CurrentStage.hide();
            int S1, S2, S3, S4;
            S1 = ScoreT1 * type1;
            S2 = ScoreT2 * type2;
            S3 = ScoreT3 * type3;
            S4 = ScoreT4 * type4;
             System.out.println(S1+"-"+S2+"-"+S3+"-"+S4);
            ClientService CS = new ClientService();
            CS.UpdateInterest(MatchingGUIController.CurrentUserID, S1, S2, S3, S4);
         }
                
                
                
            
    }

}
