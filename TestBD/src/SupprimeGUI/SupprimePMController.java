/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SupprimeGUI;

import Entite.Paiement;
import Entite.PaymentMethod;
import Services.ServicePaiement;
import Services.ServicePaymentMeth;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class SupprimePMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private Button btnD;

    @FXML
    private TextField txtid;

    @FXML
    void Delete(ActionEvent event) {
 try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // Get the selected payment ID from the list view
         int id = Integer.parseInt(txtid.getText());
         java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        PaymentMethod p = new PaymentMethod(id, 0, 0);
        // Delete the payment from the database
        ServicePaymentMeth PM = new ServicePaymentMeth();
        PM.supprime(p);

        // Remove the payment from the list view
        

        System.out.println("Payment deleted from the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
