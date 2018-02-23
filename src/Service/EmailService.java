/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author CorpseRoot
 */
public class EmailService {
    public static boolean SendMail(String Message, String To[]) throws MessagingException{
            
        String host = "smtp.gmail.com";
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", "mysoulmatepidev@gmail.com");
        props.put("mail.smtp.password", "legacy2018");
        props.put("mail.smtp.port", 587);
        props.put("mail.smtp.auth", "true");
        Session Ses = Session.getDefaultInstance(props,null);
        
        MimeMessage Mime = new MimeMessage(Ses);
        try {
            Mime.setFrom(new InternetAddress("mysoulmatepidev@gmail.com"));
            InternetAddress[] ToAddress = new InternetAddress[To.length];
            for(int i=0;i<To.length;i++)
            {
                ToAddress[i] = new InternetAddress(To[i]);
            }
            for(int i=0;i<ToAddress.length;i++)
            {
                Mime.setRecipient(RecipientType.TO, ToAddress[i]);
            }
            
            Mime.setSubject("My Soulmate Application");
            Mime.setText(Message);
            Transport Trans = Ses.getTransport("smtp");
            Trans.connect(host,"mysoulmatepidev@gmail.com", "legacy2018");
            Trans.sendMessage(Mime, Mime.getAllRecipients());
            Trans.close();
            return true;
        } catch (AddressException ex) {
            Logger.getLogger(EmailService.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
}
