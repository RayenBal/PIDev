/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import Entite.Reclamation;
import Services.ServiceReclamation;
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
 * @author ASUS
 */
public class AfficherrecController implements Initializable {

    @FXML
    private ListView<Reclamation> idtable;
    @FXML
    private Button buttonab;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Afficherrec(ActionEvent event) throws SQLException {
        ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
        
    }
    
}
