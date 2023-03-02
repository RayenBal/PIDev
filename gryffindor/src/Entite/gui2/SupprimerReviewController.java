/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Entite.Review;
import Services.ServiceReview;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SupprimerReviewController implements Initializable {
    @FXML
    private TextField tfid;
    @FXML
    private Label lbid;


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
    private void SupprmierReclamation(ActionEvent event) {
        try {
    // Vérifier si l'utilisateur a entré une chaine de caracrtere 
    
    if (tfid.getText().matches("\\d+")) {
        int int_review  = Integer.parseInt(tfid.getText());

        Review r = new Review(int_review,"");
        // Supprimer la réclamation de la base de données
        ServiceReview sr = new ServiceReview();
        sr.supprime(r);
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier pour l'ID de réclamation.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerReviewController.class.getName()).log(Level.SEVERE, null, ex);
}

        
        
        
    
    }

   
    
}
