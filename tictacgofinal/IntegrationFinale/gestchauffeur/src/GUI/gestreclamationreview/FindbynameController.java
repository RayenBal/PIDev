/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestreclamationreview;
import Entite.Reclamation;
import Services.ServiceReclamation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Entite.Reclamation;
import Services.ServiceReclamation;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class FindbynameController implements Initializable {

    @FXML
    private TextField tfnomr;
    @FXML
    private Label lbnomr;
    @FXML
    private Button btcher;
    
     @FXML
    private ListView<Reclamation> idtable;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Findbyname(ActionEvent event) throws SQLException {
        try {
    // Vérifier si l'utilisateur a entré une chaine de caracrtere
    if (tfnomr.getText().matches("^[a-zA-Z]+$")) {
        String nomr = tfnomr.getText();

        // Supprimer la réclamation de la base de données
        ServiceReclamation sr = new ServiceReclamation();
        sr.findByName(nomr);
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier pour le nom de réclamation.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerrecController.class.getName()).log(Level.SEVERE, null, ex);
}
 ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
  
        
        
        
    
    }
        
        
     }


  

    
    
    

