package Services;

import Entite.Chauffeur;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AjouterChauffeurController implements Initializable {

    @FXML
    private TextField Cnomc;
    @FXML
    private TextField Cprenomc;
    @FXML
    private TextField Cnumc;
    @FXML
    private TextField Cadressec;
    @FXML
    private TextField Cemailc;
    @FXML
    private TextField Cdestinationc;
    @FXML
    private Button button1;

    // Twilio account SID and auth token
    public static final String ACCOUNT_SID = "AC7820afe394dbafb7a218a18b491c5c07";
    public static final String AUTH_TOKEN = "247d6110bf1f00a5664f81f026f3f5d6";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+12706759631";
    public static final String RECIPIENT_PHONE_NUMBER = "+21695411518";

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void SaveChauffeur(ActionEvent event) throws SQLException {
        String nomc = Cnomc.getText();
        String prenomc = Cprenomc.getText();
        String numc = Cnumc.getText();
        String adressec = Cadressec.getText();
        String emailc = Cemailc.getText();
        String destinationc = Cdestinationc.getText();

        // Validate input
        if (nomc.isEmpty() || prenomc.isEmpty() || numc.isEmpty() || adressec.isEmpty() || emailc.isEmpty() || destinationc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required.");
            alert.showAndWait();
            return;
        }
        if (!destinationc.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Destination ID must be a number.");
            alert.showAndWait();
            return;
        }
        if (!emailc.matches(".+@.+\\.com")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email address.");
            alert.showAndWait();
            return;
        }

        int idd = Integer.parseInt(destinationc);
        Chauffeur c = new Chauffeur(nomc, prenomc, numc, adressec, emailc, idd);
        ServiceChauffeur sc = new ServiceChauffeur();
        
            sc.ajouter(c);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Chauffeur added successfully.");
            alert.showAndWait();

            // Clear text fields
            Cnomc.clear();
            Cprenomc.clear();
            Cnumc.clear();
            Cadressec.clear();
            Cemailc.clear();
            Cdestinationc.clear();

            // Send SMS
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(
                    new PhoneNumber(RECIPIENT_PHONE_NUMBER),
                    new PhoneNumber(TWILIO_PHONE_NUMBER),
                    "Chauffeur a ete ajouté avec succees"
            ).create();

            System.out.println("SMS message SID: " + message.getSid());
    }
}

