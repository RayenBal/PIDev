/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Compte;
import Services.ServiceCompte;
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
public class AffichercompteController implements Initializable {

    @FXML
    private ListView<Compte> tablecompte;
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
    private void AfficherCompte(ActionEvent event) throws SQLException{
       ServiceCompte sc = new ServiceCompte();
        List<Compte> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Compte> Compte = FXCollections.observableArrayList(ctab);
      tablecompte.setItems(Compte);  
    }
    
}
