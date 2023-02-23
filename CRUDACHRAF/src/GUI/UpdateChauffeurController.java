/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entite.Chauffeur;
import Services.ServiceChauffeur;
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

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class UpdateChauffeurController implements Initializable {

    @FXML
    private TextField ucase2;
    @FXML
    private TextField ucase3;
    @FXML
    private TextField ucase4;
    @FXML
    private TextField ucase5;
    @FXML
    private TextField ucase1;
    @FXML
    private Button button77;
    @FXML
    private TextField ucase6;
    @FXML
    private TextField ucase7;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
 private void UpdateChauffeur(ActionEvent event) {
    try {
        String idcStr = ucase1.getText();
        String nomc = ucase2.getText();
        String prenomc = ucase3.getText();
        String numc = ucase4.getText();
        String adressec = ucase5.getText();
        String emailc = ucase6.getText();
        String iddStr = ucase7.getText();

        if (idcStr.isEmpty() || nomc.isEmpty() || prenomc.isEmpty() || numc.isEmpty() || adressec.isEmpty() || emailc.isEmpty() || iddStr.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("All fields are required.");
            alert.showAndWait();
            return;
        }

        if (!idcStr.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("ID Chauffeur should be a number.");
            alert.showAndWait();
            return;
        }

        int idc = Integer.parseInt(idcStr);

        if (!iddStr.matches("\\d+")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("ID Dispatch should be a number.");
            alert.showAndWait();
            return;
        }

        int idd = Integer.parseInt(iddStr);

        if (!emailc.matches(".+@.+\\.com")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Email should be in the format of 'example@example.com'.");
            alert.showAndWait();
            return;
        }

        Chauffeur c = new Chauffeur(idc, nomc, prenomc, numc, adressec, emailc, idd);
        ServiceChauffeur sc = new ServiceChauffeur();
        sc.update(c);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Chauffeur updated successfully.");
        alert.showAndWait();

        // Empty all text fields
        ucase1.clear();
        ucase2.clear();
        ucase3.clear();
        ucase4.clear();
        ucase5.clear();
        ucase6.clear();
        ucase7.clear();

    } catch (SQLException ex) {
        Logger.getLogger(UpdateChauffeurController.class.getName()).log(Level.SEVERE, null, ex);
    }
}



}
