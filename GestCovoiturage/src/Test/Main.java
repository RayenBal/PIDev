/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Entite.Covoiturage;
import Services.ServiceCovoiturage;
import Entite.Vehicule;
import Services.ServiceVehicule;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Rayen
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

         /*Covoiturage c1 = new Covoiturage(1,14650805 ,"Tunis ", "Sfax","26-02-2023",25,3);
         Covoiturage c2 = new Covoiturage(2,222222222 ,"Sfax ", "Monastir","27-02-2023",15,4);
         Covoiturage c3 = new Covoiturage(3,333333333 ,"Monastir ", "Bizerte","26-03-2023",25,3);
         Covoiturage c4 = new Covoiturage(4,444444444 ,"Bizerte ", "Mahdeya","01-03-2023",35,1);
         Covoiturage c5 = new Covoiturage(5,555555555 ,"Mahdeya ", "Jendouba","27-03-2023",35,2);
         Covoiturage c6 = new Covoiturage(6,666666666 ,"Jendouba", "Kairouan","26-03-2023",25,4);
         Covoiturage c7 = new Covoiturage(7,777777777 ,"Kairouan ", "Kerkennah","25-03-2023",35,3);
         Covoiturage c8 = new Covoiturage(8,888888888 ,"Kerkennah ", "Ariana","24-03-2023",40,3);*/
         Covoiturage c1 = new Covoiturage(9,999999999 ,"Kerkennah ", "Ariana","24-03-2023",40,3,"Clio");
        Vehicule v1 = new Vehicule("149Tunis4395","Renault","Clio","Compact",14650805,2);
        ServiceCovoiturage ser = new ServiceCovoiturage();
        ServiceVehicule serV = new ServiceVehicule();
      


         //Covoiturage c2 = new Covoiturage(7,1 ,"rades ", "gahzela","22-02-2021"  ,5,5);

        //AJOUT
        try {
            //ser.ajouter(c1);
            serV.ajouter(v1);
        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        /* //METTRE A JOUR
        try{
                    ser.update(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        
       /* //SUPPRESSION
       try{
                  ser.supprime(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}
       
        */
        List<Covoiturage> l1 = null;

        try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        l1.forEach(e -> {
            System.out.println(e);
        });
    }

}
