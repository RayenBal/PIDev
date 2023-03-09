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
public class Compte {
    private int id_compte;
    private String nom,email,mot_de_passe,type_user;
    
     public Compte(String email,String mot_de_passe) {
        
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }

    public Compte(String type_user, String nom, String email,String mot_de_passe) {
        
        this.type_user = type_user;
        this.nom = nom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }

    public Compte(int id_compte,String type_user, String nom, String email, String mot_de_passe) {
        this.id_compte = id_compte;
        this.type_user = type_user;
        this.nom = nom;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
    }

    public int getIdc() {
        return id_compte;
    }

    public void setIdc(int id_compte) {
        this.id_compte = id_compte;
    }
 
    public String getNom() {
        return nom;
    }
    public String getType_user() {
        return type_user;
    }

    public void setType_user(String type_user) {
        this.type_user = type_user;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    @Override
    public String toString() {
        return " type_user   " + type_user + ", nom   " + nom + ", email   " + email + ", mot_de_passe   " + mot_de_passe ;
    }
    
    
}
