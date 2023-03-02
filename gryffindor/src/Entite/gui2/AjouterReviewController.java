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
import javafx.fxml.Initializable;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterReviewController implements Initializable {
 @FXML
    private Button btt;

    @FXML
    private Label lbdes;

    @FXML
    private TextField tfdes;


    @FXML
    void save(ActionEvent event) throws SQLException {
        try {
            String avis = tfdes.getText().trim();
           

            // Vérification de la validité de la nom
            if (avis.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("L'avis ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Création de la réclamation
            Review r = new Review(avis);
            ServiceReview sr = new ServiceReview();
            sr.ajouter(r);

            // Nettoyage des champs de saisie
            tfdes.clear();
            System.out.println("Avis ajouté dans la base de données.");
        } catch (SQLException e) {
            // Affichage d'une erreur inattendue (par exemple, erreur de connexion à la base de données)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite !");
            alert.showAndWait();
        }
    }

 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
}
