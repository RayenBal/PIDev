/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author ADMIN
 */
public class Vehicule {
    private String immatriculation,modele,marque,type;
    private int idc ,nb_places;
    


public Vehicule(String immatriculation,String modele,String marque,String type,int idc,int nb_places) {
        this.immatriculation = immatriculation;
        this.modele = modele;
        this.marque=marque;
        this.type=type;
        this.idc=idc;
        this.nb_places=nb_places;
        
    }

    public Vehicule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

   
   

    public int getNb_places() {
        return nb_places;
    }

    public void setNb_places(int nb_places) {
        this.nb_places = nb_places;
    }

    @Override
    public String toString() {
        return "Vehicule{" + "immatriculation=" + immatriculation + ", modele=" + modele + ", marque=" + marque + ", type=" + type + ", idc=" + idc + ", nb_places=" + nb_places + '}';
    }







}
