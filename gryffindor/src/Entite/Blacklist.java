/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author ASUS
 */
public class Blacklist {
    private int id_blacklist,nb_reclamation,idp,idc ;
    private String list;

    public Blacklist(String list, int nb_reclamation, int idp, int idc) {
        this.list = list;
        this.nb_reclamation = nb_reclamation;
        this.idp = idp;
         this.idc = idc;
    }

    public Blacklist(int id_blacklist , String list, int nb_reclamation, int idp, int idc) {
        this.id_blacklist  = id_blacklist ;
        this.list = list;
        this.nb_reclamation = nb_reclamation;
        this.idp = idp;
         this.idc = idc;
    }


    public int getId() {
        return id_blacklist ;
    }

    public void setId(int id_blacklist ) {
        this.id_blacklist  = id_blacklist ;
    }

    public String getList() {
        return list;
    }

    public void setList(String list) {
        this.list = list;
    }

    public int getNb_reclamation() {
        return nb_reclamation;
    }

    public void setNb_reclamation(int nb_reclamation) {
       this.nb_reclamation = nb_reclamation;
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
        return "Blacklist{" + "id_blacklist =" + id_blacklist  + ", list=" + list + ", nb_reclamation=" + nb_reclamation +",id_passager =" + idp  +",id_chauffeur =" + idc  + '}';
    }
    
    
}
