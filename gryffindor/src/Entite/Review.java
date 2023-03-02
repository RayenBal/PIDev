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
public class Review {
     private int int_review;
    private String avis;
    
     public Review(String avis) {
        this.avis = avis;
    }

    public Review(int int_review, String avis) {
        this.int_review = int_review;
        this.avis = avis;
    }


    public int getIdr() {
        return int_review ;
    }

    public void setIdr(int int_review ) {
        this.int_review  = int_review ;
    }
    

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }
 

    @Override
    public String toString() {
        return "voici les avis que vous avez envoyé   "+  " avis=" + avis ;
    }

    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
