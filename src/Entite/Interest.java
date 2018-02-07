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
public class Interest {
    
    private int ID;
    private int ID_User;
    private int PourcentagePhy;
    private int PourcentagePerso;
    private int PourcentageSoc;
    private int PourcentageVieC;

    public Interest() {
    }

    public Interest(int ID_User, int PourcentagePhy, int PourcentagePerso, int PourcentageSoc, int PourcentageVieC)
    {
        this.ID_User = ID_User;
        this.PourcentagePhy = PourcentagePhy;
        this.PourcentagePerso = PourcentagePerso;
        this.PourcentageSoc = PourcentageSoc;
        this.PourcentageVieC = PourcentageVieC;
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

    public int getPourcentagePhy() {
        return PourcentagePhy;
    }

    public void setPourcentagePhy(int PourcentagePhy) {
        this.PourcentagePhy = PourcentagePhy;
    }

    public int getPourcentagePerso() {
        return PourcentagePerso;
    }

    public void setPourcentagePerso(int PourcentagePerso) {
        this.PourcentagePerso = PourcentagePerso;
    }

    public int getPourcentageSoc() {
        return PourcentageSoc;
    }

    public void setPourcentageSoc(int PourcentageSoc) {
        this.PourcentageSoc = PourcentageSoc;
    }

    public int getPourcentageVieC() {
        return PourcentageVieC;
    }

    public void setPourcentageVieC(int PourcentageVieC) {
        this.PourcentageVieC = PourcentageVieC;
    }
    
    
    
    
    
}
