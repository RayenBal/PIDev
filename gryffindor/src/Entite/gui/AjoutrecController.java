package Entite.gui;

import Entite.Reclamation;
import Services.ServiceReclamation;
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

public class AjoutrecController implements Initializable {

    @FXML
    private Button btt;

    @FXML
    private Label lbidc;

    @FXML
    private Label lbdate;

    @FXML
    private Label lbdes;

    @FXML
    private Label lbnomr;

    @FXML
    private TextField tfidc;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tfdes;

    @FXML
    private TextField tfnomr;

    @FXML
    void save(ActionEvent event) throws SQLException {
        try {
            String description = tfdes.getText().trim();
            LocalDate date = datePicker.getValue();
            String nomr = tfnomr.getText().trim();
            int id_compte = Integer.parseInt(tfidc.getText().trim());

            // Vérification et conversion de la saisie pour l'identifiant du compte

            // Vérification de la validité de la description
            if (description.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La description ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Vérification de la validité de la date
            if (date == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La date ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Vérification de la validité de la nom
            if (nomr.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("Le nom ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Création de la réclamation
            Reclamation r = new Reclamation(description, date.toString(), nomr, id_compte);
            ServiceReclamation sr = new ServiceReclamation();
            sr.ajouter(r);

            // Nettoyage des champs de saisie
            tfdes.clear();
            datePicker.setValue(null);
            tfnomr.clear();
            tfidc.clear();
            System.out.println("Reclamation ajoutée dans la base de données.");
        } catch (SQLException e) {
            // Affichage d'une erreur inattendue (par exemple, erreur de connexion à la base de données)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite !");
            alert.showAndWait();
        }
    }

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
