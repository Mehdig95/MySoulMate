/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Interest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CorpseRoot
 */
public interface IInterestService {
    
    public void AjouterInterest(Interest I);
    public List<Interest> SelectInterest(Interest I);
    
}
