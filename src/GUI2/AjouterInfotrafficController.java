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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class AjouterInfotrafficController implements Initializable {

    @FXML
    private TextField infocase1;
    @FXML
    private TextField infocase2;
    @FXML
    private TextArea infotext;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   private void ajouterInfotraffic(ActionEvent event) {
    // Validate input for idc
    if (!infocase2.getText().matches("\\d+")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("The value for idc must be a number.");
        alert.showAndWait();
        return;
    }
    
    try {
        String type = infocase1.getText();
        String description = infotext.getText();
        int idc = Integer.parseInt(infocase2.getText());
        
        infotrafic it = new infotrafic(type, description, idc);
        ServiceInfotrafic si = new ServiceInfotrafic();
        si.ajouter(it);
        
        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("The infotrafic has been successfully added.");
        alert.showAndWait();
        
        // Clear text fields
        infocase1.clear();
        infotext.clear();
        infocase2.clear();
    } catch (SQLException ex) {
        Logger.getLogger(AjouterInfotrafficController.class.getName()).log(Level.SEVERE, null, ex);
        
        // Show error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while adding the infotrafic. Please try again.");
        alert.showAndWait();
    } catch (NumberFormatException ex) {
        // Show error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Please enter a valid number for idc.");
        alert.showAndWait();
    } catch (IllegalArgumentException ex) {
        // Show error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText(ex.getMessage());
        alert.showAndWait();
    }
}

    
}
