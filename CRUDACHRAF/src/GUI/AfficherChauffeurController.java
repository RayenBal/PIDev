/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Chauffeur;
import Services.ServiceChauffeur;
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
 * @author medzr
 */
public class AfficherChauffeurController implements Initializable {

    @FXML
    private ListView<Chauffeur> idtable;
    @FXML
    private Button buttonab;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    @FXML
private void AfficherChauffeur(ActionEvent event) {
    try {
        ServiceChauffeur sc = new ServiceChauffeur();
        List<Chauffeur> ctab = sc.readAll();
        System.out.println(ctab);
        ObservableList<Chauffeur> Chauffeur = FXCollections.observableArrayList(ctab);
        idtable.setItems(Chauffeur);
    } catch (SQLException e) {
        e.printStackTrace();
        // Handle the exception in a way that makes sense for your application
    }
}
}

