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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class UpdateInfotraficController implements Initializable {

    @FXML
    private AnchorPane buttonmaj;
    @FXML
    private TextField majcase1;
    @FXML
    private TextField majcase2;
    @FXML
    private TextField majcase3;
    @FXML
    private TextArea infotext2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
 private void UpdateInfotrafic(ActionEvent event) {
    // Validate input for idi and idc
    if (!majcase1.getText().matches("\\d+") || !majcase3.getText().matches("\\d+")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("The values for idi and idc must be numbers.");
        alert.showAndWait();
        return;
    }
    
    try {
        int idi = Integer.parseInt(majcase1.getText());
        String type = majcase2.getText();
        String description = infotext2.getText();
        int idc = Integer.parseInt(majcase3.getText());
        
        infotrafic it = new infotrafic(idi, type, description, idc);
        ServiceInfotrafic si = new ServiceInfotrafic();
        si.update(it);
        
        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Update Successful");
        alert.setHeaderText(null);
        alert.setContentText("The infotrafic has been successfully updated.");
        alert.showAndWait();
        
        // Clear text fields
        majcase1.clear();
        majcase2.clear();
        infotext2.clear();
        majcase3.clear();
    } catch (SQLException ex) {
        Logger.getLogger(UpdateInfotraficController.class.getName()).log(Level.SEVERE, null, ex);
    }
}


    
}
