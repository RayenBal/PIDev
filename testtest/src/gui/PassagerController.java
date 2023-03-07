/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Passager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.Notifications;
import service.PassagerService;
import utils.SendMail;


/**
 * FXML Controller class
 *
 * @author medzr
 */
public class PassagerController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txtemail;
    @FXML
    private Button btnA;
    @FXML
    private ImageView homeicon;
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
/*
    @FXML
    private void Add(ActionEvent event) throws SQLException {
        Passager p = new Passager();
        p.setNomp(txtnom.getText());
        p.setPrenomp(txtprenom.getText());
        p.setNump(txtnum.getText());
        p.setAdressep(txtadresse.getText());
        p.setEmailp(txtemail.getText());
        PassagerService ps=new PassagerService();
        ps.ajouter(p);
        System.out.println(p);
        
        
    }*/
    
    @FXML
private void Add(ActionEvent event) throws SQLException {
    String nom = txtnom.getText();
    String prenom = txtprenom.getText();
    String num = txtnum.getText();
    String adresse = txtadresse.getText();
    String email = txtemail.getText();
    
    // Vérification de la saisie
    if (nom.trim().isEmpty() || prenom.trim().isEmpty() || num.trim().isEmpty() || adresse.trim().isEmpty() || email.trim().isEmpty()) {
         Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Champ(s) vide(s)");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }
    // Vérification de la longueur du numéro de téléphone
    if (!num.matches("\\d{8}")) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Numéro de téléphone invalide");
        alert.setHeaderText(null);
        alert.setContentText("Le numéro de téléphone doit être composé de 8 chiffres.");
        alert.showAndWait();
        return;
    }
    Passager p = new Passager();
    p.setNomp(nom);
    p.setPrenomp(prenom);
    p.setNump(num);
    p.setAdressep(adresse);
    p.setEmailp(email);
    PassagerService ps=new PassagerService();
    ps.ajouter(p);
    System.out.println(p);
            Notifications.create()
              .title("Passager ajouté avec succées")
              .text("Merci ! ")
              .showWarning();
        System.out.println(p);
    SendMail.send("mohamedachraf.zribi@esprit.tn", "Bienvenue", "bonjour");
}

    @FXML
    private void retour(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) homeicon.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

        
}
