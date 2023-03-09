/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Compte;
import Services.ServiceCompte;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class SupprimercompteController implements Initializable {
    @FXML
    private TextField tfemail;
    @FXML
    private Button buttonSupp;
    @FXML
    private Label lbemail;
    @FXML
    private Label label;
    @FXML
    private Button retour;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void Supprmiercompte(ActionEvent event) {
 try {
     
    // Vérifier si l'utilisateur a entré un entier valide pour l'ID de compte
    if (tfemail.getText().matches("[^@]+@[^@]+\\.[^@]+")) {
       String email = tfemail.getText();
         Compte c = new Compte("","",email,"");
        // Supprimer le compte de la base de données
        ServiceCompte sc= new ServiceCompte();
        sc.supprime(c);
        JOptionPane.showMessageDialog(null, "Compte supprimer de la database.");
    } else {
        JOptionPane.showMessageDialog(null, "Invalid email address. Please enter a valid email address.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimercompteController.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }

    @FXML
    private void retour(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/Testback.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

       /* try {
            int id_compte =Integer.parseInt(tfemail.getText());
            
            Compte c = new Compte(id_compte ,"","" ,"","",0);
            // Delete the Compte from the database
            ServiceCompte sc= new ServiceCompte();
            sc.supprime(c);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimercompteController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
