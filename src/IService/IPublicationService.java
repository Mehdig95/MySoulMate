/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Publication;
import java.util.List;


/**
 *
 * @author USER
 */
public interface IPublicationService {
      public void ajouterPublication(Publication e );
    public void modifierPublication(Publication e );
    public void supprimerPublication(Publication e  );
      
        public List<Publication> afficher(int id);
    
}
