/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gestpaiement;

import Entite.Paiement;
import Entite.PaymentMethod;
import Services.ServicePaiement;
import Services.ServicePaymentMeth;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class FindByIdPMController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML
    private ListView<PaymentMethod> LV;

    @FXML
    private Button btnF;

    @FXML
    private TextField txtid;

    @FXML
    void FindByID(ActionEvent event) throws SQLException {
 int id = Integer.parseInt(txtid.getText());
         ServicePaymentMeth PS = new ServicePaymentMeth();
    
    PaymentMethod paiements = PS.findById(id);
    
    
    if (paiements != null) {
        
        
         System.out.println(paiements);
         ObservableList<PaymentMethod> paiement = FXCollections.observableArrayList(paiements);
      LV.setItems(paiement);
    } else {
        System.out.println("No payment found with ID: " + id);
    }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
