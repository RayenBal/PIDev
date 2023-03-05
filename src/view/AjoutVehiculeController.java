/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entite.Vehicule;
import Services.ServiceCovoiturage;
import Services.ServiceVehicule;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author ADMIN
 */
public class AjoutVehiculeController implements Initializable {

    @FXML
    private TextField veh_immatriculation;
    @FXML
    private TextField veh_modele;
    @FXML
    private TextField veh_marque;
    @FXML
    private TextField veh_type;
    @FXML
    private TextField veh_idc;
    @FXML
    private TextField veh_nbplace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    
    @FXML
private void savevehicule(ActionEvent event) throws SQLException {
    String immatriculation = veh_immatriculation.getText();
    String modele = veh_modele.getText();
    String marque = veh_marque.getText();
    String type = veh_type.getText();

    int nb_places = 0;
    int idc = 0;

    if (!veh_nbplace.getText().isEmpty()) {
        nb_places = Integer.parseInt(veh_nbplace.getText());
    }
    if (!veh_idc.getText().isEmpty()) {
        idc = Integer.parseInt(veh_idc.getText());
    }

    if (immatriculation.isEmpty() || modele.isEmpty() || marque.isEmpty() || type.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Veuillez remplir tous les champs obligatoires");
        alert.showAndWait();
    } else if (nb_places <= 0 || idc <= 0) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("");
        alert.setContentText("Le nombre de places et l'ID conducteur doivent être supérieurs à zéro");
        alert.showAndWait();
    } else {
        Vehicule v = new Vehicule(immatriculation, modele, marque, type, idc, nb_places);

        ServiceVehicule sc = new ServiceVehicule();
        try {
            if (sc.ajouter(v)) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("");
                alert.setContentText("Vehicule ajouté avec succés ! ");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("Alerte");
                alert.setContentText("Impossible d'ajouter ce Vehicule");
                alert.showAndWait();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceVehicule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
