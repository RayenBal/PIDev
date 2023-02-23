/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Reclamation;
import Entite.Blacklist;
import Services.ServiceBlacklist;


import Services.ServiceReclamation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 * @author achrafzribi
 */
public class Main {

     /**
     * @param args the command line arguments
     */

     
    public static void main(String[] args) {
        // TODO code application logic here

       // Chauffeur c1 = new Chauffeur(1,"Benn ", "ssss", "14253","5 rue elfell","aaaa@yahoo.com");

        ServiceReclamation ser = new ServiceReclamation();
        ServiceBlacklist serB = new ServiceBlacklist();



         Reclamation r2 = new Reclamation("rayennnnnnnnnnnnn", "25/02/2023",13,14);
         Blacklist b = new Blacklist ("hrghkjrhgkt",10,12,13);
                try {
            ser.ajouter(r2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

      /* try {
            ser.ajouter(r2);
        } catch (SQLException ex) {
            //System.out.println(ex);
        }*/
       /*try {
            serB.ajouter(b);
        } catch (SQLException ex) {
            //System.out.println(ex);
        }*/
       /* try{
                    ser.update(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
       /* try{
                    serB.update(b);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        
       /*try{
                  ser.afficher(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
      /* try{
                  serB.afficher(b);
        }catch (SQLException ex) {
            System.out.println(ex);}

        List<Reclamation> l1 = null;
        List<Blacklist> l2 = null;*/
       /*try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
      /* try {
                l2 = serB.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
        /* try{
                  ser.supprime(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
/*        l1.forEach(e -> {
            System.out.println(e);
        });*/
    }

}