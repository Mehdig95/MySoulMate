/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev;

import Entite.Client;
import Entite.Contacts;
import static Presentation.MatchingGUIController.CurrentUserID;
import Service.ClientService;
import Service.ContactsService;
import Service.EmailService;
import Service.ServiceSMS;
import java.util.ArrayList;
import java.util.List;
import javax.mail.MessagingException;

/**
 *
 * @author CorpseRoot
 */
public class Pidev {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MessagingException {
        /*ContactsService CS = new ContactsService();
        List<Contacts> L = CS.GetContacts(CurrentUserID);
        for(Contacts x: L)
        {
            System.out.println(x.toString());
        }
        System.out.println("-------------------------------");
       List<Contacts> L1 = CS.SentInvitations(CurrentUserID);
        for(Contacts x: L1)
        {
            System.out.println(x.toString());
        }
        System.out.println("-------------------------------");
        List<Contacts> L2 = CS.RecievedInvitations(CurrentUserID);
        for(Contacts x: L2)
        {
            System.out.println(x.toString());
        }*/
        
        ClientService S = new ClientService();
        Client C = S.SelectClient(2);
        System.out.println(C.toString());
        
    }
    
}
