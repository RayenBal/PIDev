/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite;

/**
 *
 * @author achrafzribi
 */
public class Chauffeur {
    private int idc,idd;
    private String nomc,prenomc,numc,adressec,emailc;

 

    public Chauffeur(String nomc, String prenomc,String numc ,String adressec ,String emailc,int idd) {
        this.nomc = nomc;
        this.prenomc = prenomc;
        this.numc=numc;
        this.adressec = adressec;
        this.emailc=emailc;
        this.idd=idd;
    }

    public Chauffeur(int idc, String nomc, String prenomc,String numc,String adressec, String emailc,int idd) {
        this.idc = idc;
        this.nomc = nomc;
        this.prenomc = prenomc;
        this.numc=numc ; 
        this.adressec= adressec;
        this.emailc = emailc ; 
        this.idd=idd ; 
    }

    public Chauffeur() {
      
    }

    public Chauffeur(int idc, String nomc, String prenomc, String numc, String adressec, String emailc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Chauffeur(String idc, String nomc, String prenomc, String numc, String adressec, String emailc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public String getPrenomc() {
        return prenomc;
    }

    public void setPrenomc(String prenomc) {
        this.prenomc = prenomc;
    }
    
    public String getNumc() {
        return numc;
    }

    public void setNumc(String numc) {
        this.numc = numc;
    }
public String getAdressec() {
        return adressec;
    }

    public void setAdressec(String adressec) {
        this.adressec = adressec;
    }
public String getEmailc() {
        return emailc;
    }

    public void setEmailc(String emailc) {
        this.emailc = emailc;
    }
    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    @Override
    public String toString() {
        return "chauffeur{" + "idc=" + idc + ", nomc=" + nomc + ", prenomc=" + prenomc + ", numc=" + numc + ",adressec="+adressec+",emailc="+emailc+",idd="+idd+'}';
    }

    public String getNom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getPrenom() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNum() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAdresse() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
