/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

import java.sql.Date;

/**
 *
 * 
 */
public class Reclamation {
    private int id_reclamation,id_compte ;
    private String description,nomr;
    private String date_creation;
    
 
    
     public Reclamation(String description, String date_creation,String  nomr) {
        this.description = description;
        this.date_creation = date_creation;
        this.nomr = nomr;
    }

    public Reclamation(String description, String date_creation,String  nomr,int id_compte) {
        this.description = description;
        this.date_creation = date_creation;
        this.nomr = nomr;
        this.id_compte = id_compte;
    }

    public Reclamation(int id_reclamation , String description, String date_creation,String  nomr, int id_compte) {
        this.id_reclamation  = id_reclamation ;
        this.description = description;
       this.date_creation = date_creation;
        this.nomr = nomr;
        this.id_compte = id_compte;
    }

    public Reclamation(int idreclamation, String description, String date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {
        return id_reclamation ;
    }

    public void setId(int id_reclamation ) {
        this.id_reclamation  = id_reclamation ;
    }
    

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }
     public String getNomr() {
        return nomr;
    }

    public void setNomr(String nomr) {
        this.nomr = nomr;
    }
  
    public int getId_compte() {
        return id_compte ;
    }

    public void setId_compte(int id_compte ) {
        this.id_compte  = id_compte ;
    }

    @Override
    public String toString() {
        return  " description:   " + description + ", date_creation:   " + date_creation +", effectué sur:   " + nomr+"id_utilisateur:  " + id_compte  + '}';
    }

    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Object desProperty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
