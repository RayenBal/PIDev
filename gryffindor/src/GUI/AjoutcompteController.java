/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*

package GUI;
import Entite.Compte;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
//import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import Services.ServiceCompte;
import GUI.AjoutcompteController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
/*
public class AjoutcompteController implements Initializable {
   
    @FXML
    private Button bttsign;

    @FXML
    private Label lbemail;

    @FXML
    private Label lbmp;

    @FXML
    private Label lbnom;

    @FXML
    private Label lbsign;

    @FXML
    private Label lbtype;

    private RadioButton rbchauffeur;

    private RadioButton rbpassager;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfhist;

    @FXML
    private TextField tfmp;

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfuser;
    

    /**
     * Initializes the controller class.
     */
   /* @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
     @FXML
    private void Save(ActionEvent event) {
        try {
            String passager = rbpassager.getText();
            String chauffeur = rbchauffeur.getText();
           
            String nom = tfnom.getText();
            String email= tfemail.getText();
            String mp = tfmp.getText() ;
            //String hist =tfhist.getText() ;
            int hist=Integer.parseInt(tfhist.getText());
            
            Compte c= new Compte(passager,nom,email,mp,hist);
            ServiceCompte sc = new ServiceCompte() ;
            sc.ajouter(c);
            
             tfnom.clear();
            tfemail.clear();
            tfmp.clear();
            tfhist.clear();
            tfuser.clear();
            
            
            
            
        } catch (SQLException e) {
           System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
        }
        
        
    }
    */
    

package GUI;

import Entite.Compte;
import Services.ServiceCompte;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import com.mysql.cj.jdbc.Driver;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;


public class AjoutcompteController implements Initializable {


    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfhist;

    @FXML
    private TextField tfmp;

    @FXML
    private TextField tfnom;

    @FXML
    private RadioButton pass;

    @FXML
    private Label lbsign;

    @FXML
    private Label lbnom;

    
      @FXML
    private Label lbmp;
    @FXML
    private Label lbemail;
    @FXML
    private Label lbtype;
    @FXML
    private Button bttsign;
    @FXML
    private RadioButton chauf;
    @FXML
    private TextField idcontrole;
     
    @FXML
    private void Save(ActionEvent event) {
        try {
    String type = pass.isSelected() ? "passager" : "chauffeur";
    String nom = tfnom.getText();
    String email = tfemail.getText();
    String mp = tfmp.getText();
    String idText = tfhist.getText();

    // Vérifier que l'identifiant est un nombre entier positif
    if (!idText.matches("\\d+")) {
        throw new NumberFormatException();
    }
    int id = Integer.parseInt(idText);

    // Vérifier que le nom ne contient que des lettres et des espaces
    if (!nom.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "Le nom ne doit contenir que des lettres et des espaces.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier que l'email est valide
    if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
        JOptionPane.showMessageDialog(null, "L'email n'est pas valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier que le mot de passe contient au moins 8 caractères et au moins une lettre et un chiffre
    if (!mp.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
        JOptionPane.showMessageDialog(null, "Le mot de passe doit contenir au moins 8 caractères, dont au moins une lettre et un chiffre.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Compte c = new Compte(type, nom, email, mp, id);
    ServiceCompte sc = new ServiceCompte();
    sc.ajouter(c);

    tfnom.clear();
    tfemail.clear();
    tfmp.clear();
    tfhist.clear();
    JOptionPane.showMessageDialog(null, "Compte ajouté dans la base de données.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "L'identifiant doit être un nombre entier positif.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
} 


    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
 /*try {
            
            String type = pass.isSelected() ? "passager" : "chauffeur";
          
            String nom = tfnom.getText();
            String email = tfemail.getText();
            String mp = tfmp.getText();
            
            //int hist = Integer.parseInt(tfhist.getText());
            int id = Integer.parseInt(tfhist.getText());
         
           // Compte c = new Compte(99 ,"hello", nom, email, mp, e);
           Compte c = new Compte(type, nom, email, mp, id);
            ServiceCompte sc = new ServiceCompte();
            sc.ajouter(c);

            tfnom.clear();
            tfemail.clear();
            tfmp.clear();
            tfhist.clear();
           // tfuser.clear();
         System.out.println("Compte ajouter dans database.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }*/
