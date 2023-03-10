/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import Entite.Compte;
import java.util.Properties;  
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import Services.ServiceCompte;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;
import java.sql.*;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class SignInController implements Initializable {
    
    
    private Statement ste;
     @FXML
    private Button bttsign;

    @FXML
    private Label lbemail;

    @FXML
    private Label lbmp;

    @FXML
    private Label lbsign;

    @FXML
    private TextField tfemail;

    @FXML
    private TextField tfmp;

    @FXML
    private Button mdp;
    
     @FXML
    void TestLogin(ActionEvent event) throws SQLException, IOException {
         if (event.getSource().equals(bttsign)){
             String EmailS = tfemail.getText();
            String PasswordS = tfmp.getText();
             
            SignIn dao = new SignIn();
            boolean isValid = dao.checkCredentials(EmailS, PasswordS);
            
            
             if (!isValid)
             {
             Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Error");
            a.setContentText("Email or password are incorrect");
            a.setHeaderText("Warning!");
            a.showAndWait();
             }
             else 
             {
          Alert a = new Alert(Alert.AlertType.INFORMATION);
           a.setTitle("Success");
           a.setContentText("Login Succesful!");
            a.setHeaderText("Success!");
          a.showAndWait();
            
                   FXMLLoader loader = new FXMLLoader(getClass().getResource("SignIn.fxml"));
                   Parent root = loader.load();
                   SignInController ai=loader.getController();
                   ServiceCompte PS=new ServiceCompte();
                   //int ID= PS.getCurrentParentID(tfemail.getText(), tfmp.getText());
                  // AdminServiceA as=new AdminServiceA();
                 // ParentP pe= as.finById(ID);
                 //  ai.setData(pe);
                    Stage stage =new Stage();
                    stage.setTitle("Second Window");
                    stage.setScene(new Scene(root));
                    stage.show();
                   
    
             }
              

   
    }

    
}
     @FXML
void mdpOub(ActionEvent event) throws SQLException, IOException{
    String email = tfemail.getText();
    ServiceCompte sc = new ServiceCompte();
    String pass = sc.findByEmail(email);

    // Send password reset email
    Properties props = new Properties();
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.mail.yahoo.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    String username = "mohamedrayendhraief@yahoo.fr";
    String password = "yxzghjnvgpqvnwhx";
    Session session = Session.getInstance(props,
        new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("R??initialisation de mot de passe");
        message.setText("Bonjour,\n\n"
            + "Vous avez oubli?? votre mot de passe. Voici votre mot de passe : " + pass + "\n\n"
            + "Cordialement,\n"
            + "L'??quipe de support");

        Transport.send(message);
        System.out.println("Le message a ??t?? envoy?? avec succ??s.");
    } catch (MessagingException e) {
        System.out.println("Erreur lors de l'envoi du message : " + e.getMessage());
    }
}

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
}