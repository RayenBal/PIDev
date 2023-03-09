/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestchauffeur;

import GUI.gestcovoiturage.SelectcovController;
import GUI.gestpaiement.DisplayController;
import GUI.gestpassager.menuJavaController;
import GUI.gestreclamationreview.AfficherReviewController;
import GUI.gestreclamationreview.AllController;
import GUI.gestuserassurance.AfficherAssuranceController;
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
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SignInChauffeurController implements Initializable {

    @FXML
    private Button Selectcov;
    @FXML
    private Button Reclaamtion;
    @FXML
    private Button Assurance;
    @FXML
    private Button Passager;
    @FXML
    private Button affichagepaiement;
    @FXML
    private Label label;
    @FXML
    private Button afficherReviewPassager;
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
    private void Selectcov(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestcovoiturage/selectcov.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void Reclaamtion(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/all.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AllController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Assurance(ActionEvent event) {
      try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/AfficherAssurance.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Passager(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpassager/menuJava.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(menuJavaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affichagepaiement(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpaiement/Display.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DisplayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void afficherReviewPassager(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AfficherReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sign_out(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/SignIn.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
