package GUI2;



import Entite.infotrafic;
import Services.ServiceChauffeur;
import Services.ServiceInfotrafic;

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

public class AfficherInfotraficController implements Initializable {
@FXML
    private TableView<infotrafic> tableview;

    @FXML
    private TextField searchText;
    private ObservableList<infotrafic> chauffeurList;

    private ObservableList<infotrafic> infotraficList;
    @FXML
    private TableColumn<infotrafic, String> typeColumn;
    @FXML
    private TableColumn<infotrafic, String> descriptionColumn;
    @FXML
    private TableColumn<infotrafic, String> idcColumn;
    @FXML
    private TextField Ctype;
    @FXML
    private TextField Cdescription;
    @FXML
    private TextField Cidc;
    @FXML
    private Button btnA;
    @FXML
    private Button button77;
    @FXML
    private Button btnD;
  // Twilio account SID and auth token
    public static final String ACCOUNT_SID = "AC7820afe394dbafb7a218a18b491c5c07";
    public static final String AUTH_TOKEN = "c1dc4b87078529383977c6dc59704523";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+12706759631";
    public static final String RECIPIENT_PHONE_NUMBER = "+21695411518";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        afficherInfotrafics();
        
        
    }

    private void afficherInfotrafics() {
        try {
            ServiceInfotrafic sc = new ServiceInfotrafic();
            List<infotrafic> ctab = sc.readAll();
            infotraficList = FXCollections.observableArrayList(ctab);
            typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
            descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
            idcColumn.setCellValueFactory(new PropertyValueFactory<>("idc"));
            tableview.setItems(infotraficList);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
        tableview.setItems(infotraficList);
        FilteredList<infotrafic> filteredData = new FilteredList<>(FXCollections.observableList(infotraficList));
        tableview.setItems(filteredData);
        searchText.textProperty().addListener((observable, oldValue, newValue) -> filteredData.setPredicate(createPredicate(newValue)));
    }

 

 
    
    //recherche
     /////// recherche
    private boolean searchFindsOrder(infotrafic snc, String searchText){
    return (snc.getType().toLowerCase().contains(searchText.toLowerCase())) ||
            (snc.getDescription().toLowerCase().contains(searchText.toLowerCase())) ||
            Integer.toString(snc.getIdc()).equals(searchText.toLowerCase());
}
    private ObservableList<infotrafic> filterList(List<infotrafic> list, String searchText){
    List<infotrafic> filteredList = new ArrayList<>();
    for (infotrafic seancer : list){
        if(searchFindsOrder(seancer, searchText)) filteredList.add(seancer);
    }
    return FXCollections.observableList(filteredList);
}
    private Predicate<infotrafic> createPredicate(String searchText){
    return seance -> {
        if (searchText == null || searchText.isEmpty()) return true;
        return searchFindsOrder(seance, searchText);
    };
    }

    @FXML
    private void handleTableViewMouseClicked(MouseEvent event) {
        if (event.getClickCount() == 1) { // vérifie si l'utilisateur a cliqué une seule fois
        infotrafic i = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Chauffeur de la ligne sélectionnée
        Ctype.setText(i.getType()); // affiche les données dans les TextFields
        Cdescription.setText(i.getDescription());
        Cidc.setText(Integer.toString(i.getIdc()));
        
    }
    }

    @FXML
    private void ajouterInfotrafic(ActionEvent event) throws SQLException {
        String type = Ctype.getText();
        String description = Cdescription.getText();
        String idcc = Cidc.getText();

        // Validate input
        if (type.isEmpty() || description.isEmpty() || idcc.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "All fields are required.");
            alert.showAndWait();
            return;
        }

        int idc = Integer.parseInt(idcc);
        infotrafic c = new infotrafic(type, description, idc);
        ServiceInfotrafic sc = new ServiceInfotrafic();
        
            sc.ajouter(c);
            tableview.setItems(FXCollections.observableArrayList(infotraficList));
     
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION, "infotrafic added successfully.");
            alert.showAndWait();

            // Clear text fields
            Ctype.clear();
            Cdescription.clear();
            Cidc.clear();

        
    }

    @FXML
    private void UpdateInfotrafic(ActionEvent event) {
            infotrafic i = tableview.getSelectionModel().getSelectedItem(); // récupère l'objet Chauffeur de la ligne sélectionnée
    
    i.setType(Ctype.getText()); // met à jour le nom
    i.setDescription(Cdescription.getText()); // met à jour le prénom
    i.setIdc(Integer.parseInt(Cidc.getText())); // met à jour l'identifiant de destination
    
    try {
        ServiceInfotrafic sc = new ServiceInfotrafic();
        sc.update(i); // met à jour les données du chauffeur dans la base de données
        afficherInfotrafics(); // actualise la table des chauffeurs
    } catch (SQLException e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + e.getMessage());
        alert.showAndWait();
    }
   
    }

    @FXML
    private void DeleteInfotrafic(ActionEvent event) {
        infotrafic i = tableview.getSelectionModel().getSelectedItem();
        if (i != null) {
        try {
        // Delete the selected chauffeur from the database
        ServiceInfotrafic sc = new ServiceInfotrafic();
        sc.supprime(i);
        // Remove the selected chauffeur from the table view
        infotraficList.remove(i);
        tableview.setItems(FXCollections.observableArrayList(infotraficList));
        } catch (SQLException ex) {
        Logger.getLogger(AfficherInfotraficController.class.getName()).log(Level.SEVERE, null, ex);
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Database Error");
        alert.setContentText("There was an error accessing the database: " + ex.getMessage());
        alert.showAndWait();
        }
        }
           

    }



    
}