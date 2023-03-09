/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import Entite.Covoiturage;
import Services.ServiceCovoiturage;
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
 * @author Rayen
 */
public class ListcovController implements Initializable {

    @FXML
private Button btnajouter;
    /*private TextField tfdepart;
    private TextField tfdestination;
    private TextField tfprix;
    private TextField tfnbr;
        private TextField tfdate ;
        private TextField tfid ;*/
    @FXML
    private TextField cov_vehicule;
    @FXML
    private TextField cov_depart;
    @FXML
    private TextField cov_destination;
    @FXML
    private TextField cov_prix;
    @FXML
    private TextField cov_nbr;
    @FXML
    private TextField cov_date;
    @FXML
    private TextField cov_idc;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void savecovoiturage(ActionEvent event) throws SQLException {
        String depart = cov_depart.getText() ; 
        String destination = cov_destination.getText() ; 
        String date = cov_date.getText() ; 

        int nbrplace = Integer.parseInt(cov_nbr.getText()) ; 
        int prix = Integer.parseInt(cov_prix.getText()) ; 
        int id_cov  = Integer.parseInt(cov_idc.getText()) ; 
        String vehicule = cov_vehicule.getText();


        Covoiturage c = new Covoiturage(id_cov , depart, destination, date, prix, nbrplace,vehicule); 
        ServiceCovoiturage sc = new ServiceCovoiturage(); 
       try { 
            if (sc.ajouter(c)){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information");
                alert.setHeaderText("");
                alert.setContentText("covoiturage  ajouté avec succés ! ");
                alert.showAndWait();
            }
            else {
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("ERROR");
                alert.setHeaderText("Alerte");
                alert.setContentText("Impossible d'ajouter ce covoiturage");
                alert.showAndWait();
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ServiceCovoiturage.class.getName()).log(Level.SEVERE, null, ex);
        }    }
    
}
