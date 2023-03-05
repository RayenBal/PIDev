package GUI;

import Entite.Chauffeur;
import Services.ServiceChauffeur;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class AfficherChauffeurController implements Initializable {

    @FXML
    private ListView<Chauffeur> idtable;
    @FXML
    private Button buttonab;
    @FXML
    private Button buttonretour;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void AfficherChauffeur(ActionEvent event) {
        try {
            ServiceChauffeur sc = new ServiceChauffeur();
            List<Chauffeur> ctab = sc.readAll();
            System.out.println(ctab);
            ObservableList<Chauffeur> Chauffeur = FXCollections.observableArrayList(ctab);
            idtable.setItems(Chauffeur);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    private void retour(ActionEvent event) {
        Stage stage = (Stage) buttonretour.getScene().getWindow();
        stage.close();
    }
}
