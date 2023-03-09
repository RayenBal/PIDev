/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import Entite.Reclamation;
import Services.ServiceReclamation;

///////////////////////
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;

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
    private TextField tfidc;

    @FXML
    private DatePicker datePicker;

    @FXML
    private TextField tfdes;
    

    @FXML
    private TextField tfnomr;
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
    private TextField tfnomr1;
    @FXML
    private Button btt1;
    @FXML
    private Label lbnomr1;
    @FXML
    private TextField tfdes1;
    @FXML
    private DatePicker datePicker1;
    private TextField tfnomr2;
    @FXML
    private Button btsup;
    private ListView<Reclamation> idtable;
    @FXML
    private TextField tfnomr3;
    @FXML
    private Label lbnomr3;
    @FXML
    private TextField tfnomr4;
    @FXML
    private Label lbnomr4;
    @FXML
    private Button btcher;
    @FXML
    private ListView<String> idtable11;
    @FXML
    private TableView<Reclamation> tableview;
    @FXML
    private TableColumn<Reclamation, String> des;
    @FXML
    private TableColumn<Reclamation, String> datecr;
    @FXML
    private TableColumn<Reclamation, String> nom2;



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
            String description = tfdes.getText().trim();
            LocalDate date = datePicker.getValue();
            String nomr = tfnomr.getText().trim();
            int id_compte = Integer.parseInt(tfidc.getText().trim());

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
            tfdes.clear();
            datePicker.setValue(null);
            tfnomr.clear();
            tfidc.clear();
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
        
        
        String nom=tfnomr.getText();
        String desc= tfdes.getText();
                
        // Vérification que les champs obligatoires sont remplis
        if (tfnomr.getText().isEmpty() || tfdes.getText().isEmpty() || datePicker.getValue() == null) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs obligatoires.");
            return;
        }

        // Création de l'objet Reclamation avec les valeurs saisies
        LocalDate date = datePicker.getValue();
        Reclamation r = new Reclamation(desc, date.toString(), nom);
        tfnomr.clear();
        tfdes.clear();

        // Envoi de la réclamation au service de réclamation pour mise à jour
        ServiceReclamation sr = new ServiceReclamation();
        sr.update(r);
    }
    @FXML
    public void Delete (ActionEvent event) throws SQLException {
        
        
        try {
    // Vérifier si l'utilisateur a entré une chaine de caracrtere
    if (tfnomr2.getText().matches("^[a-zA-Z]+$")) {
        String nomr = tfnomr2.getText();

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
    if (tfnomr.getText().matches("^[a-zA-Z]+$")) {
        String nomr = tfnomr.getText();

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
    public void afficherReclamation () throws SQLException {
        
         try {
            ServiceReclamation sc = new ServiceReclamation();
            List<Reclamation> ctab = sc.readAll();
             ObservableList<Reclamation> Liste = FXCollections.observableArrayList(ctab);
            des.setCellValueFactory(new PropertyValueFactory<>("des"));
            datecr.setCellValueFactory(new PropertyValueFactory<>("datecr"));
            nom2.setCellValueFactory(new PropertyValueFactory<>("nom2"));
           
            tableview.setItems(Liste);
        } catch (SQLException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Database Error");
            alert.setContentText("There was an error accessing the database: " + e.getMessage());
            alert.showAndWait();
        }
        tableview.setItems(Liste);
        FilteredList<Reclamation> filteredData = new FilteredList<>(FXCollections.observableList(Liste));
        tableview.setItems(filteredData);
 
    }


    private void handleClick(MouseEvent event) throws SQLException {
        afficherReclamation();
    }



    @FXML
    private void Display(MouseEvent event) {
    }
    
      @Override
      public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
        
     
    }    
 
        





  










