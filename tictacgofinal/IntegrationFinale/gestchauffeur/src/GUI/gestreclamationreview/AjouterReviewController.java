package GUI.gestreclamationreview;

import Entite.Review;
import Services.ServiceReview;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class AjouterReviewController implements Initializable {

    // Twilio configuration
    public static final String ACCOUNT_SID = "AC8b8803d6c9b49559a01c62a335a0da81";
    public static final String AUTH_TOKEN = "4609277f13e2d6296346de64028eb83d";
    public static final String FROM_NUMBER = "+15675571522";
    public static final String TO_NUMBER = "+21655861890";

    @FXML
    private Button btt;

    @FXML
    private Label lbdes;

    @FXML
    private TextField tfdes;

    @FXML
    void save(ActionEvent event) throws SQLException {
        try {
            String avis = tfdes.getText().trim();

            // Vérification de la validité de la nom
            if (avis.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("L'avis ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Création de la réclamation
            Review r = new Review(avis);
            ServiceReview sr = new ServiceReview();
            sr.ajouter(r);

            // Nettoyage des champs de saisie
            tfdes.clear();
            System.out.println("Avis ajouté dans la base de données.");

            // Envoi d'un SMS avec Twilio
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            String messageBody = "Nouvel avis ajouté : " + avis;
            Message message = Message.creator(
                    new PhoneNumber(TO_NUMBER),  // Your phone number
                    new PhoneNumber(FROM_NUMBER),  // Your Twilio phone number
                    messageBody)
                    .create();
            System.out.println("SMS envoyé.");

        } catch (SQLException e) {
            // Affichage d'une erreur inattendue (par exemple, erreur de connexion à la base de données)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite !");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
