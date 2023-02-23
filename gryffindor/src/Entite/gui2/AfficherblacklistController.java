/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import Entite.Blacklist;
import Entite.Reclamation;
import Services.ServiceBlacklist;
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
public class AfficherblacklistController implements Initializable {

    private ListView<Blacklist> idtable;
    @FXML
    private Button buttonab;
    @FXML
    private ListView<Blacklist> idaff;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void Afficherbl(ActionEvent event) throws SQLException {
        ServiceBlacklist sc = new ServiceBlacklist();
        List<Blacklist> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Blacklist> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
        
    }

  
    
}
