/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.util.Date;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

/**
 *
 * @author sanabenfadhel
 */




public class Paiement {
    private int id;
    private String Description;
    private Date datepaiement;
    private double montant;
    private int paiementValide;
    private int M_id ; 
     private SimpleDoubleProperty montantProperty;
    

    public Paiement(int id , double montant , String Description , Date datePaiement , int paiementValide , int M_id ) {
        this.id= id;
        this.montant = montant;
        this.Description = Description;
        this.datepaiement = datePaiement;
        this.paiementValide= paiementValide;
        this.M_id= M_id;
        this.montantProperty = new SimpleDoubleProperty(montant);
        
    }
    
    public Paiement( double montant , String Description , Date datePaiement , int paiementValide , int M_id) {
        this.montant = montant;
        this.Description = Description;
        this.datepaiement = datePaiement;
        this.paiementValide= paiementValide;
        this.montantProperty = new SimpleDoubleProperty(montant);
    }

    public DoubleProperty montantProperty() {
        return montantProperty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getM_id() {
        return M_id;
    }

    public void setM_id(int id) {
        this.M_id = M_id;
    }

    public double getmontant() {
        return montant;
    }

    public void setmontant(double montant) {
        this.montant = montant;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getDate() {
        return datepaiement;
    }

    public void setDate(int age) {
        this.datepaiement = datepaiement;
    }
     public int getPvalide() {
        return paiementValide;
    }

    public void setPvalide(int paiementValide) {
        this.paiementValide = paiementValide;
    }

    
    @Override
    public String toString() {
        return "Paiement{" + "id=" + id + ", Date Paiement=" + datepaiement + ", Description=" + Description + ", montant=" + montant +", Paiement Valide=" +paiementValide+ '}';
    }
    
    
}
