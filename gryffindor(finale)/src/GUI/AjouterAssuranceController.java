/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

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
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class AjouterAssuranceController implements Initializable {
     @FXML
    private TextField tfimma;
      @FXML
    private DatePicker datepicker;
      @FXML
    private Label lbimma;
      @FXML
    private Button bttsign;
    @FXML
    private Label lbsign;
    @FXML
    private Label lbnom;
 
      @FXML
    private void Save(ActionEvent event) {
        try {
    String immatriculation = tfimma.getText();
    LocalDate date = datepicker.getValue();

    // Vérifier que le nom ne contient que des lettres et des espaces
    if (!immatriculation.matches("[0-9]{3}[A-Z]{2}[0-9]{4}+")) {
        JOptionPane.showMessageDialog(null, "L'immatriculation est invalide", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }


    Assurance a = new Assurance(date.toString(), immatriculation);
    ServiceAssurance sa = new ServiceAssurance();
    sa.ajouter(a);

    tfimma.clear();
    datepicker.setValue(null);
    JOptionPane.showMessageDialog(null, "assurance ajouté dans la base de données.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "L'identifiant doit être un nombre entier positif.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
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
