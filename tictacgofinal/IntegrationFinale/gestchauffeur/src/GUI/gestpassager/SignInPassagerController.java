/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestpassager;

import GUI.gestchauffeur.AfficherInfotraficController;
import GUI.gestcovoiturage.ListcovController;
import GUI.gestreclamationreview.AfficherReviewController;
import GUI.gestreclamationreview.AllController;
import GUI.gestuserassurance.AjoutcompteController;
import gui.gestpaiement.FXMLController;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SignInPassagerController implements Initializable {
    @FXML
    private AnchorPane anchorcenter ;
    @FXML
    private VBox disap;

    @FXML
    private Button ajoutmodificationrec;
    @FXML
    private Button ajoutdestination;
    @FXML
    private Button affichercovoiturage;
    @FXML
    private Button ajoutpaiement;
    @FXML
    private Button affichageinfotraffic;
    @FXML
    private Label label;
    @FXML
    private Label label1;
    @FXML
    private Button Reviewall;
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
    private void ajoutmodificationrec(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/all.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AllController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajoutdestination(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("menuuJava.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MenuuJavaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affichercovoiturage(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestcovoiturage/listcov.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListcovController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void ajoutpaiement(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpaiement/FXML.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void affichageinfotraffic(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherInfotrafic.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherInfotraficController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Reviewall(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AfficherReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sign_out(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/SignIn.fxml"));
            Parent root = loader.load();
            disap.getChildren().clear();
            anchorcenter.getChildren().add(root);
    }
    
}
