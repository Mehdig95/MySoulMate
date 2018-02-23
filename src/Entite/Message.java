/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * @author CorpseRoot
 */
public class Message {
    
    private int ID;
    private int SenderID;
    private int ReceiverID;
    private String Message;
    private Date SendTime;

    public Message(int SenderID, int ReceiverID, String Message, Date SendTime) {
        this.SenderID = SenderID;
        this.ReceiverID = ReceiverID;
        this.Message = Message;
        this.SendTime = SendTime;
    }

    public Message() {
    }
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSenderID() {
        return SenderID;
    }

    public void setSenderID(int SenderID) {
        this.SenderID = SenderID;
    }

    public int getReceiverID() {
        return ReceiverID;
    }

    public void setReceiverID(int ReceiverID) {
        this.ReceiverID = ReceiverID;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public Date getSendTime() {
        return SendTime;
    }

    public void setSendTime(Date SendTime) {
        this.SendTime = SendTime;
    }

    @Override
    public String toString() {
        return "Messages{" + "ID=" + ID + ", SenderID=" + SenderID + ", ReceiverID=" + ReceiverID + ", Message=" + Message + ", SendTime=" + SendTime + '}';
    }
    
    
    
}
