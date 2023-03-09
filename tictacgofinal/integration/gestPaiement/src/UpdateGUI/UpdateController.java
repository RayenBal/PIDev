/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpdateGUI;

import Entite.Paiement;
import Services.ServicePaiement;
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
public class UpdateController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
     @FXML
    private TextField M_id;

    @FXML
    private Button btn3;

    @FXML
    private TextField txtD;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtM;

    @FXML
    private TextField txtValide;

    @FXML
    private TextField txtid;
    
      @FXML
    private Label DaER;

    

    @FXML
    private Label VER;

 

    @FXML
    private Label desER;

    @FXML
    private Label idER;

    @FXML
    private Label ideer;

    @FXML
    private Label prER;

    @FXML
    void Update(ActionEvent event) {
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // get the updated data from the input fields
      //  int id = Integer.parseInt(txtid.getText());
        int id;
        try {
            id = Integer.parseInt(txtid.getText());
        } catch (NumberFormatException e) {
            idER.setText("Invalid ID. Please enter a positive integer.");
            return;
        }
       // int userId = Integer.parseInt(txtM.getText());
       int userId;
        try {
            userId = Integer.parseInt(txtM.getText());
             if (userId < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            prER.setText("Invalid User ID. Please enter a positive integer.");
            return;
        }
        String type = txtD.getText();
          
        if (type.isEmpty()) {
            desER.setText("Payment type cannot be empty.");
            return;
        }
        System.out.println(userId + type );
        String date = txtDate.getText();
       
        if (date.isEmpty()) {
            DaER.setText("Payment date cannot be empty.");
            return;
        }
       
        int pvalide;
        try {
            pvalide = Integer.parseInt(txtValide.getText());
            if (pvalide != 0 && pvalide != 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            VER.setText("Invalid PValide. Please enter either 0 or 1.");
            return;
        }
       
        
         int MM_id;
        try {
            MM_id = Integer.parseInt(M_id.getText());
            if (userId < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            ideer.setText("Invalid MM ID. Please enter a positive integer.");
            return;
        }
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        // create a new Paiement object with the updated data
        Paiement p = new Paiement(id, userId, type, sqlDate, pvalide, MM_id);
        
        // update the database with the new Paiement object
        ServicePaiement PS = new ServicePaiement();
        PS.update(p);

        // clear the input fields
        txtid.clear();
        txtM.clear();
        txtD.clear();
        txtDate.clear();
        txtValide.clear();
        
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
