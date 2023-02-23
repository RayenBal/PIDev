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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class SupprimerInfotrafficController implements Initializable {

    @FXML
    private TextField casesup1;
    @FXML
    private Button buttonittt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   private void SupprimerInfotrafic(ActionEvent event) {
    String idiStr = casesup1.getText();

    // Check if idiStr is empty
    if (idiStr.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("Please enter a value for idi.");
        alert.showAndWait();
        return;
    }

    // Validate input for idi
    if (!idiStr.matches("\\d+")) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Input Error");
        alert.setHeaderText("Invalid input");
        alert.setContentText("The value for idi must be a number.");
        alert.showAndWait();
        return;
    }

    try {
        int idi = Integer.parseInt(idiStr);
        infotrafic it = new infotrafic(idi, "", "", 0);
        ServiceInfotrafic si = new ServiceInfotrafic();
        si.supprime(it);

        // Show success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText("The infotrafic has been successfully deleted.");
        alert.showAndWait();

        // Clear text field
        casesup1.clear();
    } catch (SQLException ex) {
        Logger.getLogger(SupprimerInfotrafficController.class.getName()).log(Level.SEVERE, null, ex);

        // Show error message
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText("An error occurred while deleting the infotrafic. Please try again.");
        alert.showAndWait();
    }
}


}
