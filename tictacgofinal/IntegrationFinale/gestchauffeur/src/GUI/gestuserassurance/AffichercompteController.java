/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;

import Entite.Compte;
import Services.ServiceCompte;
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
 * @author Rayen
 */
public class AffichercompteController implements Initializable {

    @FXML
    private ListView<Compte> tablecompte;
    @FXML
    private Button Modifier;
    @FXML
    private Button Ajouter;
    @FXML
    private Button buttonafficher2;
    @FXML
    private Button Supprimer;
    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AfficherCompte(ActionEvent event) throws SQLException{
       ServiceCompte sc = new ServiceCompte();
        List<Compte> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Compte> Compte = FXCollections.observableArrayList(ctab);
      tablecompte.setItems(Compte);  
    }

    @FXML
    private void Modifier(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/Modifiercompte.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Ajouter(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/ajoutcompte_admin.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/supprimercompte.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SupprimerAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
