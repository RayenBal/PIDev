/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class AddPMController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private Button btnA;

    @FXML
    private TextField txtPM;

    @FXML
    private TextField txtid;

    @FXML
    private TextField txtm;
    
    @FXML
     private Label idErrorLabel;
    
     @FXML
    private Label UIDeL;
     
     @FXML
     private Label PMEL;


    @FXML
    void Add(ActionEvent event) {
 try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");
                    
            int id = Integer.parseInt(txtid.getText());
            int userId = Integer.parseInt(txtm.getText());
            int type = Integer.parseInt(txtPM.getText());
            
            if (userId < 0) {
                UIDeL.setText("Invalid userID. Please enter a positive number.");
                return;
            
            }
            
          if (id < 0) {
                idErrorLabel.setText("Invalid ID. Please enter a positive number.");
                return;
            }
          

          
        
            PaymentMethod p = new PaymentMethod (id, userId , type );
            ServicePaymentMeth PS = new ServicePaymentMeth();
            PS.ajouter(p);
           
            
            // Clear the text fields
            txtid.clear();
            txtm.clear();
            txtPM.clear();
            
            
            System.out.println("Payment added to the database.");
            
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
