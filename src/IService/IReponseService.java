/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IService;

import Entite.Reponse;
import java.util.List;

/**
 *
 * @author CorpseRoot
 */
public interface IReponseService 
{
    public void AjouterReponse(Reponse R);
    public List<Reponse> SelectReponse(int ID);
    public void CalculerScore(int ID);
    
}
