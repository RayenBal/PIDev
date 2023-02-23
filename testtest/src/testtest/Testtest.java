/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Testtest;
import entites.Destination;
import service.ServiceDestination;
import entites.Passager;
import service.PassagerService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author sarra
 */
public class Testtest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

       // Passager c1 = new Passager(4,"mmmmm ", "chkoun", "14253","mouleha","aaaa@yahoo.com");

        PassagerService ser = new PassagerService();
        ServiceDestination serr = new ServiceDestination();

   Destination d2 = new Destination(2001,"bbbbb ", "rayen");

        
        try {
            serr.ajouter(d2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
    /*    try{
                    serr.update(d2);
        }catch (SQLException ex) {
            System.out.println(ex);}
        
        try{
                  serr.supprime(d2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
 
       /* try {
            ser.update(c1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
*/

         Passager c2 = new Passager("mmmsjsjd ","abdslem","14555","5 rue eljarana","kaaa@yahoo.com");

        
        try {
            ser.ajouter(c2);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    /*
      try{
                    ser.update(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}
        
      try{
                  ser.supprime(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}
       
        */
        List<Passager> l1 = null;

        try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        l1.forEach(e -> {
            System.out.println(e);       
        });
        List<Destination> l2 = null;

        try {
            l2 = serr.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        l1.forEach(e -> {
            System.out.println(e);       
        });

     }

}
