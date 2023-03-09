package GUI;

import javafx.animation.Animation;
import javafx.scene.control.Label;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import Entite.Chauffeur;
import Entite.infotrafic;
import static Services.AjouterChauffeurController.ACCOUNT_SID;
import static Services.AjouterChauffeurController.AUTH_TOKEN;
import static Services.AjouterChauffeurController.RECIPIENT_PHONE_NUMBER;
import static Services.AjouterChauffeurController.TWILIO_PHONE_NUMBER;
import Services.ServiceChauffeur;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import java.awt.image.BufferedImage;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;


public class AfficherChauffeurController implements Initializable {

    private Button buttonretour;
    private ImageView modif;
    private ImageView supp;
    @FXML
    private TableView<Chauffeur> tableview;
    @FXML
    private TableColumn<Chauffeur, String> nomColumn;
    @FXML
    private TableColumn<Chauffeur, String> prenomColumn;
    @FXML
    private TableColumn<Chauffeur, String> numColumn;
    @FXML
    private TableColumn<Chauffeur, String> adresseColumn;
    @FXML
    private TableColumn<Chauffeur, String> emailColumn;
    @FXML
    private TableColumn<Chauffeur, String> destinationColumn;
    @FXML
    private TextField searchText;

    private ObservableList<Chauffeur> chauffeurList;
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
    private Button button77;
    @FXML
    private Button btnA;
    @FXML
    private Button btnD;
    @FXML
    private Label dateLabel;
    @FXML
    private Label clockLabel;
    public static final String ACCOUNT_SID = "AC7820afe394dbafb7a218a18b491c5c07";
    public static final String AUTH_TOKEN = "c1dc4b87078529383977c6dc59704523";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+12706759631";
    public static final String RECIPIENT_PHONE_NUMBER = "+21695411518";
    private ImageView homei;
   @FXML
private ComboBox<String> comboBox;
    @FXML
    private Button QRCode;

@Override
public void initialize(URL url, ResourceBundle rb) {
    afficherChauffeurs();

    comboBox.getItems().addAll("Trier par nom", "Trier par Prenom");
    comboBox.setOnAction(event -> {
        String choix = comboBox.getValue();
        if (choix.equals("Trier par nom")) {
            trierParNom();
        }
        if (choix.equals("Trier par Prenom")) {
            trierParPrenom();
        }
    });

    // Set up the clock label to show the current time
    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
        // Get the current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format the time
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(timeFormatter);

        // Set the label's text to the formatted time
        clockLabel.setText(formattedTime);
    }));
    timeline.setCycleCount(Animation.INDEFINITE);
    timeline.play();

    // Set up the date label to show the current date
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    String formattedDate = now.format(dateFormatter);
    dateLabel.setText(formattedDate);
}



    private void afficherChauffeurs() {
        try {
            ServiceChauffeur sc = new ServiceChauffeur();
            List<Chauffeur> ctab = sc.readAll();
            chauffeurList = FXCollections.observableArrayList(ctab);
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomc"));
            prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenomc"));
            numColumn.setCellValueFactory(new PropertyValueFactory<>("numc"));
            adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adressec"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailc"));
            destinationColumn.setCellValueFactory(new PropertyValueFactory<>("idd"));
            tableview.setItems(chauffeurList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
        tableview.setItems(chauffeurList);
        FilteredList<Chauffeur> filteredData = new FilteredList<>(FXCollections.observableList(chauffeurList));
        tableview.setItems(filteredData);
        searchText.textProperty().addListener((observable, oldValue, newValue) ->
        filteredData.setPredicate(createPredicate(newValue)));
    }

    private void retour(ActionEvent event) {
        Stage stage = (Stage) buttonretour.getScene().getWindow();
        stage.close();
    }

    private void modifierChauffeur(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("updateChauffeur.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) modif.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void supprimerChauffeur(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SupprimerChauffeur.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) supp.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    //recherche
     /////// recherche
    private boolean searchFindsOrder(Chauffeur snc, String searchText){
    return (snc.getNomc().toLowerCase().contains(searchText.toLowerCase())) ||
            (snc.getPrenomc().toLowerCase().contains(searchText.toLowerCase())) ||
            Integer.valueOf(snc.getNumc()).toString().equals(searchText.toLowerCase());
}
    private ObservableList<Chauffeur> filterList(List<Chauffeur> list, String searchText){
    List<Chauffeur> filteredList = new ArrayList<>();
    for (Chauffeur seancer : list){
        if(searchFindsOrder(seancer, searchText)) filteredList.add(seancer);
    }
    return FXCollections.observableList(filteredList);
}
    private Predicate<Chauffeur> createPredicate(String searchText){
    return seance -> {
        if (searchText == null || searchText.isEmpty()) return true;
        return searchFindsOrder(seance, searchText);
    };
    }

    @FXML
    private void handleTableViewMouseClicked(MouseEvent event) {
            if (event.getClickCount() == 1) { // vérifie si l'utilisateur a cliqué une seule fois
        Chauffeur chauffeur = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Chauffeur de la ligne sélectionnée
        Cnomc.setText(chauffeur.getNomc()); // affiche les données dans les TextFields
        Cprenomc.setText(chauffeur.getPrenomc());
        Cnumc.setText(chauffeur.getNumc());
        Cadressec.setText(chauffeur.getAdressec());
        Cemailc.setText(chauffeur.getEmailc());
        Cdestinationc.setText(Integer.toString(chauffeur.getIdd()));
        
    }

        
    }

 @FXML
private void UpdateChauffeur(ActionEvent event) {
    Chauffeur chauffeur = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Chauffeur de la ligne sélectionnée
    
    chauffeur.setNomc(Cnomc.getText()); // met à jour le nom
    chauffeur.setPrenomc(Cprenomc.getText()); // met à jour le prénom
    chauffeur.setNumc(Cnumc.getText()); // met à jour le numéro
    chauffeur.setAdressec(Cadressec.getText()); // met à jour l'adresse
    chauffeur.setEmailc(Cemailc.getText()); // met à jour l'email
    chauffeur.setIdd(Integer.parseInt(Cdestinationc.getText())); // met à jour l'identifiant de destination
    
    try {
        ServiceChauffeur sc = new ServiceChauffeur();
        sc.update(chauffeur); // met à jour les données du chauffeur dans la base de données
        afficherChauffeurs(); // actualise la table des chauffeurs
    } catch (SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + e.getMessage());
        alert.showAndWait();
    }
    Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(
                    new PhoneNumber(RECIPIENT_PHONE_NUMBER),
                    new PhoneNumber(TWILIO_PHONE_NUMBER),
                    "Chauffeur a ete modifié avec succées"
            ).create();

            System.out.println("SMS message SID: " + message.getSid());
}


    @FXML
    private void ajouterChauffeur(ActionEvent event) throws SQLException {
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
            tableview.setItems(FXCollections.observableArrayList(chauffeurList));
     
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Chauffeur added successfully.");
            alert.showAndWait();

            // Clear text fields
            Cnomc.clear();
            Cprenomc.clear();
            Cnumc.clear();
            Cadressec.clear();
            Cemailc.clear();
            Cdestinationc.clear();
       
            Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(
                    new PhoneNumber(RECIPIENT_PHONE_NUMBER),
                    new PhoneNumber(TWILIO_PHONE_NUMBER),
                    "Chauffeur a ete ajouté avec succees"
            ).create();

            System.out.println("SMS message SID: " + message.getSid());
    }

            

    

   @FXML
    private void DeleteChauffeur(ActionEvent event) {
        Chauffeur chauffeur = tableview.getSelectionModel().getSelectedItem();
        if (chauffeur != null) {
        try {
        // Delete the selected chauffeur from the database
        ServiceChauffeur sc = new ServiceChauffeur();
        sc.supprime(chauffeur);
        // Remove the selected chauffeur from the table view
        chauffeurList.remove(chauffeur);
        tableview.setItems(FXCollections.observableArrayList(chauffeurList));
        } catch (SQLException ex) {
        Logger.getLogger(AfficherChauffeurController.class.getName()).log(Level.SEVERE, null, ex);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + ex.getMessage());
        alert.showAndWait();
        }
        }
               Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

            Message message = Message.creator(
                    new PhoneNumber(RECIPIENT_PHONE_NUMBER),
                    new PhoneNumber(TWILIO_PHONE_NUMBER),
                    "Chauffeur a ete supprimé avec succées"
            ).create();

            System.out.println("SMS message SID: " + message.getSid());
        }

    private void trierParNom() {
    Comparator<Chauffeur> compareByNomc = Comparator.comparing(Chauffeur::getNomc);
    SortedList<Chauffeur> sortedData = new SortedList<>(FXCollections.observableArrayList(chauffeurList), compareByNomc);
    tableview.setItems(sortedData);
    }
    
    private void trierParPrenom(){
    Comparator<Chauffeur> compareByPrenomc = Comparator.comparing(Chauffeur::getPrenomc);
    SortedList<Chauffeur> sortedData = new SortedList<>(FXCollections.observableArrayList(chauffeurList), compareByPrenomc);
    tableview.setItems(sortedData);
    }
    
    
    @FXML
    private void qrco(ActionEvent event) throws WriterException {// Get the selected Destination object from the ListView
 // Get the selected Destination object from the ListView
    Chauffeur chauffeur = tableview.getSelectionModel().getSelectedItem();

    if (chauffeur != null) {
        // Get the name of the "pays", "etoile" and "type" from the selected Destination
        String nomc = chauffeur.getNomc();
        String prenomc = chauffeur.getPrenomc();
        String numc = chauffeur.getNumc();
        String adressec = chauffeur.getAdressec();
        String emailc = chauffeur.getEmailc();
        int idd = chauffeur.getIdd();

        // Generate the QR code with the paysName, etoile and type as the content
        String content = nomc + "|" + prenomc + "|" + numc + "|" + adressec + "|" + emailc + "|" + idd; // Use the pipe symbol as separator
        int width = 300;
        int height = 300;
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(content, BarcodeFormat.QR_CODE, width, height);

        // Convert the BitMatrix to a BufferedImage
        BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

        // Display the image in a new window
        Stage stage = new Stage();
        stage.setTitle("QR Code");
        ImageView imageView = new ImageView(SwingFXUtils.toFXImage(qrImage, null));
        Scene scene = new Scene(new Group(imageView));
        stage.setScene(scene);
        stage.show();
    } else {
        // Handle case where no destination is selected
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("No hotel selected");
        alert.setContentText("Please select a hotel from the list.");
        alert.showAndWait();
    }   
    }

}