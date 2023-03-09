/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestreclamationreview;

import Entite.Assurance;
import Entite.Reclamation;
import Services.ServiceAssurance;
import Services.ServiceReclamation;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

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













/////////

import java.net.URL;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import static org.apache.commons.lang3.time.FastDateParserSDFTest.data;
import Entite.Assurance;
import GUI.gestpaiement.DisplayController;
import Services.ServiceAssurance;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import static org.apache.commons.lang3.time.FastDateParserSDFTest.data;

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class AllController implements Initializable {
    
    
    
      @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button Display;


    @FXML
    private Button Search;

    @FXML
    private Button Update;

    private Pane panesta;
     private ObservableList<Reclamation>Liste;
    
    
    
    

    @FXML
    private Pane pane2;
    
   

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;
     @FXML
    private Button btt;

    @FXML
    private Label lbidc;

    @FXML
    private Label lbdate;

    @FXML
    private Label lbdes;

    @FXML
    private Label lbnomr;


    

    @FXML
    private Pane panesta0;
    @FXML
    private Pane pane1;
    @FXML
    private Label lbrec;
    @FXML
    private Label lbrec1;
    @FXML
    private Label lbdes1;
    @FXML
    private Label lbdate1;
    @FXML
    private Label lbnomr1;
    @FXML
    private TextField tfnomr2;
    @FXML
    private Button btsup;
    @FXML
    private ListView<Reclamation> idtable;
    @FXML
    private Label lbnomr3;
    @FXML
    private Label lbnomr4;
    @FXML
    private Button btcher;
    @FXML
    private TextField tfdes1;
    @FXML
    private TextField tfnomr1;
    @FXML
    private TextField tfidc1;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private Button btt2;
    @FXML
    private TextField tfdes2;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private TextField tfnomr3;
    @FXML
    private TextField tfnomr4;
    @FXML
    private ImageView afficher;
     //@FXML
    //private ListView<Reclamation> idtable;
    @FXML
    private ListView<Reclamation> idtable1;
    @FXML
    private Button afficherrec;
    @FXML
    private Button pdf;
  



    /**
     * Initializes the controller class.
     
     */
 
    
    @FXML
    public void handleClick(ActionEvent event){
        System.out.println("HELLOOOOO");
    if (event.getSource()==Add ){
       // LBL1.setText("ADD");
        pane1.toFront();
      
       

    }
    else if (event.getSource()==Update ){
       // LBL1.setText("Update");
        pane2.toFront();
       
    }
    else if (event.getSource()==Delete ){
       // LBL1.setText("DELETE");
        pane3.toFront();
    }
    else if (event.getSource()==Search ){
        //LBL1.setText("SEARCH");
       
        pane4.toFront();
    }
    else if (event.getSource()==Display ){
    //    LBL1.setText("DISPLAY");
      
        pane5.toFront();
    } 
    }
     @FXML
    public void Add(ActionEvent event) {
        
       
 try {
            String description = tfdes1.getText().trim();
            LocalDate date = datePicker1.getValue();
            String nomr = tfnomr1.getText().trim();
            int id_compte = Integer.parseInt(tfidc1.getText().trim());

            // Vérification et conversion de la saisie pour l'identifiant du compte

            // Vérification de la validité de la description
           if (description.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La description ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Vérification de la validité de la date
            if (date == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("La date ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Vérification de la validité de la nom
            if (nomr.isEmpty()) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Erreur de saisie");
                alert.setHeaderText(null);
                alert.setContentText("Le nom ne peut pas être vide !");
                alert.showAndWait();
                return;
            }

            // Création de la réclamation
            Reclamation r = new Reclamation(description, date.toString(), nomr, id_compte);
            ServiceReclamation sr = new ServiceReclamation();
            sr.ajouter(r);

            // Nettoyage des champs de saisie
            tfdes1.clear();
            datePicker1.setValue(null);
            tfnomr1.clear();
            tfidc1.clear();
            System.out.println("Reclamation ajoutée dans la base de données.");
        } catch (SQLException e) {
            // Affichage d'une erreur inattendue (par exemple, erreur de connexion à la base de données)
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText(null);
            alert.setContentText("Une erreur s'est produite !");
            alert.showAndWait();
        }
      


    /**
     * Initializes the controller class.
     */
      
    
}
    
    
  @FXML
    public void Update (ActionEvent event) throws SQLException {
        
        
        String nom=tfnomr2.getText();
        String desc= tfdes2.getText();
                
        // Vérification que les champs obligatoires sont remplis
        if (tfnomr2.getText().isEmpty() || tfdes2.getText().isEmpty() || datePicker2.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
            return;
        }

        // Création de l'objet Reclamation avec les valeurs saisies
        LocalDate date = datePicker2.getValue();
        Reclamation r = new Reclamation(desc, date.toString(), nom);
        tfnomr2.clear();
        tfdes2.clear();

        // Envoi de la réclamation au service de réclamation pour mise à jour
        ServiceReclamation sr = new ServiceReclamation();
        sr.update(r);
    }
    @FXML
    public void Delete (ActionEvent event) throws SQLException {
        
        
        try {
    // Vérifier si l'utilisateur a entré une chaine de caracrtere
    if (tfnomr3.getText().matches("^[a-zA-Z]+$")) {
        String nomr = tfnomr3.getText();

        Reclamation c = new Reclamation("", "", nomr, 0);
        // Supprimer la réclamation de la base de données
        ServiceReclamation sr = new ServiceReclamation();
        sr.supprime(c);
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre entier pour l'ID de réclamation.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerrecController.class.getName()).log(Level.SEVERE, null, ex);
}

        
        
    }


    @FXML
    public void Search (ActionEvent event) throws SQLException {
        
   try {
    // Vérifier si l'utilisateur a entré une chaine de caracrtere
    if (tfnomr4.getText().matches("^[a-zA-Z]+$")) {
        String nomr = tfnomr4.getText();

        // Supprimer la réclamation de la base de données
        ServiceReclamation sr = new ServiceReclamation();
        sr.findByName(nomr);
    } else {
        // Afficher un message d'erreur si l'utilisateur n'a pas entré un entier valide
        JOptionPane.showMessageDialog(null, "champs invalide.");
    }
} catch (SQLException ex) {
    Logger.getLogger(SupprimerrecController.class.getName()).log(Level.SEVERE, null, ex);
}
 ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
         System.out.println(ctab);
         ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
      idtable.setItems(r);
  
        
        
        
    
    }
    /*public void afficherReclamation () throws SQLException {
        
         ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
        System.out.println(ctab);
        ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
        idtable1.setItems(r);
 
    }*/


    



    
      @Override
      public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }


    @FXML
    private void afficherrec(ActionEvent event) throws SQLException {
         ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
        System.out.println(ctab);
        ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
        idtable1.setItems(r);
    }

    @FXML
    private void printpdf(ActionEvent event) {
         
    try {
        ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> data = sc.readAll();
        // Create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("reclamation.pdf"));
        document.open();

      // Create a table with four columns
PdfPTable table = new PdfPTable(2);

// Add table headers
table.addCell("nom");
table.addCell("description");


// Add the information of all sponsors to the table
for (Reclamation s : data) {
    table.addCell(s.getNomr().toString());
    table.addCell(s.getDescription().toString());

}

// Add the table to the document
document.add(table);

        document.close();

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Impression réussie");
        alert.setContentText("La liste des reclamation a été imprimée avec succès.");
        alert.showAndWait();
    } catch (Exception e) {
        // Show an error message if an exception occurs
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'impression");
        alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des recamation.");
        alert.showAndWait();
    }
    }
        
     
    }    
 
        





  










