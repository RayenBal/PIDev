/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Historique;
import Services.ServiceHistorique;
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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class ModifierhistoriqueController implements Initializable {

    @FXML
    private Label lbsign;
    @FXML
    private Label lbnom;
    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfhistorique;
    @FXML
    private Label lbhistorique;
    @FXML
    private Label lbprenom;
    @FXML
    private Button bttmodifier;
    @FXML
    private TextField tfidh;
    @FXML
    private Label lbidh;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void modifier(ActionEvent event) {
          try {
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

    // get the updated data from the input fields
    int idh = Integer.parseInt(tfidh.getText());
    String nom = tfnom.getText();
    String prenom = tfprenom.getText();
    String historique = tfhistorique.getText();
             if (nom.isEmpty() || prenom.isEmpty() || historique.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }  
    // create a new Historique object with the updated data
    Historique h = new Historique(idh, nom, prenom, historique);
    ServiceHistorique sh = new ServiceHistorique();
    sh.update(h);

    // clear the input fields
    tfidh.clear();
    tfnom.clear();
    tfprenom.clear();
    tfhistorique.clear();
        
    JOptionPane.showMessageDialog(null, "Historique updated in the database.");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
}
    }
    
}
