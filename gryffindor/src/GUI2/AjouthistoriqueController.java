/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

import Entite.Historique;
import Services.ServiceHistorique;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class AjouthistoriqueController implements Initializable {

    @FXML
    private TextField tfnom;


    @FXML
    private Label lbsign;

    @FXML
    private Label lbnom;

    
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfhistorique;
    @FXML
    private Button bttajouter;
    @FXML
    private Label lbhistorique;
    @FXML
    private Label lbprenom;
     

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Save(ActionEvent event) {
        try {
     String nom = tfnom.getText();
   String prenom = tfprenom.getText();
       String historique = tfhistorique.getText();
    
    if (nom.isEmpty() || prenom.isEmpty() || historique.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.ERROR_MESSAGE);
        return;
    }
    
    Historique h = new Historique(nom, prenom, historique);
    ServiceHistorique sh = new ServiceHistorique();
    sh.ajouter(h);

    JOptionPane.showMessageDialog(null, "Historique ajouté dans la base de données.", "Succès", JOptionPane.INFORMATION_MESSAGE);

    tfnom.setText("");
    tfprenom.setText("");
    tfhistorique.setText("");
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Entrée invalide. Veuillez entrer un nombre.", "Erreur", JOptionPane.ERROR_MESSAGE);
}

    }
    
}
/*
try {
            
          
            String nom = tfnom.getText();
            String prenom = tfprenom.getText();
            String historique = tfhistorique.getText();
            
            //int hist = Integer.parseInt(tfhist.getText());
         
           // Compte c = new Compte(99 ,"hello", nom, email, mp, e);
           Historique h = new Historique(nom, prenom, historique);
            ServiceHistorique sh = new ServiceHistorique();
            sh.ajouter(h);

            tfnom.clear();
            tfprenom.clear();
            tfhistorique.clear();
           // tfuser.clear();
         System.out.println("Compte ajouter dans database.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
*/