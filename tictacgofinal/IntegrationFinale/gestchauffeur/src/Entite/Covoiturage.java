/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;
import java.text.SimpleDateFormat;
import Entite.Vehicule;

/**
 *
 * @author Rayen
 */
public class Covoiturage {
    
   
    private int id_cov,idc,Prix,nbrplace ;
    private String depart,destination ;
    private String vehicule,date_covoiturage;
   //String date= new Date();
 //SimpleDateFormat formatter= new SimpleDateFormat("yyyy/mm/dd");
 //private String date_covoiturage= formatter.format(date);

    public Covoiturage(int id_cov, int idc, String depart, String destination , String date_covoiturage ,int Prix ,int nbrplace , String vehicule ) {
        this.id_cov = id_cov;
        this.idc = idc;
        this.depart=depart;
        this.destination = destination;
        this.Prix=Prix;
        this.nbrplace = nbrplace ; 
        this.date_covoiturage = date_covoiturage ; 
        this.vehicule=vehicule;
    }
    
     public Covoiturage( int idc , String depart, String destination , String date_covoiturage ,int Prix ,int nbrplace , String vehicule ) {
        this.idc = idc;
        this.depart=depart;
        this.destination = destination;
        this.Prix=Prix;
        this.nbrplace = nbrplace ; 
        this.date_covoiturage = date_covoiturage ; 
        this.vehicule=vehicule;
    }
    

    public Covoiturage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Covoiturage(int idc, int i, String string, String string0, String string1, int i0, int i1, int i2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_cov() {
        return id_cov;
    }

    public void setId_cov(int id_cov) {
        this.id_cov = id_cov;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public int getPrix() {
        return Prix;
    }

    public void setPrix(int Prix) {
        this.Prix = Prix;
    }

    public int getNbrplace() {
        return nbrplace;
    }

    public void setNbrplace(int nbrplace) {
        this.nbrplace = nbrplace;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDate_covoiturage() {
        return date_covoiturage;
    }

    public void setDate_covoiturage(String date_covoiturage) {
        this.date_covoiturage = date_covoiturage;
    }

    public String getVehicule() {
        return vehicule;
    }

    public void setVehicule(String vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public String toString() {
        return  "id_cov=" + id_cov + ", idc=" + idc + ", Prix=" + Prix + ", nbrplace=" + nbrplace + ", depart=" + depart + ", destination=" + destination + ", date_covoiturage=" + date_covoiturage + ", vehicule=" + vehicule + '}';
    }

   

 
    
    
}
