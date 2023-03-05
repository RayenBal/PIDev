package view;

import Entite.Covoiturage;
import Services.ServiceCovoiturage;
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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class SelectcovController implements Initializable {

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
    
    {
        hbox.getChildren().addAll(departure, new Label(" -> "), arrival, price, hour, nbPlacesLabel, nbPlaces, editButton, deleteButton);
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
});

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void retour_ajout(ActionEvent event) {

    }
}
