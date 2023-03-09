package GUI2;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entites.Destination;
import entites.Passager;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import service.PassagerService;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.ServiceDestination;
import utils.SendMail;

public class  MenuuJavaController implements Initializable {

    @FXML
    private TableView<Destination> tableview;
  
    @FXML
    private TextField searchText;

    private ObservableList<Destination> DestinationList;

    
    @FXML
    private Button button77;
    @FXML
    private Button btnA;
    @FXML
    private Button btnD;

    @FXML
    private TableColumn<Destination, String> adresseColumn;
  
    @FXML
    private Button btnPDF;
    @FXML
    private TableColumn<Destination, String> gouvernoratColumn;
    @FXML
    private TextField gouvernoratCol;
    @FXML
    private TextField adresseCol;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherDestinations();
      
        
        
    }

    private void afficherDestinations() {
        try {
            ServiceDestination sc = new ServiceDestination();
            List<Destination> ctab = sc.readAll();
            DestinationList = FXCollections.observableArrayList(ctab);
            gouvernoratColumn.setCellValueFactory(new PropertyValueFactory<>("gouvernorat"));
            adresseColumn.setCellValueFactory(new PropertyValueFactory<>("adressed"));
        
         
            tableview.setItems(DestinationList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
        tableview.setItems(DestinationList);
        FilteredList<Destination> filteredData = new FilteredList<>(FXCollections.observableList(DestinationList));
        tableview.setItems(filteredData);
        searchText.textProperty().addListener((observable, oldValue, newValue) ->
        filteredData.setPredicate(createPredicate(newValue)));
    }

  
    //recherche
     /////// recherche
    private boolean searchFindsOrder(Destination snc, String searchText){
    return (snc.getGouvernorat().toLowerCase().contains(searchText.toLowerCase())) ||
            (snc.getAdressed().toLowerCase().contains(searchText.toLowerCase()));
           
}
    private ObservableList<Destination> filterList(List<Destination> list, String searchText){
    List<Destination> filteredList = new ArrayList<>();
    for (Destination seancer : list){
        if(searchFindsOrder(seancer, searchText)) filteredList.add(seancer);
    }
    return FXCollections.observableList(filteredList);
}
    private Predicate<Destination> createPredicate(String searchText){
    return seance -> {
        if (searchText == null || searchText.isEmpty()) return true;
        return searchFindsOrder(seance, searchText);
    };
    }

    @FXML
    private void handleTableViewMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 1) { // vérifie si l'utilisateur a cliqué une seule fois
        Destination Destination = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Passager de la ligne sélectionnée
        gouvernoratCol.setText(Destination.getGouvernorat()); // affiche les données dans les TextFields
        adresseCol.setText(Destination.getAdressed());

    }

        
    }

    @FXML
    private void UpdateDestination(ActionEvent event) {
    Destination Destination = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Passager de la ligne sélectionnée
    
    Destination.setGouvernorat(gouvernoratCol.getText()); // met à jour le nom
    Destination.setAdressed(adresseCol.getText()); // met à jour le prénom
    try {
        ServiceDestination sc = new ServiceDestination();
        sc.update(Destination); // met à jour les données du Passager dans la base de données
        afficherDestinations(); // actualise la table des Passagers
    } catch (SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + e.getMessage());
        alert.showAndWait();
    }
}


    @FXML
    private void ajouterDestination(ActionEvent event) throws SQLException {
     String gouvernorat = gouvernoratCol.getText();
        String adressed = adresseCol.getText();

        // Validate input
        if (gouvernorat.isEmpty() || adressed.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required.");
            alert.showAndWait();
            return;
        }
 
       
        Destination p = new Destination(gouvernorat, adressed);
        ServiceDestination sc = new ServiceDestination();
        
            sc.ajouter(p);
           
    
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "Destination added successfully.");
            alert.showAndWait();

            // Clear text fields
            gouvernoratCol.clear();
            adresseCol.clear();
             tableview.setItems(FXCollections.observableArrayList(DestinationList));
           

    }

   @FXML
    private void DeleteDestination(ActionEvent event) {
        Destination Destination = tableview.getSelectionModel().getSelectedItem();
        if (Destination != null) {
        try {
        // Delete the selected Passager from the database
        ServiceDestination sc = new ServiceDestination();
        sc.supprime(Destination);
        // Remove the selected Passager from the table view
        DestinationList.remove(Destination);
        tableview.setItems(FXCollections.observableArrayList(DestinationList));
        } catch (SQLException ex) {
        Logger.getLogger(MenuuJavaController.class.getName()).log(Level.SEVERE, null, ex);
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
    PdfWriter.getInstance(document, new FileOutputStream("destinations.pdf"));

    // Ouvrir le document
    document.open();

    // Ajouter un titre au document
    Paragraph title = new Paragraph("Liste des destinations");
    title.setAlignment(Element.ALIGN_CENTER);
    document.add(title);

    // Ajouter un tableau pour afficher les données des passagers
    PdfPTable table = new PdfPTable(5); // 5 colonnes pour nom, prénom, numéro, adresse, email

    // Ajouter des en-têtes de colonne au tableau
    table.addCell("Gouvernorat");
    table.addCell("Adresse");

    // Ajouter les données des passagers au tableau
    for (Destination Destination : DestinationList) {
        table.addCell(Destination.getGouvernorat());
        table.addCell(Destination.getAdressed());
    }

    // Ajouter le tableau au document
    document.add(table);

    // Fermer le document
    document.close();
}
    
}