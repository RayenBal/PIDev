/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;

import GUI.gestpassager.menuJavaController;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class TestbackController implements Initializable {

    @FXML
    private AnchorPane anchorcenter;
    @FXML
    private BorderPane root;
    @FXML
    private Button passagers;
    @FXML
    private Button chauffeurs;
    @FXML
    private Button Destinations;
    @FXML
    private Button couvoiturage;
    @FXML
    private Button vehicule;
    @FXML
    private Button paiement;
    @FXML
    private Button reclamation;
    @FXML
    private Button info_traffic;
    @FXML
    private Button assurance;
    @FXML
    private Button compte;
    @FXML
    private VBox disap;
    @FXML
    private Button sign_out;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void dispayReclam(ActionEvent event) throws IOException {
                   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AfficherReview.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void dispayPassagers(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpassager/menuJava.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void dispayChauffeurs(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherChauffeur.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void displayDestinations(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpassager/menuuJava.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void displaycouvoiturage(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestcovoiturage/listcov.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void displayvehicule(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherChauffeur.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void displaypaiement(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpaiement/inter.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }


    @FXML
    private void displayreclamation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/all.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

    @FXML
    private void displayinfo_traffic(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherInfotrafic.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }

 
    @FXML
    private void displaycompte(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/affichercompte.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }
       @FXML
    private void displayassurance(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/AfficherAssurance.fxml"));
            Parent root = loader.load();
            anchorcenter.getChildren().clear();
            anchorcenter.getChildren().add(root);
            
    }

    @FXML
    private void sign_out(ActionEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/SignIn.fxml"));
            Parent root = loader.load();
            disap.getChildren().clear();
            anchorcenter.getChildren().add(root);
        
    }

   

}
