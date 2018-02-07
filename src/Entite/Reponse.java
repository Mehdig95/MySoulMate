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
public class Reponse {
    
    private int ID;
    private int ID_User;
    private int ID_Question;
    private Date DateReponse;
    private String Reponse;
    private int Score;

    public Reponse() {
        
    }
    
    

    public Reponse(int ID_User, int ID_Question, Date DateReponse, String Reponse, int Score)
    {
        this.ID_User = ID_User;
        this.ID_Question = ID_Question;
        this.DateReponse = DateReponse;
        this.Reponse = Reponse;
        this.Score = Score;
    }

    public int getScore()  {
        return Score;
    }
    
    public void setScore(int Score) {
        this.Score = Score;
    }
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID_User() {
        return ID_User;
    }

    public void setID_User(int ID_User) {
        this.ID_User = ID_User;
    }

    public int getID_Question() {
        return ID_Question;
    }

    public void setID_Question(int ID_Question) {
        this.ID_Question = ID_Question;
    }

    public Date getDateReponse() {
        return DateReponse;
    }

    public void setDateReponse(Date DateReponse) {
        this.DateReponse = DateReponse;
    }

    public String getReponse() {
        return Reponse;
    }

    public void setReponse(String Reponse) {
        this.Reponse = Reponse;
    }
    
    
    
    
    
}
