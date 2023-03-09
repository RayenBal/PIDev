/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Review;
import Services.ServiceReview;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class UpdateReviewController implements Initializable {
    @FXML
    private Label lbavis;
    @FXML
    private Label lbid;
      @FXML
    private TextField tfid;
    @FXML
    private Button btt;
    @FXML
    private TextField tfavis;

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
    public void updateReclamation(ActionEvent event) throws SQLException {
        String avis=tfavis.getText();
        int int_review= Integer.parseInt(tfid.getText());
                
        // Vérification que les champs obligatoires sont remplis
        if (tfavis.getText().isEmpty() || tfid.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
            return;
        }

        // Création de l'objet Reclamation avec les valeurs saisies
        Review r = new Review(int_review, avis);
        tfavis.clear();
        tfid.clear();

        // Envoi de la réclamation au service de réclamation pour mise à jour
        ServiceReview sr = new ServiceReview();
        sr.update(r);
    }
}
