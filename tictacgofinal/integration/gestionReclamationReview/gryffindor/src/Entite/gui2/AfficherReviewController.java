/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Review;
import Services.ServiceReview;
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
public class AfficherReviewController implements Initializable {

    @FXML
    private ListView<Review> idtable;
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
    private void Afficherrec(ActionEvent event) throws SQLException {
        ServiceReview sc = new ServiceReview();
        List<Review> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Review> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
        
    }
}
