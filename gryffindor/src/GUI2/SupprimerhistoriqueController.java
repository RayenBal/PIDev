/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Historique;
import GUI.SupprimercompteController;
import Services.ServiceHistorique;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class SupprimerhistoriqueController implements Initializable {

    @FXML
    private TextField tfhistorique;
    @FXML
    private Button buttonSupp;
    @FXML
    private Label lbidhistorique;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void supprimerhistorique(ActionEvent event) {
        try {
    // Vérifier si l'utilisateur a entré un entier valide pour l'ID de historique
    if (tfhistorique.getText().matches("\\d+")) {
       int id_historique =Integer.parseInt(tfhistorique.getText());

         Historique h = new Historique(id_historique ,"","" ,"");
        // Supprimer la historique de la base de données
        ServiceHistorique sh= new ServiceHistorique();
        sh.supprime(h);
        JOptionPane.showMessageDialog(null, "Historique supprimer de la database.");
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier et positif pour l'ID de Historique.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimercompteController.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }
    
}
