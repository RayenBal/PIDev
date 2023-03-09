package GUI.gestcovoiturage;

import Entite.Covoiturage;
import Services.ServiceCovoiturage;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;


public class SelectcovControllerBack implements Initializable {

    @FXML
    private ListView<Covoiturage> mylistview;
    
    @FXML
    private Button filterField;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceCovoiturage sc = new ServiceCovoiturage();

            List<Covoiturage> data = sc.readAll();

            FilteredList<Covoiturage> filteredData = new FilteredList<>(FXCollections.observableList(data), p -> true);

            mylistview.setItems(filteredData);

     mylistview.setCellFactory((ListView<Covoiturage> lv) -> new ListCell<Covoiturage>() {
    private HBox hbox = new HBox();
    private Label departure = new Label();
    private Label arrival = new Label();
    private Label price = new Label();
    private Label hour = new Label();
    private Label nbPlacesLabel = new Label("Places disponibles :");
    private Label nbPlaces = new Label();
    private Button editButton = new Button("Modifier");
    private Button deleteButton = new Button("Supprimer");
    private Button reserveButton = new Button("Réserver");
    
    {
        hbox.getChildren().addAll(departure, new Label(" -> "), arrival, price, hour, nbPlacesLabel, nbPlaces, editButton, deleteButton, reserveButton);
        hbox.setSpacing(10);
        editButton.setOnAction(event -> {
            // handle edit button action
            Covoiturage covoiturage = getItem();
            // open a new view to edit the covoiturage
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Updatecov.fxml"));
                Parent root = fxmlLoader.load();
                UpdatecovController editCovController = fxmlLoader.getController();
                editCovController.setCovoiturage(covoiturage);
                
                editCovController.setMylistview(mylistview);
                mylistview.getScene().setRoot(root);
            } catch (IOException ex) {
                Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        deleteButton.setOnAction(event -> {
            // handle delete button action
            Covoiturage covoiturage = getItem();
            try {
                sc.supprime(covoiturage); // delete from database
            } catch (SQLException ex) {
                Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mylistview.getItems().remove(covoiturage); // remove from ListView
        });

        reserveButton.setOnAction(event -> {
            Covoiturage covoiturage = getItem();
            if(covoiturage.getNbrplace() > 0){
                covoiturage.setNbrplace(covoiturage.getNbrplace() - 1);
                try {
                    sc.update(covoiturage); // update database
                   
                } catch (SQLException ex) {
                    Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
                }
                nbPlaces.setText(String.valueOf(covoiturage.getNbrplace())); // update ListView
            }else{
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Impossible");
                alert.setHeaderText("Le covoiturage est complet");
                alert.setContentText("Il n'y a plus de places disponibles pour ce covoiturage.");
                alert.showAndWait();
            }
        });
    }

    @Override
    protected void updateItem(Covoiturage covoiturage, boolean empty) {
        super.updateItem(covoiturage, empty);
        if (empty || covoiturage == null) {
            setText(null);
            setGraphic(null);
        } else {
            departure.setText(covoiturage.getDepart());
            arrival.setText(covoiturage.getDestination());
            hour.setText(covoiturage.getDate_covoiturage());
            price.setText(covoiturage.getPrix() + " dt");
            nbPlaces.setText(String.valueOf(covoiturage.getNbrplace()));
            setText(null);
            setGraphic(hbox);
            // apply styles
            departure.getStyleClass().add("label");
            arrival.getStyleClass().add("label");
            hour.getStyleClass().add("text");
            nbPlacesLabel.getStyleClass().add("label");
            nbPlaces.getStyleClass().add("text");
            price.getStyleClass().add("text");
            editButton.getStyleClass().add("button");
            deleteButton.getStyleClass().add("button");
        }
    }

                private void notifyUser(String message) {
                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void retour_ajout(ActionEvent event) {

    }
 
    @FXML
private Button printButton;

@FXML
private void handlePrint(ActionEvent event) {
printCovoiturages();
}

    private void printCovoiturages() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    try {
        ServiceCovoiturage sc = new ServiceCovoiturage();
        List<Covoiturage> data = sc.readAll();

        // Create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("covoiturages.pdf"));
        document.open();

      // Create a table with four columns
PdfPTable table = new PdfPTable(4);

// Add table headers
table.addCell("Prix");
table.addCell("Nombre de places");
table.addCell("Depart");
table.addCell("Arrivée");

// Add the information of all sponsors to the table
for (Covoiturage s : data) {
    table.addCell(Float.toString(s.getPrix()));
    table.addCell(s.getNbrplace() + " PLaces dispo");
    table.addCell(s.getDepart().toString());
    table.addCell(s.getDestination().toString());

}

// Add the table to the document
document.add(table);

        document.close();

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Impression réussie");
        alert.setContentText("La liste des covoiturages a été imprimée avec succès.");
        alert.showAndWait();
    } catch (Exception e) {
        // Show an error message if an exception occurs
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'impression");
        alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des covoiturages.");
        alert.showAndWait();
    }
    }



}
