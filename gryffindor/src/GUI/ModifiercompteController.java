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
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
import static org.omg.CORBA.ObjectHelper.type;


public class ModifiercompteController implements Initializable {

   @FXML
    private TextField tfcomp;


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

    @FXML
    private RadioButton rbchauffeur;

    @FXML
    private RadioButton rbpassager;

    
    @FXML
    private RadioButton chauf;
    
     @FXML
    private RadioButton pass;
        @FXML
    private Button bttupdate;

     
    @FXML
    void update(ActionEvent event) {
         try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

    // get the updated data from the input fields
    int idc = -1;
    if (!tfcomp.getText().isEmpty()) {
        idc = Integer.parseInt(tfcomp.getText());
    }
    if (idc < 0) {
        JOptionPane.showMessageDialog(null, "Invalid input for idc. Please enter a positive integer.");
        return;
    }

    String type = pass.isSelected() ? "passager" : "chauffeur";

    String nom = tfnom.getText();
    if (nom.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Nom field cannot be empty. Please enter a name.");
        return;
    }

    String email = tfemail.getText();
    if (!email.matches("[^@]+@[^@]+\\.[^@]+")) {
        JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email address.");
        return;
    }

    String mp = tfmp.getText();
   // Vérifier que le mot de passe contient au moins 8 caractères et au moins une lettre et un chiffre
    if (!mp.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
        JOptionPane.showMessageDialog(null, "Le mot de passe doit contenir au moins 8 caractères, dont au moins une lettre et un chiffre.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    int idh = -1;
    if (!tfhist.getText().isEmpty()) {
        idh = Integer.parseInt(tfhist.getText());
    }
    if (idh < 0) {
        JOptionPane.showMessageDialog(null, "Invalid input for idh. Please enter a positive integer.");
        return;
    }

    // create a new Compte object with the updated data
    Compte c = new Compte(idc, type, nom, email, mp, idh);
    ServiceCompte sc = new ServiceCompte();
    sc.update(c);

    // clear the input fields
    tfcomp.clear();
    tfnom.clear();
    tfemail.clear();
    tfmp.clear();
    tfhist.clear();

    JOptionPane.showMessageDialog(null, "Compte updated in the database.");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
}

    }
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
/*try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // get the updated data from the input fields
        //int id = Integer.parseInt(txtid.getText());
        //int userId = Integer.parseInt(txtM.getText());
               
           String type = pass.isSelected() ? "passager" : "chauffeur";
            int idc = Integer.parseInt(tfcomp.getText());
            String nom = tfnom.getText();
            String email = tfemail.getText();
            String mp = tfmp.getText();
            //int hist = Integer.parseInt(tfhist.getText());
            int idh = Integer.parseInt(tfhist.getText());
       // java.util.Date utilDate = new java.util.Date();
       // java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
               
// create a new Paiement object with the updated data
        Compte c = new Compte(idc,type, nom, email, mp, idh);
            ServiceCompte sc = new ServiceCompte();
        sc.update(c);

        // clear the input fields
          tfnom.clear();
            tfemail.clear();
            tfmp.clear();
            tfhist.clear();
            // tfuser.clear();
        
        System.out.println("Compte updated in the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
    }*/
