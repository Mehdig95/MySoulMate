/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Commentaire;
import java.util.List;

/**
 *
 * @author CorpseRoot
 */
public interface ICommentaireService {
    
    
    public void AjouterCommentaire(Commentaire Q);
    public void ModifierCommentaire(Commentaire Q);
     public void SupprimerCommentaire(int id);
     public List<Commentaire> affichertouslescommentaires();
      public int AfficherByIDPub(int id);
}
