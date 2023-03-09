/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Review;
import Entite.gui2.AjouterReviewController;
import Entite.gui2.SupprimerReviewController;
import Entite.gui2.UpdateReviewController;
import Services.ServiceReview;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherReviewController implements Initializable {

    @FXML
    private ListView<Review> idtable;
    @FXML
    private Button btsup;
    @FXML
    private Button Ajout;
    @FXML
    private Button supprimer;
    @FXML
    private Button modifier;
    @FXML
    private Label label;

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
    private void Afficherrec(ActionEvent event) throws SQLException {
        ServiceReview sc = new ServiceReview();
        List<Review> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Review> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
        
    }

    @FXML
    private void Ajout(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/AjouterReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void supprimer(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/SupprimerReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SupprimerReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestreclamationreview/UpdateReview.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(UpdateReviewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

   /* @FXML
    private void Afficherrec(ListView.EditEvent<T> event) {
    }*/

    
}
