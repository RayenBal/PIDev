






package Entite.gui;

import Entite.Reclamation;
import Services.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;




import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AjoutrecController {

    @FXML
    private Button btt;

    @FXML
    private Label lbchauffeur;

    @FXML
    private Label lbdate;

    @FXML
    private Label lbdes;

    @FXML
    private Label lbpassager;

    @FXML
    private Label lbrec;

    @FXML
    private TextField tfchauffeur;

    @FXML
    private TextField tfdate;

    @FXML
    private TextField tfdes;

    @FXML
    private TextField tfpassager;

    @FXML
    void save(ActionEvent event) throws SQLException {
        try {
    String description = tfdes.getText().trim();
    String date = tfdate.getText().trim();
    int idc = 0;
    int idp = 0;

    // Vérification et conversion de la saisie pour l'identifiant du chauffeur
    try {
        idc = Integer.parseInt(tfchauffeur.getText().trim());
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("L'identifiant du chauffeur doit être un entier !");
        alert.showAndWait();
        return;
    }

    // Vérification et conversion de la saisie pour l'identifiant du passager
    try {
        idp = Integer.parseInt(tfpassager.getText().trim());
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("L'identifiant du passager doit être un entier !");
        alert.showAndWait();
        return;
    }

    // Vérification de la validité de la description
    if (description.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("La description ne peut pas être vide !");
        alert.showAndWait();
        return;
    }

    // Vérification de la validité de la date
    try {
        LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    } catch (DateTimeParseException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur de saisie");
        alert.setHeaderText(null);
        alert.setContentText("La date doit être au format dd/MM/yyyy !");
        alert.showAndWait();
        return;
    }

    // Création de la réclamation
    Reclamation r = new Reclamation(description, date, idp, idc);
    ServiceReclamation sr = new ServiceReclamation();
    sr.ajouter(r);

    // Nettoyage des champs de saisie
    tfdes.clear();
    tfdate.clear();
    tfpassager.clear();
    tfchauffeur.clear();
    System.out.println("reclamation ajouté dans la base de données.");
} catch (Exception e) {
    // Affichage d'une erreur inattendue (par exemple, erreur de connexion à la base de données)
    Alert alert = new Alert(AlertType.ERROR);
    alert.setTitle("Erreur");
    alert.setHeaderText(null);
    alert.setContentText("Une erreur s'est produite !");
    alert.showAndWait();
    e.printStackTrace();
}

    }
        
    /*    try {
            
          
          
            String description = tfdes.getText();
            String date = tfdate.getText();
int idc = Integer.parseInt(tfchauffeur.getText());  
int idp = Integer.parseInt(tfpassager.getText());
           
           Reclamation r = new Reclamation(description, date, idp, idc);
            ServiceReclamation sr = new ServiceReclamation();
            sr.ajouter(r);

            tfdes.clear();
            tfdate.clear();
            tfpassager.clear();
            tfchauffeur.clear();
           // tfuser.clear();
         System.out.println("Compte ajouter dans database.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    }*/
  public void initialize(URL url, ResourceBundle rb) {
        // TODO
}
    }




    
    
    
    
  
    








































