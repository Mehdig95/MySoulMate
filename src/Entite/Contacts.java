/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author CorpseRoot
 */
public class Contacts {
    
    private int ID;
    private int UserOneID;
    private int UserTwoID;
    private int ReqAccepted;

    public Contacts() {
    }

    public Contacts(int UserOneID, int UserTwoID, int ReqAccepted) {
        this.UserOneID = UserOneID;
        this.UserTwoID = UserTwoID;
        this.ReqAccepted = ReqAccepted;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUserOneID() {
        return UserOneID;
    }

    public void setUserOneID(int UserOneID) {
        this.UserOneID = UserOneID;
    }

    public int getUserTwoID() {
        return UserTwoID;
    }

    public void setUserTwoID(int UserTwoID) {
        this.UserTwoID = UserTwoID;
    }

    public int getReqAccepted() {
        return ReqAccepted;
    }

    public void setReqAccepted(int ReqAccepted) {
        this.ReqAccepted = ReqAccepted;
    }

    @Override
    public String toString() {
        return "Contacts{" + "ID=" + ID + ", UserOneID=" + UserOneID + ", UserTwoID=" + UserTwoID + ", ReqAccepted=" + ReqAccepted + '}';
    }

    
  
    
    
}
