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
public class Publication {
    
    private int id_pub ;
    private String text;
    private String image;
    private String video;
    private int id_user ;

    public Publication(int id_pub, String text, String image, String video, int id_user) {
        this.id_pub = id_pub;
        this.text = text;
        this.image = image;
        this.video = video;
        this.id_user = id_user;
    }

    public Publication(String text, String image, String video) {
        this.text = text;
        this.image = image;
        this.video = video;
    }

    public Publication() {
    }

    public Publication(String text) {
        this.text = text;
    }

    
    
    

    public int getId_pub() {
        return id_pub;
    }

    public void setId_pub(int id_pub) {
        this.id_pub = id_pub;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    @Override
    public String toString() {
        return "Publication{" + "id_pub=" + id_pub + ", text=" + text + ", image=" + image + ", video=" + video + ", id_user=" + id_user + '}';
    }
    
    
    
    

    
}
