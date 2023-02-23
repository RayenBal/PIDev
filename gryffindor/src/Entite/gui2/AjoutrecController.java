/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;

import Entite.Blacklist;
import Services.ServiceBlacklist;
import java.net.URL;
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
 * @author ASUS
 */
public class AjoutrecController implements Initializable {

    @FXML
    private Label lbrec;
    @FXML
    private Button btt;
    @FXML
    private Label lbpassager;
    @FXML
    private TextField tfpassager;
    @FXML
    private Label lbchauffeur;
    @FXML
    private TextField tfchauffeur;
    @FXML
    private Label lblist;
    @FXML
    private Label lbnbrec;
    @FXML
    private TextField tflist;
    @FXML
    private TextField tfnnbrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajoutblacklist(ActionEvent event) throws SQLException {
        // Vérification que les champs obligatoires sont remplis
if (tflist.getText().isEmpty() || tfnnbrec.getText().isEmpty() || tfpassager.getText().isEmpty() || tfchauffeur.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
    return;
}

// Vérification que les champs numériques contiennent des nombres valides
int nb, idc, idp;
try {
    nb = Integer.parseInt(tfnnbrec.getText());
    idc = Integer.parseInt(tfchauffeur.getText());
    idp = Integer.parseInt(tfpassager.getText());
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Veuillez saisir des nombres valides pour les champs numériques.");
    return;
}

// Création de l'objet Blacklist avec les valeurs saisies
Blacklist b = new Blacklist(tflist.getText(), nb, idp, idc);

// Envoi de la blacklist au service de blacklist pour ajout
ServiceBlacklist sb = new ServiceBlacklist();
sb.ajouter(b);

// Effacer les champs de saisie après l'ajout de la blacklist
tflist.clear();
tfnnbrec.clear();
tfpassager.clear();
tfchauffeur.clear();

// Message de confirmation à l'utilisateur
JOptionPane.showMessageDialog(null, "La blacklist a été ajoutée à la base de données.");

    }
      
    }
/*  try {
            
          
          
            String list = tflist.getText();
int nb = Integer.parseInt(tfnnbrec.getText());  
int idc = Integer.parseInt(tfchauffeur.getText());  
int idp = Integer.parseInt(tfpassager.getText());
           
           Blacklist b = new Blacklist(list, nb, idp, idc);
            ServiceBlacklist sb = new ServiceBlacklist();
            sb.ajouter(b);

            tflist.clear();
            tfnnbrec.clear();
            tfpassager.clear();
            tfchauffeur.clear();
           // tfuser.clear();
         System.out.println("list ajoutée dans database.");
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a letters.");
        }
    }
*/
