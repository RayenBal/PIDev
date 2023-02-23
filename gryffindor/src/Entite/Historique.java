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
public class Historique {
    private int id_historique;
    private String nom,prenom,historique;

    public Historique(String nom, String prenom,String historique) {
        this.nom = nom;
        this.prenom = prenom;
        this.historique = historique;
    }

    public Historique(int id_historique, String nom, String prenom, String historique) {
        this.id_historique = id_historique;
        this.nom = nom;
        this.prenom = prenom;
        this.historique = historique;
    }

    
    

    public int getId() {
        return id_historique;
    }

    public void setId(int id_historique) {
        this.id_historique = id_historique;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getHistorique() {
        return historique;
    }

    public void setHistorique(String historique) {
        this.historique = historique;
    }

    @Override
    public String toString() {
        return "Historique{" + "id_historique=" + id_historique + ", nom=" + nom + ", prenom=" + prenom + ", historique=" + historique + '}';
    }
}
