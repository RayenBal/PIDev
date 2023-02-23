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
public class UpdatePassagerController implements Initializable {

    @FXML
    private TextField ucase2;
    @FXML
    private TextField ucase3;
    @FXML
    private TextField ucase4;
    @FXML
    private TextField ucase5;
    @FXML
    private TextField ucase1;
    @FXML
    private Button button77;
    @FXML
    private TextField ucase6;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
       private void UpdatePassager(ActionEvent event) {
        
        try {
            
            int idp=Integer.parseInt(ucase1.getText());    
            String nomp = ucase2.getText();
            String prenomp= ucase3.getText();
            String nump=ucase4.getText();
            String adressep = ucase5.getText() ;
            String emailp=ucase6.getText() ;
            
            
            
            
            Passager c = new Passager(nomp,prenomp,nump,adressep,emailp);
            PassagerService sc = new PassagerService();
            sc.update(c,idp);
        } catch (SQLException ex) {
            Logger.getLogger(UpdatePassagerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
