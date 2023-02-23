/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * 
 */
public class Reclamation {
    private int id_reclamation,idp,idc;
    private String description,date_creation;

    public Reclamation(String description, String date_creation, int idp, int idc) {
        this.description = description;
        this.date_creation = date_creation;
        this.idp = idp;
        this.idc = idc;
    }

    public Reclamation(int id_reclamation , String description, String date_creation, int idp, int idc) {
        this.id_reclamation  = id_reclamation ;
        this.description = description;
        this.date_creation = date_creation;
        this.idp = idp;
        this.idc = idc;
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
    public int getIdp() {
        return idp ;
    }

    public void setIdp(int idp ) {
        this.idp  = idp ;
    }
    public int getIdc() {
        return idc ;
    }

    public void setIdc(int idc ) {
        this.idc  = idc ;
    }

    @Override
    public String toString() {
        return "Compte{" + "id_reclamation =" + id_reclamation  + ", description=" + description + ", date_creation=" + date_creation +"id_passager =" + idp  +"id_chauffeur =" + idc  + '}';
    }

    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
