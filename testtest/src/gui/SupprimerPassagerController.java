/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Passager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import service.PassagerService;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class SupprimerPassagerController implements Initializable {

    @FXML
    private Button button69;
    @FXML
    private TextField SupprimeID;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void SupprimerPassager(ActionEvent event) {
            try {
            int idp=Integer.parseInt(SupprimeID.getText());
            
            Passager c = new Passager("","" ,"","","");
            // Delete the payment from the database
            PassagerService sc= new PassagerService();
            sc.supprime(c,idp);
        } catch (SQLException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
