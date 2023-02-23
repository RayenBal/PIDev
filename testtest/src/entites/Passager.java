/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author medzr
 */
public class Passager {
  private String nomp,prenomp,nump,adressep,emailp;
   
 

    public Passager(String nomp, String prenomp,String nump ,String adressep ,String emailp) {
        this.nomp = nomp;
        this.prenomp = prenomp;
        this.nump=nump;
        this.adressep = adressep;
        this.emailp=emailp;
    
    }

    public Passager() {
    }


    public String getNomp() {
        return nomp;
    }

    public void setNomp(String nomp) {
        this.nomp = nomp;
    }

    public String getPrenomp() {
        return prenomp;
    }

    public void setPrenomp(String prenomp) {
        this.prenomp = prenomp;
    }
    
    public String getNump() {
        return nump;
    }

    public void setNump(String nump) {
        this.nump = nump;
    }
public String getAdressep() {
        return adressep;
    }

    public void setAdressep(String adressep) {
        this.adressep = adressep;
    }
public String getEmailp() {
        return emailp;
    }

    public void setEmailp(String emailp) {
        this.emailp = emailp;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "passager{ nom=" + nomp + ", prenom=" + prenomp + ", num=" + nump + ",adresse="+adressep+",email="+emailp+'}';
    }
       
}
