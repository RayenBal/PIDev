/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author Rayen
 */
public class Assurance {
    private int id_assurance ;
    private String date_validité,immatriculation;

    public Assurance(String date_validité,String immatriculation) {
        
        this.date_validité = date_validité;
        this.immatriculation = immatriculation;
    }

    public Assurance(int id_assurance,String date_validité, String immatriculation) {
        this.id_assurance = id_assurance;
        this.date_validité = date_validité;
        this.immatriculation = immatriculation;
    }

    public int getIda() {
        return id_assurance;
    }

    public void setIda(int id_assurance) {
        this.id_assurance = id_assurance;
    }
 
    public String getDate_validité() {
        return date_validité;
    }

    public void setDate_validité(String date_validité) {
        this.date_validité = date_validité;
    }
 

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }


    @Override
    public String toString() {
        return "Compte{" + "id_assurance= " + id_assurance +", date_validité= " + date_validité + ", immatriculation= " + immatriculation + '}';
    }
    
    
}
