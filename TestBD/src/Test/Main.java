/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Paiement;
import Entite.PaymentMethod;
import Services.ServicePaiement;
import Services.ServicePaymentMeth;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanabenfadhel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //Date date = new Date(2023 - 1900, 1, 1);
       
          java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        System.out.println("this is sqlDate : " + sqlDate);
        Paiement p1 = new Paiement(1,50,"cest une description" ,sqlDate, 1,1);
        Paiement p3 = new Paiement(7,50,"cest une description" ,sqlDate, 1,1);
        ServicePaiement ser = new ServicePaiement();
        
        

        
         Paiement p2 = new Paiement(2,3 , "cest une deuxieme description" ,sqlDate , 0,3);
         Paiement p4 = new Paiement(4,3 , "cest une deuxieme description" ,sqlDate , 0,4);
         Paiement pupdate = new Paiement(1,6 , "this is the changing one" ,sqlDate , 1,1);
         {/*
         try {
           ser.ajouterPST(p3);
       } catch (SQLException ex) {
            System.out.println(ex);
        }
         */}
        //try {
         //   ser.ajouterPST(p2);
       // } catch (SQLException ex) {
         //   System.out.println(ex);
       // }
       // try {
         //  ser.ajouterPST(p3);
        //} catch (SQLException ex) {
          //  System.out.println(ex);
        //}
        //try {
          // ser.ajouterPST(p4);
        //} catch (SQLException ex) {
          //  System.out.println(ex);
      //  }
      {/*
       try {
          ser.update(pupdate);
          } catch (SQLException ex) {
         System.out.println(ex);
        }   
        */}
      {/*
        try {
          ser.supprime(p1);
         } catch (SQLException ex) {
         System.out.println(ex);
         } 
         */}
      {/*
         { Paiement p21 = null;
        try {
            p21 = ser.findById(3);
           } catch (SQLException ex) {
           System.out.println(ex);
           }
           System.out.println(p21);
         } */}
      {/*
      {
        List<Paiement> l1 = null;

        try {
           l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        l1.forEach(e -> System.out.println(e));
         }
*/}
         //--------------------------------------------------------------------------------------------------------
         {/*
        ServicePaymentMeth ser2 = new ServicePaymentMeth();
        
        PaymentMethod PM1 = new PaymentMethod(1,3,1);
        PaymentMethod PM2 = new PaymentMethod(2,4,2);
        PaymentMethod PM3 = new PaymentMethod(2,0,3);
        */}
        {/*
        try {
            ser2.ajouter(PM2);
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        */}
       
        {/*
        try {
            ser2.update(PM3);
        } catch (SQLException ex) {
           System.out.println(ex);
        }
            */}
        
        {/*
        try {
            ser2.supprime(PM3);
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        */}
        {/*
        List<PaymentMethod> l2 = null;
         
        try {
           l2 = ser2.readAll();
          
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        l2.forEach(e -> System.out.println(e)); 
        */}
        {/*
           PaymentMethod p21 = null;
        try {
            p21 = ser2.findById(1);
           } catch (SQLException ex) {
           System.out.println(ex);
           }
           System.out.println(p21);
        */}
        
    }

}
