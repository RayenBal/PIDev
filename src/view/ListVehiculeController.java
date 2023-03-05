package view;

import Entite.Vehicule;
import Services.ServiceVehicule;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

public class ListVehiculeController implements Initializable {

    @FXML
    private ListView<Vehicule> ListVehicules;
    @FXML
    private Button modifyButton;
    @FXML
    private Button deleteButton;

    private ServiceVehicule serviceVehicule;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            serviceVehicule = new ServiceVehicule();
            List<Vehicule> data = serviceVehicule.readAll();
            ListVehicules.getItems().addAll(data);
            ListVehicules.setCellFactory(new Callback<ListView<Vehicule>, ListCell<Vehicule>>() {
                @Override
                public ListCell<Vehicule> call(ListView<Vehicule> param) {
                    return new ListCell<Vehicule>() {
                        @Override
                        protected void updateItem(Vehicule item, boolean empty) {
                            super.updateItem(item, empty);
                            if (item != null) {
                                // Customize the appearance of the ListCell
                                setText(item.getMarque() + " " + item.getModele());
                                setGraphic(null);
                            }
                        }
                    };
                }
            });
            ListVehicules.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void ModifyButton(ActionEvent event) {
    Vehicule selectedVehicule = ListVehicules.getSelectionModel().getSelectedItem();
    if (selectedVehicule != null) {
        try {
            // Load the ModifyVehicule.fxml window
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/ModifyVehicule.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.setTitle("Modifier Véhicule");
            stage.initModality(Modality.APPLICATION_MODAL);

            // Get the controller of the ModifyVehicule window
            ModifyVehiculeController controller = loader.getController();

            // Set the initial values of the input fields
            controller.setVehicule(selectedVehicule);

            // Show the ModifyVehicule window and wait for it to close
            stage.showAndWait();

            // Update the selected vehicle object with the modified data
            if (controller.isSaveClicked()) {
                Vehicule modifiedVehicule = controller.getVehicule();
                serviceVehicule.update_vehicule(modifiedVehicule);
                selectedVehicule.setMarque(modifiedVehicule.getMarque());
                selectedVehicule.setModele(modifiedVehicule.getModele());
                selectedVehicule.setType(modifiedVehicule.getType());
                selectedVehicule.setNb_places(modifiedVehicule.getNb_places());
                ListVehicules.refresh();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}

    
    @FXML
    private void DeleteButton(ActionEvent event) {
        Vehicule selectedVehicule = ListVehicules.getSelectionModel().getSelectedItem();
        if (selectedVehicule != null) {
            try {
                serviceVehicule.supprimer_vehicule(selectedVehicule);
                ListVehicules.getItems().remove(selectedVehicule);
                System.out.println("Vehicule deleted: " + selectedVehicule);
            } catch (SQLException ex) {
                Logger.getLogger(ListVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
