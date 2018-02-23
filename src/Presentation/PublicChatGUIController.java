/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Entite.Client;
import Service.ClientService;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;

/**
 * FXML Controller class
 *
 * @author CorpseRoot
 */
public class PublicChatGUIController implements Initializable {

    @FXML
    private JFXTextField textfield;
    @FXML
    private JFXTextArea textarea;

    static int Port = 4293;
    InetAddress IP;
    DatagramSocket Socket;
    Thread Send, Listen, Run;
    boolean running = false, clientStatus, messageReceived = false;
    String disconnectedUser;
     Client C = new Client();
     ClientService CS = new ClientService();
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        C = CS.SelectClient(MatchingGUIController.CurrentUserID);
        boolean checkConnect = openConnection("localhost", Port);
        if (checkConnect) {
            String message = "/c/" + C.getNom() + "/e/";
            send(message.getBytes());
        }
        System.out.println(checkConnect);
        running = true;
        Run = new Thread("Running");
        Run.start();
        listen();
        textfield.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                System.out.println(textfield.getText());
                send(textfield.getText(), 0);
                //typeAttempt = true;
            } else {
                send(" : is Typing", 1);
            }
        });
        
        //---------------
        System.out.println("///////////");
        System.out.println(Listen.isAlive());
        System.out.println(Run.isAlive());
        System.out.println("///////////");
      
    }  
    
    private void console(String message) {
        textarea.appendText(message + " \n");
    }
     
    private boolean openConnection(String address, int port) {
        try {
            IP = InetAddress.getByName(address);
            Socket = new DatagramSocket();
            console(C.getNom() + " Attempting to create a socket Connection ");
        } catch (UnknownHostException | SocketException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    private void send(String message, int text) 
    {
        switch (text) {
            case 0:
                if (message.isEmpty()) {
                    System.out.println("Message is empty");
                    return;
                }
                if (message.startsWith("/time/")) {
                    send(message.getBytes());
                } else if (message.startsWith("/ip/")) {
                    send(message.getBytes());
                } else if (message.startsWith("/number/")) {
                    send(message.getBytes());
                }
                message = "/m/"+ C.getNom() +": " + message + "/e/";
                send(message.getBytes());
                textfield.clear();
                break;

            case 1:
                message = "/t/"+ C.getNom() +" IS TYPING ";
                send(message.getBytes());
                break;
            case 2://disconnected 
                send(message.getBytes());
                break;
            default:
                break;
        }

    }
    
    private void send(final byte[] data)
    {
        Send = new Thread("Send Thread")
        {
            public void run()
            {
                DatagramPacket packet = new DatagramPacket(data, data.length, IP, Port);
                try {
                    Socket.send(packet);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        };
        Send.start();
    }
    
    private String receive() 
    {
        byte[] data = new byte[1024];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        try {
            Socket.receive(packet);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String string = new String(packet.getData());
        System.out.println(string);
        return string;
    }
    
     public  void  listen() { // for checking to client and server
         Listen = new Thread("Listen Thread") {
             int attempt;

             @Override
             public void run() {
                 System.out.println(running);
                 while (running) {
                     String message = receive();
                     System.out.println("men west:"+message);
                     if (message.startsWith("/c/")) {
                         console(C.getNom() + " has successfully connected to Server!");
                         System.out.println(C.getNom() + " has successfully connected to Server!");
                     } else if (message.startsWith("/d/")) {
                         String disconnectUser = message.split("/d/|/i/")[1];
                         String disconnectID = message.split("/i/|/e/")[1];                       
                         System.out.println("Disconnected User : " + disconnectUser);
                         disconnectedUser = disconnectUser;
                         console(disconnectUser + " left the Chat");
                         clientStatus = true;
                         System.out.println("sent cleint status " + clientStatus);
                     } else if (message.startsWith("/m/")) {
                         String text = message.substring(3);
                         text = text.split("/e/")[0];
                         console(text);
                         messageReceived = true;
                     } else if (message.startsWith("/time/")) {
                         String receivedTime = message.substring(6);
                         receivedTime = receivedTime.split("/e/")[0];
                         // System.out.println(receivedTime.length());
                         long serverTime = Long.parseLong(receivedTime);
                         long currentTime = System.currentTimeMillis();
                         long totalTime = currentTime - serverTime;
                         double sec = totalTime / 1000;

                         console(sec + " sec");
                         System.out.println(sec + " seconds");
                     } else if (message.startsWith("/ip/")) {
                         String receivedIp = message.substring(4);
                         receivedIp = receivedIp.split("/e/")[0];
                         System.out.println("server ip : " + receivedIp);
                         console("server ip : " + receivedIp);
                     } else if (message.startsWith("/number/")) {
                         String number = message.substring(8);
                         number = number.split("/e/")[0];
                         System.out.println("Number of clients located : " + number);
                     }/* else if (message.startsWith("/s/")) {
                         //seenAttempt=!seenAttempt;
                         if (seenAttempt) {
                             String seenStatus = message.split("/s/|/e/")[1];
                             console(seenStatus);
                             seenAttempt = false;
                         }
                     }
                     if (message.startsWith("/t/")) {
                         if (typeAttempt) {
                             String textStatus = message.split("/t/")[1];
                             System.out.println(textStatus);
                             console(textStatus);
                             typeAttempt = false;
                         }

                     }*/
                 }
             }
         };
         Listen.start();
    }
    
    // @Override
    public void run() {
        listen();
    }
    
}
