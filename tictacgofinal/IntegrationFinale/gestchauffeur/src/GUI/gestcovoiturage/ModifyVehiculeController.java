package GUI.gestcovoiturage;

import Entite.Vehicule;
import Services.ServiceVehicule;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ModifyVehiculeController implements Initializable {
    
    @FXML
    private TextField marqueField;
    @FXML
    private TextField modeleField;
    @FXML
    private TextField typeField;
    @FXML
    private TextField nbPlacesField;
    @FXML
    private Button saveButton;
    
    private ServiceVehicule serviceVehicule;
    private Vehicule selectedVehicule;
    @FXML
    private TextField immatriculationField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceVehicule = new ServiceVehicule();
    }
    
    public void initData(Vehicule vehicule) {
        selectedVehicule = vehicule;
        marqueField.setText(selectedVehicule.getMarque());
        modeleField.setText(selectedVehicule.getModele());
        typeField.setText(selectedVehicule.getType());
        nbPlacesField.setText(Integer.toString(selectedVehicule.getNb_places()));
    }
    
    private void saveButton(ActionEvent event) {
        try {
            String marque = marqueField.getText().trim();
            String modele = modeleField.getText().trim();
            String type = typeField.getText().trim();
            String nbPlacesStr = nbPlacesField.getText().trim();
            
            if (marque.isEmpty() || modele.isEmpty() || type.isEmpty() || nbPlacesStr.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setContentText("Please fill all the fields");
                alert.showAndWait();
                return;
            }
            
            int nbPlaces = Integer.parseInt(nbPlacesStr);
            
            selectedVehicule.setMarque(marque);
            selectedVehicule.setModele(modele);
            selectedVehicule.setType(type);
            selectedVehicule.setNb_places(nbPlaces);
            
            serviceVehicule.update_vehicule(selectedVehicule);
            System.out.println("Vehicule updated: " + selectedVehicule);
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setContentText("Vehicule updated successfully");
            alert.showAndWait();
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Please enter a valid number for the number of places");
            alert.showAndWait();
        } catch (SQLException ex) {
            Logger.getLogger(ModifyVehiculeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    boolean isSaveClicked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Vehicule getVehicule() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setVehicule(Vehicule selectedVehicule) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
