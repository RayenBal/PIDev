/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Compte;
import Services.ServiceCompte;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class SupprimercompteController implements Initializable {
    @FXML
    private TextField tfcomp;
    @FXML
    private Button buttonSupp;

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
    if (tfcomp.getText().matches("\\d+")) {
       int id_compte =Integer.parseInt(tfcomp.getText());

         Compte c = new Compte(id_compte ,"","" ,"","",0);
        // Supprimer le compte de la base de données
        ServiceCompte sc= new ServiceCompte();
        sc.supprime(c);
        JOptionPane.showMessageDialog(null, "Compte supprimer de la database.");
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier et positif pour l'ID de Compte.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimercompteController.class.getName()).log(Level.SEVERE, null, ex);
}

        
    }
}

       /* try {
            int id_compte =Integer.parseInt(tfcomp.getText());
            
            Compte c = new Compte(id_compte ,"","" ,"","",0);
            // Delete the Compte from the database
            ServiceCompte sc= new ServiceCompte();
            sc.supprime(c);
        } catch (SQLException ex) {
            Logger.getLogger(SupprimercompteController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
