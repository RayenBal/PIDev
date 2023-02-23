/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Blacklist;
import Entite.Reclamation;
import Entite.gui.SupprimerrecController;
import Services.ServiceBlacklist;
import Services.ServiceReclamation;
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
 * @author ASUS
 */
public class SupprimerblacklistController implements Initializable {

    @FXML
    private TextField tfblack;
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
    private void Supprmierblack(ActionEvent event) throws SQLException {
 // Vérification que l'utilisateur a entré une valeur pour l'ID de blacklist
if (tfblack.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Veuillez entrer un ID de blacklist.");
    return;
}

// Vérification que l'utilisateur a entré un entier valide pour l'ID de blacklist
int idrec;
try {
    idrec = Integer.parseInt(tfblack.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier pour l'ID de blacklist.");
    return;
}

Blacklist b = new Blacklist(idrec, "", 10, 0, 0);
// Supprimer la blacklist de la base de données
ServiceBlacklist sb = new ServiceBlacklist();
sb.supprime(b);
;

    
}
}
