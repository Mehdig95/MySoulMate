/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;
import IService.INotificationService;
import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CorpseRoot
 */
public class NotificationService implements INotificationService{

    @Override
    public void displayNotification(String Title, String Body) {
        
         
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("Notification System");
            tray.add(trayIcon);
            trayIcon.displayMessage(Title, Body, TrayIcon.MessageType.INFO);
        } catch (AWTException ex) {
            Logger.getLogger(NotificationService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
