/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;

import Entite.Assurance;
import Services.ServiceAssurance;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import com.mysql.cj.jdbc.Driver;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import static org.omg.CORBA.ObjectHelper.type;
/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class ModifierAssuranceController implements Initializable {
     @FXML
    private TextField tfimma;
      @FXML
    private DatePicker datepicker;
     @FXML
    private Button bttupdate;
    @FXML
    private Label lbsign;
    @FXML
    private Label lbnom;
    @FXML
    private Label lbemail;
 
        
    @FXML
    void update(ActionEvent event) {
         try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgobd", "root", "");

    // get the updated data from the input fields
     String immatriculation = tfimma.getText();
    if (!immatriculation.matches("[0-9]{3}[A-Z]{2}[0-9]{4}+")) {
        JOptionPane.showMessageDialog(null, "L'immatriculation est invalide");
        return;
    }
   
    // create a new Compte object with the updated data
    LocalDate date = datepicker.getValue();
    Assurance a = new Assurance( date.toString(), immatriculation);
    ServiceAssurance sa = new ServiceAssurance();
    sa.update(a);

    // clear the input fields
    tfimma.clear();
    datepicker.setValue(null);

    JOptionPane.showMessageDialog(null, "Compte updated in the database.");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
}

    }
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
 
    
}
