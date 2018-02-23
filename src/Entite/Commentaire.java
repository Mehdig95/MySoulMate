/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author USER
 */
public class Commentaire {
    
    private int id ;
    private String commentaire;
    private int idUser;
    private int idPub;

    public Commentaire(int id, String commentaire, int idUser, int idPub) {
        this.id = id;
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public Commentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Commentaire(String commentaire, int idUser, int idPub) {
        this.commentaire = commentaire;
        this.idUser = idUser;
        this.idPub = idPub;
    }

    public Commentaire(int aInt, String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Commentaire() {
     
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdPub() {
        return idPub;
    }

    public void setIdPub(int idPub) {
        this.idPub = idPub;
    }

    @Override
    public String toString() {
        return "Commentaire{" + "id=" + id + ", commentaire=" + commentaire + ", idUser=" + idUser + ", idPub=" + idPub + '}';
    }
    
    
    
}
