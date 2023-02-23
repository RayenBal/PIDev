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
 * @author Rayen
 */
public class UpdatecovController implements Initializable {


    @FXML
    private TextField cov_idcov;
    @FXML
    private TextField cov_depart;
    @FXML
    private TextField cov_dest;
    @FXML
    private TextField cov_date;
    @FXML
    private TextField cov_prix;
    @FXML
    private TextField cov_nbr;
    @FXML
    private TextField cov_vehicule;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onmodif(ActionEvent event) throws SQLException {
         String depart = cov_depart.getText() ; 
         String destination = cov_dest.getText() ; 
         String date = cov_date.getText() ; 
         int nbrplace =Integer.parseInt(cov_nbr.getText()) ; 
         int prix =Integer.parseInt(cov_prix.getText()) ; 
         int id_cov  =Integer.parseInt(cov_idcov.getText()) ;
         String vehicule = cov_vehicule.getText();
                                

        Covoiturage c = new Covoiturage(id_cov ,1, depart, destination, date, prix, nbrplace,vehicule); 
        ServiceCovoiturage sc = new ServiceCovoiturage(); 
    sc.update(c);
    }
        
        
    }
    

