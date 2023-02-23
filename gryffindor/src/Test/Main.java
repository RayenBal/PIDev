/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Compte;
import Entite.Historique;
import Services.ServiceCompte;
import Services.ServiceHistorique;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * @author Rayen
 */
public class Main {

     /**
     * @param args the command line arguments
     */

     
    public static void main(String[] args) {
        // TODO code application logic here

       // Chauffeur c1 = new Chauffeur(1,"Benn ", "ssss", "14253","5 rue elfell","aaaa@yahoo.com");

        ServiceCompte ser = new ServiceCompte();
        ServiceHistorique serH = new ServiceHistorique();
       /* try {
            ser.ajouter(c1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/

         Historique h2 = new Historique(21, "manourtiiiiiiiiiii", "Dhraief", "aaaaaaaaaaaaaaaaa");
         Compte c2 = new Compte(16,"chauf", "Rayen", "mohamedrayen.dhraief@esprit.tn", "rayen12",21);
          try {
            serH.ajouter(h2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
         
       /* try {
            ser.ajouter(c2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
        /*try {
            serH.ajouter(h2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
        /*try{
                    ser.update(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
         /*try{
                    serH.update(h2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        
      try{
                  ser.afficher(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}
        try{
                  serH.afficher(h2);
        }catch (SQLException ex) {
            System.out.println(ex);}

       List<Compte> l1 = null;
        List<Historique> l2= null;

        try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        try {
            l2 = serH.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        /* try{
                  ser.supprime(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
         /*try{
                  serH.supprime(h2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        /*l1.forEach(e -> {
            //System.out.println(e);
        });*/
    }

}