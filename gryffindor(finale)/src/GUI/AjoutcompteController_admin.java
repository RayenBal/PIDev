
package GUI;

import Entite.Compte;
import Services.ServiceCompte;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import com.mysql.cj.jdbc.Driver;
import java.io.BufferedReader;
import javafx.scene.control.Label;
import javax.swing.JOptionPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;


public class AjoutcompteController_admin implements Initializable {


    @FXML
    private TextField tfemail;


    @FXML
    private TextField tfmp;

    @FXML
    private TextField tfnom;

    @FXML
    private RadioButton pass;

    @FXML
    private Label lbsign;

    @FXML
    private Label lbnom;
    
      @FXML
    private Label lbmp;
    @FXML
    private Label lbemail;
    @FXML
    private Label lbtype;
    @FXML
    private Button bttsign;
    @FXML
    private RadioButton chauf;
    @FXML
    private Button backToSignIn;
    @FXML
    private Label label;
    @FXML
    private Button retour;
    @FXML
    private Label label1;
   
    
  
    @FXML
    private void Save(ActionEvent event) {
        try {
    String type = pass.isSelected() ? "passager" : "chauffeur";
    String nom = tfnom.getText();
    String email = tfemail.getText();
    String mp = tfmp.getText();

    // Vérifier que le nom ne contient que des lettres et des espaces
    if (!nom.matches("[a-zA-Z ]+")) {
        JOptionPane.showMessageDialog(null, "Le nom ne doit contenir que des lettres et des espaces.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier que l'email est valide
    if (!email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")) {
        JOptionPane.showMessageDialog(null, "L'email n'est pas valide.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Vérifier que le mot de passe contient au moins 8 caractères et au moins une lettre et un chiffre
    if (!mp.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")) {
        JOptionPane.showMessageDialog(null, "Le mot de passe doit contenir au moins 8 caractères, dont au moins une lettre et un chiffre.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
        return;
    }

    Compte c = new Compte(type, nom, email, mp);
    ServiceCompte sc = new ServiceCompte();
    sc.ajouter(c);

    tfnom.clear();
    tfemail.clear();
    tfmp.clear();
    JOptionPane.showMessageDialog(null, "Compte ajouté dans la base de données.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
} catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "L'identifiant doit être un nombre entier positif.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
} 


    }
    


    
   @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void backToSignIn(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SignInController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/Testback.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   

}
 /* String type = pass.isSelected() ? "passager" : "chauffeur";
    String nom = tfnom.getText();
    String email = tfemail.getText();
    String mp = tfmp.getText();
    String idText = tfhist.getText();
     int id = Integer.parseInt(idText);
        try {
    CreatedUser createdUser = auth.createUser(type, nom,email, mp)
        .setConnection("Username-Password-Authentication")
        .execute();
    // Create the account in the local database
    Compte c = new Compte(type, nom, email, mp, id);
    ServiceCompte sc = new ServiceCompte();
    sc.ajouter(c);
    tfnom.clear();
    tfemail.clear();
    tfmp.clear();
    tfhist.clear();
    JOptionPane.showMessageDialog(null, "Compte ajouté dans la base de données.", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
}catch (SQLException e) {
    // Handle any errors from the local database
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
}
        // Handle any errors from the Auth0 API
         catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "L'identifiant doit être un nombre entier positif.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, "Erreur : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);
}*/
