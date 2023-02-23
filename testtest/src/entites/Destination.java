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
public class Destination {
    private int idd;
    private String gouvernorat, adressed;
   

 
    
    public Destination(String gouvernorat, String adressed) {
        this.gouvernorat = gouvernorat;
        this.adressed = adressed;

    }

    public Destination(int idd, String gouvernorat, String adressed) {
        this.idd = idd;
        this.gouvernorat = gouvernorat;
        this.adressed = adressed;
    }

 

    public int getIdd() {
        return idd;
    }

    public void setIdd(int idd) {
        this.idd = idd;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    public String getAdressed() {
        return adressed;
    }

    public void setAdressed(String adressed) {
        this.adressed = adressed;
    }
   

    @Override
    public String toString() {
        return "destination{" + "idd=" + idd + ", gouvernorat=" + gouvernorat + ", adressed=" + adressed + '}';
    }

    public void setidd(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
