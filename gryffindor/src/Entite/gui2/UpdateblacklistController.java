/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Blacklist;
import Entite.Reclamation;
import Services.ServiceBlacklist;
import Services.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
public class UpdateblacklistController implements Initializable {

    @FXML
    private Label lbrec;
    @FXML
    private Label lbdes;
    @FXML
    private Label lbdate;
    @FXML
    private TextField tflist;
    @FXML
    private TextField tfnbrec;
    @FXML
    private Button btt;
    @FXML
    private Label lbpassager;
    @FXML
    private TextField tfpassager;
    @FXML
    private Label lbchauffeur;
    @FXML
    private TextField tfchauffeur;
    @FXML
    private TextField tfidb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void updateBlaclist(ActionEvent event) throws SQLException {
        if (tfidb.getText().isEmpty() || tflist.getText().isEmpty() || tfidb.getText().isEmpty() || tfpassager.getText().isEmpty() || tfchauffeur.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
    return;
}

// Vérification que les champs numériques contiennent des nombres valides
int idb, idp, idc,nb_rec;
try {
    idb = Integer.parseInt(tfidb.getText());
    nb_rec = Integer.parseInt(tfnbrec.getText());
    
    
    idp = Integer.parseInt(tfpassager.getText());
    idc = Integer.parseInt(tfchauffeur.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Veuillez saisir des  champs valides.");
    return;
}

// Création de l'objet Reclamation avec les valeurs saisies
Blacklist b = new Blacklist( tflist.getText(), nb_rec, idp, idc);

// Envoi de la réclamation au service de réclamation pour mise à jour
ServiceBlacklist sr = new ServiceBlacklist();
sr.update(b);

    }
    
    }
    

