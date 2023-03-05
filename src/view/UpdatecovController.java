package view;

import Entite.Covoiturage;
import Services.ServiceCovoiturage;
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
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UpdatecovController implements Initializable {

    @FXML
    private TextField cov_idcov;
    @FXML
    private TextField cov_depart;
    @FXML
    private TextField cov_dest;
    @FXML
    private TextField cov_date;
    @FXML
    private TextField cov_prix;
    @FXML
    private TextField cov_nbr;
    @FXML
    private TextField cov_vehicule;

    private Covoiturage covoiturage;
    private ListView<Covoiturage> mylistview;

    public void setCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
        cov_idcov.setText(String.valueOf(covoiturage.getId_cov()));
        cov_depart.setText(covoiturage.getDepart());
        cov_dest.setText(covoiturage.getDestination());
        cov_date.setText(covoiturage.getDate_covoiturage());
        cov_prix.setText(String.valueOf(covoiturage.getPrix()));
        cov_nbr.setText(String.valueOf(covoiturage.getNbrplace()));
        cov_vehicule.setText(covoiturage.getVehicule());
    }

    public void setMylistview(ListView<Covoiturage> mylistview) {
        this.mylistview = mylistview;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void onmodif(ActionEvent event) throws SQLException {
        String depart = cov_depart.getText();
        String destination = cov_dest.getText();
        String date = cov_date.getText();
        int nbrplace = Integer.parseInt(cov_nbr.getText());
        int prix = Integer.parseInt(cov_prix.getText());
        int id_cov = Integer.parseInt(cov_idcov.getText());
        String vehicule = cov_vehicule.getText();

        Covoiturage c = new Covoiturage(id_cov, 1, depart, destination, date, prix, nbrplace, vehicule);
        // a refaire
        ServiceCovoiturage sc = new ServiceCovoiturage();
        sc.update(c);
        mylistview.getItems().set(mylistview.getItems().indexOf(covoiturage), c);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Modification réussie");
        alert.setHeaderText(null);
        alert.setContentText("Le covoiturage a été modifié avec succès !");
        alert.showAndWait();
    }

}
