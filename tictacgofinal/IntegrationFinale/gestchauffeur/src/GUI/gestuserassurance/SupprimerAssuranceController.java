/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;

import Entite.Assurance;
import Services.ServiceAssurance;
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
public class SupprimerAssuranceController implements Initializable {
     @FXML
    private TextField tfimma;
    @FXML
    private Button buttonSupp;
    @FXML
    private Label lbemail;
 

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void Supprmiercompte(ActionEvent event) {
 try {
     
    // Vérifier si l'utilisateur a entré un entier valide pour l'ID de compte
    if (tfimma.getText().matches("[0-9]{3}[A-Z]{2}[0-9]{4}+")) {
       String immatriculation = tfimma.getText();
         Assurance a = new Assurance("",immatriculation);
        // Supprimer le compte de la base de données
        ServiceAssurance sa= new ServiceAssurance();
        sa.supprime(a);
        JOptionPane.showMessageDialog(null, "assurance supprimer de la database.");
    } else {
        JOptionPane.showMessageDialog(null, "Invalid immatriculation . Please enter a valid immatriculation .");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }
  
    
}
