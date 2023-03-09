/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;

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

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class AfficherAssuranceController implements Initializable {
    @FXML
    private ListView<Assurance> tableAssurance;
    @FXML
    private Button buttonafficher;
    @FXML
    private Button Ajouter;
    @FXML
    private Button modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private Label label;
    @FXML
    private Button pdf;
    @FXML
    private Button txt;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
     @FXML
    private void AfficherCompte(ActionEvent event) throws SQLException{
       ServiceAssurance sa = new ServiceAssurance();
        List<Assurance> atab = sa.readAll();
         System.out.println(atab);
         ObservableList<Assurance> Assurance = FXCollections.observableArrayList(atab);
      tableAssurance.setItems(Assurance);  
    }

    @FXML
    private void Ajouter(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/AjouterAssurance.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(AjouterAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void modifier(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/ModifierAssurance.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(ModifierAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Supprimer(ActionEvent event) {
          try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/gestuserassurance/SupprimerAssurance.fxml"));
            Parent root = loader.load();
            label.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(SupprimerAssuranceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
   private void printAssurance() {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    try {
        ServiceAssurance sc = new ServiceAssurance();
        List<Assurance> data = sc.readAll();

        // Create a new PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("assurance.pdf"));
        document.open();

      // Create a table with four columns
PdfPTable table = new PdfPTable(2);

// Add table headers
table.addCell("date de validité de l'assurance");
table.addCell("Immatriculation");


// Add the information of all sponsors to the table
for (Assurance s : data) {
    table.addCell(s.getDate_validité().toString());
    table.addCell(s.getImmatriculation().toString());

}

// Add the table to the document
document.add(table);

        document.close();

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Impression réussie");
        alert.setContentText("La liste des assurances a été imprimée avec succès.");
        alert.showAndWait();
    } catch (Exception e) {
        // Show an error message if an exception occurs
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'impression");
        alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des assurances.");
        alert.showAndWait();
    }
}

    @FXML
    private void printAssurancetxt(ActionEvent event) {
        try {
        ServiceAssurance sc = new ServiceAssurance();
        List<Assurance> data = sc.readAll();

        // Create a new file
        File file = new File("Assurances.txt");
        FileWriter writer = new FileWriter(file);

        // Write the data to the file
        for (Assurance s : data) {
                        writer.write("-------------------------------------------------------------------------------------------------\n");

            writer.write("Date validité pour le vehicule immatriculé: " + s.getImmatriculation().toString() + "  est valide jusqu'a"+ s.getDate_validité() +"\n");
           // writer.write("Immatriculation: " + s.getImmatriculation().toString() + "\n");
            // Add other fields as needed
            writer.write("\n");
        }

        writer.close();

        // Show a success message
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText("Impression réussie");
        alert.setContentText("La liste des assurances a été imprimée avec succès.");
        alert.showAndWait();
    } catch (Exception e) {
        // Show an error message if an exception occurs
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText("Erreur lors de l'impression");
        alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des assurances.");
        alert.showAndWait();
    }
    }


 


    
    
}