/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DisplayGUI;

import Entite.Paiement;
import Entite.PaymentMethod;
import Services.ServicePaiement;
import Services.ServicePaymentMeth;
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
 * @author INFOTEC
 */
public class DisplayPMController implements Initializable {
    
    @FXML
    private Button Disp;

    @FXML
    private ListView<PaymentMethod> LV;

    @FXML
    void Display(ActionEvent event) throws SQLException {
           ServicePaymentMeth PS1 = new ServicePaymentMeth();
        List<PaymentMethod> paiements = PS1.readAll();
         System.out.println(paiements);


       ObservableList<PaymentMethod> paiement = FXCollections.observableArrayList(paiements);
      LV.setItems(paiement); 
    }

    /**
     * Initializes the controller class.
     */
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
