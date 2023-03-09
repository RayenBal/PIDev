package GUI.gestreclamationreview;

import Entite.Reclamation;
import Services.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 */
public class UpdateController implements Initializable {

    @FXML
    private Label lbnomr;
    @FXML
    private Label lbdes;
    @FXML
    private Label lbdate;
    @FXML
    private TextField tfdes;
    @FXML
    private Button btt;
    @FXML
    private TextField tfnomr;
    @FXML
    private DatePicker datePicker;

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
    public void updateReclamation(ActionEvent event) throws SQLException {
        String nom=tfnomr.getText();
        String desc= tfdes.getText();
         LocalDate date = datePicker.getValue();
        // Vérification que les champs obligatoires sont remplis
      /* if (tfnomr.getText().isEmpty() || tfdes.getText().isEmpty() || datePicker.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
            return;
        }*/

        // Création de l'objet Reclamation avec les valeurs saisies
        
        Reclamation r = new Reclamation(desc, date.toString(), nom);
        tfnomr.clear();
        tfdes.clear();

        // Envoi de la réclamation au service de réclamation pour mise à jour
        ServiceReclamation sr = new ServiceReclamation();
        sr.update(r);
    }
}
