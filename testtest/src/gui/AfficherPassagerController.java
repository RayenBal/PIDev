/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Passager;
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
import service.PassagerService;

/**
 * FXML Controller class
 *
 * @author sarra
 */
public class AfficherPassagerController implements Initializable {

    @FXML
    private ListView<Passager> idtable;
    @FXML
    private Button buttonab;

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
      private void AfficherPassager(ActionEvent event) throws SQLException {
        
        PassagerService sc = new PassagerService();
        List<Passager> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Passager> passager = FXCollections.observableArrayList(ctab);
      idtable.setItems(passager); 
    }
    
}
