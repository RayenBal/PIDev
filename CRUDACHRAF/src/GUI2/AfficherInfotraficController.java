/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.infotrafic;
import Services.ServiceInfotrafic;
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
public class AfficherInfotraficController implements Initializable {

    @FXML
    private ListView<infotrafic> listview1;
    @FXML
    private Button buttonaffiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AfficherInfotrafic(ActionEvent event) throws SQLException {
        
         ServiceInfotrafic si = new ServiceInfotrafic();
        List<infotrafic> ctab = si.readAll();
         System.out.println(ctab);
         ObservableList<infotrafic> infotrafic = FXCollections.observableArrayList(ctab);
      listview1.setItems(infotrafic); 
        
    }
    
}
