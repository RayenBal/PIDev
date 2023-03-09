package GUI.gestpassager;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import Entite.Passager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import Services.PassagerService;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
import org.controlsfx.control.Notifications;
import Services.SendMail;



public class  menuJavaController implements Initializable {

    private Button buttonretour;
    private ImageView modif;
    private ImageView supp;
    @FXML
    private TableView<Passager> tableview;
  
    @FXML
    private TextField searchText;

    private ObservableList<Passager> PassagerList;
    @FXML
    private TextField nompCol;
    @FXML
    private TextField prenompCol;
    @FXML
    private TextField numpCol;
    @FXML
    private TextField adressepCol;
    @FXML
    private TextField emailpCol ;
    
    @FXML
    private Button button77;
    @FXML
    private Button btnA;
    @FXML
    private Button btnD;
    @FXML
    private TableColumn<Passager, String> nomColumn;
    @FXML
    private TableColumn<Passager, String> prenomColumn;
    @FXML
    private TableColumn<Passager, String> numColumn;
    @FXML
    private TableColumn<Passager, String> adresseColumn;
    @FXML
    private TableColumn<Passager, String> emailColumn;
    @FXML
    private Button btnPDF;
  
@FXML
private ComboBox<String> comboBox;


public class SendMail {
   public  void send(String recipient, String subject, String body) throws Exception {
      // Set properties
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      // Create a Session object
      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("sarra.bellassoued@esprit.tn", "201JFT1850");
         }
      });

      try {
         // Create a MimeMessage object
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("your_email@gmail.com"));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipient));
         message.setSubject(subject);
         message.setText(body);

         // Send the message
         Transport.send(message);
         System.out.println("Email sent successfully.");
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}


@Override
public void initialize(URL url, ResourceBundle rb) {
    afficherPassagers();
    
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
    }

    private void afficherPassagers() {
        try {
            PassagerService sc = new PassagerService();
            List<Passager> ctab = sc.readAll();
            PassagerList = FXCollections.observableArrayList(ctab);
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nomp"));
            prenomColumn.setCellValueFactory(new PropertyValueFactory<>("prenomp"));
            numColumn.setCellValueFactory(new PropertyValueFactory<>("nump"));
            adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adressep"));
            emailColumn.setCellValueFactory(new PropertyValueFactory<>("emailp"));
         
            tableview.setItems(PassagerList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
        tableview.setItems(PassagerList);
        FilteredList<Passager> filteredData = new FilteredList<>(FXCollections.observableList(PassagerList));
        tableview.setItems(filteredData);
        searchText.textProperty().addListener((observable, oldValue, newValue) ->
        filteredData.setPredicate(createPredicate(newValue)));
    }

  
    //recherche
     /////// recherche
    private boolean searchFindsOrder(Passager snc, String searchText){
    return (snc.getNomp().toLowerCase().contains(searchText.toLowerCase())) ||
            (snc.getPrenomp().toLowerCase().contains(searchText.toLowerCase())) ||
            Integer.valueOf(snc.getNump()).toString().equals(searchText.toLowerCase());
}
    private ObservableList<Passager> filterList(List<Passager> list, String searchText){
    List<Passager> filteredList = new ArrayList<>();
    for (Passager seancer : list){
        if(searchFindsOrder(seancer, searchText)) filteredList.add(seancer);
    }
    return FXCollections.observableList(filteredList);
}
    private Predicate<Passager> createPredicate(String searchText){
    return seance -> {
        if (searchText == null || searchText.isEmpty()) return true;
        return searchFindsOrder(seance, searchText);
    };
    }

    @FXML
    private void handleTableViewMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 1) { // vérifie si l'utilisateur a cliqué une seule fois
        Passager Passager = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Passager de la ligne sélectionnée
        nompCol.setText(Passager.getNomp()); // affiche les données dans les TextFields
        prenompCol.setText(Passager.getPrenomp());
       numpCol.setText(Passager.getNump());
        adressepCol.setText(Passager.getAdressep());
        emailpCol.setText(Passager.getEmailp());
       
        
    }

        
    }

    @FXML
    private void UpdatePassager(ActionEvent event) {
    Passager Passager = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Passager de la ligne sélectionnée
    
    Passager.setNomp(nompCol.getText()); // met à jour le nom
    Passager.setPrenomp(prenompCol.getText()); // met à jour le prénom
    Passager.setNump(numpCol.getText());// met à jour le numéro
    Passager.setAdressep(adressepCol.getText()); // met à jour l'adresse
    Passager.setEmailp(emailpCol.getText()); // met à jour l'email
  
    
    try {
        PassagerService sc = new PassagerService();
        sc.update(Passager); // met à jour les données du Passager dans la base de données
        afficherPassagers(); // actualise la table des Passagers
    } catch (SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + e.getMessage());
        alert.showAndWait();
    }
}


    @FXML
    private void ajouterPassager(ActionEvent event) throws SQLException {
     String nomp = nompCol.getText();
        String prenomp = prenompCol.getText();
        String nump =numpCol.getText();
        String adressep = adressepCol.getText();
        String emailp = emailpCol.getText();
    

        // Validate input
        if (nomp.isEmpty() || prenomp.isEmpty() || nump.isEmpty() || adressep.isEmpty() || emailp.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required.");
            alert.showAndWait();
            return;
        }
       
        if (!emailp.matches(".+@.+\\.com|.+@.+\\.tn")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email address.");
            alert.showAndWait();
            return;
        }

       
        Passager p = new Passager(nomp, prenomp, nump, adressep, emailp);
        PassagerService sc = new PassagerService();
        
            sc.ajouter(p);
           
    
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Passager added successfully.");
            alert.showAndWait();
            
            try {
        // Send email to the passenger's email address
        String recipient = emailpCol.getText();
        String subject = "Confirmation de réservation";
        String body = "Bonjour " + prenompCol.getText() + ", votre réservation a été confirmée.";
        //SendMail.send(recipient, subject, body);
        SendMail mailer = new SendMail();
        mailer.send(recipient, subject, body);

    } catch (Exception e) {
        System.out.println("Failed to send email: " + e.getMessage());
    }
    
    afficherPassagers();


            // Clear text fields
            nompCol.clear();
            prenompCol.clear();
            numpCol.clear();
            adressepCol.clear();
            emailpCol.clear();
             tableview.setItems(FXCollections.observableArrayList(PassagerList));
             
             
           

    }

   @FXML
    private void DeletePassager(ActionEvent event) {
        Passager Passager = tableview.getSelectionModel().getSelectedItem();
        if (Passager != null) {
        try {
        // Delete the selected Passager from the database
        PassagerService sc = new PassagerService();
        sc.supprime(Passager);
        // Remove the selected Passager from the table view
        PassagerList.remove(Passager);
        tableview.setItems(FXCollections.observableArrayList(PassagerList));
        } catch (SQLException ex) {
        Logger.getLogger(menuJavaController.class.getName()).log(Level.SEVERE, null, ex);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + ex.getMessage());
        alert.showAndWait();
        }
        }
        }

@FXML
private void handlePdfButtonAction(ActionEvent event) throws FileNotFoundException, DocumentException {
    // Créer un objet Document avec une taille de page A4
    Document document = new Document(PageSize.A4);

    // Ouvrir un nouveau document avec un flux de sortie
    PdfWriter.getInstance(document, new FileOutputStream("passagers.pdf"));

    // Ouvrir le document
    document.open();

    // Ajouter un titre au document
    Paragraph title = new Paragraph("Liste des passagers");
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);

    // Ajouter un tableau pour afficher les données des passagers
    PdfPTable table = new PdfPTable(5); // 5 colonnes pour nom, prénom, numéro, adresse, email

    // Ajouter des en-têtes de colonne au tableau
    table.addCell("Nom");
    table.addCell("Prénom");
    table.addCell("Numéro");
    table.addCell("Adresse");
    table.addCell("Email");

    // Ajouter les données des passagers au tableau
    for (Passager passager : PassagerList) {
        table.addCell(passager.getNomp());
        table.addCell(passager.getPrenomp());
        table.addCell(passager.getNump());
        table.addCell(passager.getAdressep());
        table.addCell(passager.getEmailp());
    }

    // Ajouter le tableau au document
    document.add(table);

    // Fermer le document
    document.close();
}
private void trierParNom() {
    Comparator<Passager> compareByNomp = Comparator.comparing(Passager::getNomp);
    SortedList<Passager> sortedData = new SortedList<>(FXCollections.observableArrayList(PassagerList), compareByNomp);
    tableview.setItems(sortedData);
    }
private void trierParPrenom() {
    Comparator<Passager> compareByPrenomp = Comparator.comparing(Passager::getPrenomp);
    SortedList<Passager> sortedData = new SortedList<>(FXCollections.observableArrayList(PassagerList), compareByPrenomp);
    tableview.setItems(sortedData);
    }
    
    
}