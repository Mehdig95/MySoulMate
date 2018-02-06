/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enum;

/**
 *
 * @author CorpseRoot
 */
public enum TypeQuestion {
    
    QuestVieCouple("VieCouple",1), QuestPsycho("Psycho",2), QuestFamille("Famille",3) , QuestForme("Forme Et Sport",4);
    
    private String NomDeType;
    private int TypeID;

    public String getNomDeType() {
        return NomDeType;
    }

    public void setNomDeType(String NomDeType) {
        this.NomDeType = NomDeType;
    }

    public int getTypeID() {
        return TypeID;
    }

    public void setTypeID(int TypeID) {
        this.TypeID = TypeID;
    }
    
    

    private TypeQuestion(String NomDeType, int TypeID)
    {
        this.NomDeType = NomDeType;
        this.TypeID = TypeID;
    }
    
    
    
}
