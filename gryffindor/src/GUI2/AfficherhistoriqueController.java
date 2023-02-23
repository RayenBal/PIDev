/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Historique;
import Services.ServiceHistorique;
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
public class AfficherhistoriqueController implements Initializable {

    @FXML
    private ListView<Historique> tablehistorique;
    @FXML
    private Button buttonafficher;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficherhistorique(ActionEvent event) throws SQLException {
        ServiceHistorique sh = new ServiceHistorique();
        List<Historique> htab = sh.readAll();
         System.out.println(htab);
         ObservableList<Historique> Historique = FXCollections.observableArrayList(htab);
      tablehistorique.setItems(Historique);
    }
    
}
