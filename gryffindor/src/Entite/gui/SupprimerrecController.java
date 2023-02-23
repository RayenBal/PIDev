/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Entite.Reclamation;
import Services.ServiceReclamation;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class SupprimerrecController implements Initializable {

    @FXML
    private TextField tfid;
    @FXML
    private Label lbid;
    @FXML
    private Button btsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprmierChauffeur(ActionEvent event) {
        try {
    // Vérifier si l'utilisateur a entré un entier valide pour l'ID de réclamation
    if (tfid.getText().matches("\\d+")) {
        int idrec = Integer.parseInt(tfid.getText());

        Reclamation c = new Reclamation(idrec, "", "", 0, 0);
        // Supprimer la réclamation de la base de données
        ServiceReclamation sr = new ServiceReclamation();
        sr.supprime(c);
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier pour l'ID de réclamation.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerrecController.class.getName()).log(Level.SEVERE, null, ex);
}

        
        
        
        
    
    }
        
        
        
       
        
    }


  

    
    
    

