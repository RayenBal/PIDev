/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Chauffeur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class AjouterChauffeurController implements Initializable {

    @FXML
    private TextField Cnomc;
    @FXML
    private TextField Cprenomc;
    @FXML
    private TextField Cnumc;
    @FXML
    private TextField Cadressec;
    @FXML
    private TextField Cemailc;
    @FXML
    private TextField Cdestinationc;
    @FXML
    private Button button1 ;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    //private void SaveChauffeur(ActionEvent event) {
       /* try {
            String nomc = Cnomc.getText();
            String prenomc = Cprenomc.getText();
            String numc= Cnumc.getText();
            String adressec = Cadressec.getText() ;
            String emailc=Cemailc.getText() ;
            int idd=Integer.parseInt(Cdestinationc.getText());
            
            Chauffeur c= new Chauffeur(nomc,prenomc,numc,adressec,emailc,idd);
            ServiceChauffeur sc = new ServiceChauffeur() ;
            sc.ajouter(c);
        } catch (SQLException ex) {
            Logger.getLogger(AjouterChauffeurController.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    private void SaveChauffeur(ActionEvent event) {
    String nomc = Cnomc.getText();
    String prenomc = Cprenomc.getText();
    String numc = Cnumc.getText();
    String adressec = Cadressec.getText();
    String emailc = Cemailc.getText();
    String destinationc = Cdestinationc.getText();

    // Validate input
    if (nomc.isEmpty() || prenomc.isEmpty() || numc.isEmpty() || adressec.isEmpty() || emailc.isEmpty() || destinationc.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required.");
        alert.showAndWait();
        return;
    }
    if (!destinationc.matches("\\d+")) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Destination ID must be a number.");
        alert.showAndWait();
        return;
    }
    if (!emailc.matches(".+@.+\\.com")) {
        Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email address.");
        alert.showAndWait();
        return;
    }

    int idd = Integer.parseInt(destinationc);
    Chauffeur c = new Chauffeur(nomc, prenomc, numc, adressec, emailc, idd);
    ServiceChauffeur sc = new ServiceChauffeur();
    try {
        sc.ajouter(c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Chauffeur added successfully.");
        alert.showAndWait();

        // Clear text fields
        Cnomc.clear();
        Cprenomc.clear();
        Cnumc.clear();
        Cadressec.clear();
        Cemailc.clear();
        Cdestinationc.clear();

    } catch (SQLException ex) {
        Logger.getLogger(AjouterChauffeurController.class.getName()).log(Level.SEVERE, null, ex);
        Alert alert = new Alert(Alert.AlertType.ERROR, "An error occurred while adding chauffeur.");
        alert.showAndWait();
    }
}

        
        
    }
    

