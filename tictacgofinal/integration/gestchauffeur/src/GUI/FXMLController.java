/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Chauffeur;
import Services.ServiceChauffeur;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class FXMLController implements Initializable {

    @FXML
    private TextField SupprimeID;
    @FXML
    private Button button69;
    @FXML
    private ImageView modif;
    @FXML
    private ImageView supp;
    @FXML
    private ImageView aff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   /* private void SupprmierChauffeur(ActionEvent event) {
        
      
        try {
            int idc=Integer.parseInt(SupprimeID.getText());
            
            Chauffeur c = new Chauffeur(idc,"","" ,"","","",0);
            // Delete the payment from the database
            ServiceChauffeur sc= new ServiceChauffeur();
            sc.supprime(c);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    */
    
    private void SupprmierChauffeur(ActionEvent event) {

    // Ensure that the ID field is not empty
    if (SupprimeID.getText().isEmpty()) {
        // Show an error message to the user
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid number for the ID");
        alert.showAndWait();

        return; // Exit the method
    }

    String idcStr = SupprimeID.getText();

    // Ensure that idcStr is a number
    if (!idcStr.matches("\\d+")) {
        // Show an error message to the user
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("Please enter a valid number for the ID");
        alert.showAndWait();

        // Clear the ID field
        SupprimeID.clear();

        return; // Exit the method
    }

    int idc = Integer.parseInt(idcStr);

    try {
        Chauffeur c = new Chauffeur(idc,"","" ,"","","",0);
        // Delete the payment from the database
        ServiceChauffeur sc = new ServiceChauffeur();
        sc.supprime(c);

        // Show a confirmation message to the user
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Chauffeur Supprim??");
        alert.setHeaderText(null);
        alert.setContentText("Le chauffeur a ??t?? supprim?? de la base de donn??es.");
        alert.showAndWait();

        // Clear the ID field
        SupprimeID.clear();

    } catch (SQLException ex) {
        Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    @FXML
    private void modif(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("updateChauffeur.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) modif.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void supp(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SupprimerChauffeur.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) supp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void aff(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AfficherChauffeur.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) aff.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

}
