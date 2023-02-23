/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateGUI;

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
public class UpdatePMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Button btn3;
    
    @FXML
    private TextField txtD;
    
    @FXML
    private TextField txtM;
    
    @FXML
    private TextField txtid;
    
    @FXML
    void Update(ActionEvent event){
         try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // get the updated data from the input fields
        int id = Integer.parseInt(txtid.getText());
        int userId = Integer.parseInt(txtM.getText());
        int type = Integer.parseInt(txtD.getText());
        
        
        // create a new Paiement object with the updated data
        PaymentMethod p = new PaymentMethod(id, userId, type);
        
        // update the database with the new Paiement object
        ServicePaymentMeth PS = new ServicePaymentMeth();
        PS.update(p);

        // clear the input fields
        txtid.clear();
        txtM.clear();
        txtD.clear();
       
        
        System.out.println("Payment updated in the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
    }
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
