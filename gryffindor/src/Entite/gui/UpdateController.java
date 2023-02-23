/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import Entite.Reclamation;
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
public class UpdateController implements Initializable {

    @FXML
    private Label lbrec;
    @FXML
    private Label lbdes;
    @FXML
    private Label lbdate;
    @FXML
    private TextField tfdes;
    @FXML
    private TextField tfdate;
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
    private TextField idcase;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    public void updateReclamation(ActionEvent event) throws SQLException {
        // Vérification que les champs obligatoires sont remplis
if (idcase.getText().isEmpty() || tfdes.getText().isEmpty() || tfdate.getText().isEmpty() || tfpassager.getText().isEmpty() || tfchauffeur.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
    return;
}

// Vérification que les champs numériques contiennent des nombres valides
int id_reclamation, idp, idc;
try {
    id_reclamation = Integer.parseInt(idcase.getText());
    idp = Integer.parseInt(tfpassager.getText());
    idc = Integer.parseInt(tfchauffeur.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Veuillez saisir des nombres valides pour les champs numériques.");
    return;
}

// Création de l'objet Reclamation avec les valeurs saisies
Reclamation r = new Reclamation(id_reclamation, tfdes.getText(), tfdate.getText(), idp, idc);

// Envoi de la réclamation au service de réclamation pour mise à jour
ServiceReclamation sr = new ServiceReclamation();
sr.update(r);

    }
    
}

/*
int id_reclamation=Integer.parseInt(idcase.getText());    
            String description = tfdes.getText();
            String date= tfdate.getText();
            
          
          int idp=Integer.parseInt(tfpassager.getText());
            int idc=Integer.parseInt(tfchauffeur.getText());
            
            
            
            
            
            Reclamation r = new Reclamation(id_reclamation,description,date,idp,idc);
            ServiceReclamation sr = new ServiceReclamation() ;
            sr.update(r);
*/

