/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.gestpaiement;

import Entite.Paiement;
import Services.ServicePaiement;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class PaiementController implements Initializable {
  // @FXML
   // private TableView<Paiement> TV;
    
    @FXML
    private Button Disp;
   {/*

    @FXML
    private TableColumn<Paiement, String> affd;

    @FXML
    private TableColumn<Paiement, Date> affda;

    @FXML
    private TableColumn<Paiement, Double> affid;

    @FXML
    private TableColumn<Paiement, Double> affm;

    @FXML
    private TableColumn<Paiement, Integer> affpai;
    */}
   
    @FXML
    private TextField M_id;
    
   @FXML
    private ListView<Paiement> LV;
   
      @FXML
    private Button btn1; 
      
      @FXML
    private Button btnD;

      
 @FXML
    private Button btnA;

    @FXML
    private TextField txtD;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtM;

    @FXML
    private TextField txtValide;

    @FXML
    private TextField txtid;
    
        @FXML
    private Button btnF;

    @FXML
    void Add(ActionEvent event) {
        
         try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");
                    
            int id = Integer.parseInt(txtid.getText());
            int userId = Integer.parseInt(txtM.getText());
            String type = txtD.getText();
            String date = txtDate.getText();
             int pvalide = Integer.parseInt(txtValide.getText());
             int MM_id = Integer.parseInt(M_id.getText());
             java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
            Paiement p = new Paiement (id, userId , type ,sqlDate, pvalide , MM_id);
            ServicePaiement PS = new ServicePaiement();
            PS.ajouterPST(p);
           
            
            // Clear the text fields
            txtid.clear();
            txtM.clear();
            txtD.clear();
            txtDate.clear();
            txtValide.clear();
            
            System.out.println("Payment added to the database.");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
    
    }
    
      @FXML
    void Display(ActionEvent event) throws SQLException {
        ServicePaiement PS1 = new ServicePaiement();
        List<Paiement> paiements = PS1.readAll();
         System.out.println(paiements);

 // Create an observable list to hold the data
       // ObservableList<Paiement> paiement = FXCollections.observableArrayList(paiements);
        
      // TV.setItems(paiement);
      {/*
       affid.setCellValueFactory(new PropertyValueFactory<>("id"));
   affm.setCellValueFactory(new PropertyValueFactory<>("montant"));
    
    affd.setCellValueFactory(new PropertyValueFactory<>("description"));
    affda.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getDate()));
    affpai.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getPvalide())); 
    TV.setItems(paiement); 
*/}
       ObservableList<Paiement> paiement = FXCollections.observableArrayList(paiements);
      LV.setItems(paiement);
}
    @FXML
    void Update(ActionEvent event) {
 try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // get the updated data from the input fields
        int id = Integer.parseInt(txtid.getText());
        int userId = Integer.parseInt(txtM.getText());
        String type = txtD.getText();
        System.out.println(userId + type );
        String date = txtDate.getText();
        int pvalide = Integer.parseInt(txtValide.getText());
        int MM_id = Integer.parseInt(M_id.getText());
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        // create a new Paiement object with the updated data
        Paiement p = new Paiement(id, userId, type, sqlDate, pvalide, MM_id);
        
        // update the database with the new Paiement object
        ServicePaiement PS = new ServicePaiement();
        PS.update(p);

        // clear the input fields
        txtid.clear();
        txtM.clear();
        txtD.clear();
        txtDate.clear();
        txtValide.clear();
        
        System.out.println("Payment updated in the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
    }
    }
    
    @FXML
    void Delete(ActionEvent event) {
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");

        // Get the selected payment ID from the list view
         int id = Integer.parseInt(txtid.getText());
         java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Paiement p = new Paiement(id, 0, "",sqlDate , 0,0);
        // Delete the payment from the database
        ServicePaiement servicePaiement = new ServicePaiement();
        servicePaiement.supprime(p);

        // Remove the payment from the list view
        

        System.out.println("Payment deleted from the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    }
    }
    @FXML
    void FindByID(ActionEvent event) throws SQLException {
    int id = Integer.parseInt(txtid.getText());
    ServicePaiement PS = new ServicePaiement();
    
    Paiement paiements = PS.findById(id);
    
    
    if (paiements != null) {
        
        
         System.out.println(paiements);
         ObservableList<Paiement> paiement = FXCollections.observableArrayList(paiements);
      LV.setItems(paiement);
    } else {
        System.out.println("No payment found with ID: " + id);
    }
    }



      
    
    
    public void initialize(URL url, ResourceBundle rb) {
        
      
}
}
