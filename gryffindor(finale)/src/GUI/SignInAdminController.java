/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

//import GUI.gestchauffeur.AfficherChauffeurController;
//import GUI.gestchauffeur.AfficherInfotraficController;
/*import GUI.gestchauffeur.SignInChauffeurController;
import GUI.gestcovoiturage.ListVehiculeController;
import GUI.gestcovoiturage.SelectcovControllerBack;
import GUI.gestpaiement.DisplayController;
import GUI.gestpassager.MenuuJavaController;
import GUI.gestpassager.menuJavaController;*/
//import GUI.gestreclamationreview.AfficherReviewController;
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
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class SignInAdminController implements Initializable {

    @FXML
    private Button passagers;
    @FXML
    private Button chauffeurs;
    @FXML
    private Button destinations;
    @FXML
    private Button covoiturages;
    @FXML
    private Button vehicules;
    @FXML
    private Button relamations;
    @FXML
    private Button paiement;
    @FXML
    private Button mpaiement;
    @FXML
    private Button reviews;
    @FXML
    private Button infotrafics;
    @FXML
    private Button users;
    @FXML
    private Button assurance;
    @FXML
    private Pane panecovoiturages;
    @FXML
    private Pane panepassagers;
    @FXML
    private Pane chauffeurspane;
    @FXML
    private Pane panedestinations;
    @FXML
    private Pane vehiculespane;
    @FXML
    private Pane reclamationspane;
    @FXML
    private Pane panepaiement;
    @FXML
    private Pane paiementpane;
    @FXML
    private Pane mpaiementpane;
    @FXML
    private Pane reviewpane;
    @FXML
    private Pane infotraficpane;
    @FXML
    private Pane userspane;
    @FXML
    private Pane paneassurance;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   /* @FXML
    private void passagers(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpassager/menuJava.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(menuJavaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void chauffeurs(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherChauffeur.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherChauffeurController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void destinations(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpassager/menuuJava.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(MenuuJavaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void covoiturages(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestcovoiturage/selectcov.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SelectcovControllerBack.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void vehicules(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestcovoiturage/ListVehicule.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ListVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void relamations(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AfficherReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void paiement(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestpaiement/Display.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(DisplayController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    @FXML
    private void reviews(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AfficherReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void infotrafics(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestchauffeur/AfficherInfotrafic.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherInfotraficController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/

    @FXML
    private void users(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/affichercompte.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AffichercompteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void assurance(ActionEvent event) {
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/AfficherAssurance.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AfficherAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
