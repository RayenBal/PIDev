/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Assurance;
import Services.ServiceAssurance;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class AfficherAssuranceController implements Initializable {
    @FXML
    private ListView<Assurance> tableAssurance;
    @FXML
    private Button buttonafficher;

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
    private void AfficherCompte(ActionEvent event) throws SQLException{
       ServiceAssurance sa = new ServiceAssurance();
        List<Assurance> atab = sa.readAll();
         System.out.println(atab);
         ObservableList<Assurance> Assurance = FXCollections.observableArrayList(atab);
      tableAssurance.setItems(Assurance);  
    }
    
}
