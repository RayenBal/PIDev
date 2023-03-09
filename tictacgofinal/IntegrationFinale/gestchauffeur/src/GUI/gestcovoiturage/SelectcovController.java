package GUI.gestcovoiturage;

import Entite.Covoiturage;
import GUI.gestpaiement.DisplayController;
import Services.ServiceCovoiturage;
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
import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
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
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;


public class SelectcovController implements Initializable {

    @FXML
    private ListView<Covoiturage> mylistview;

    private FilteredList<Covoiturage> filteredData;
    @FXML
    private Button filterField;
    @FXML
    private Button buttonQR;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            ServiceCovoiturage sc = new ServiceCovoiturage();

            List<Covoiturage> data = sc.readAll();

            filteredData = new FilteredList<>(FXCollections.observableList(data), p -> true);

            mylistview.setItems(filteredData);

            mylistview.setCellFactory((ListView<Covoiturage> lv) -> {
                return new ListCell<Covoiturage>() {
                    private HBox hbox = new HBox();
                    private Label departure = new Label();
                    private Label arrival = new Label();
                    private Label price = new Label();
                    private Label hour = new Label();
                    private Label nbPlacesLabel = new Label("Places disponibles :");
                    private Label nbPlaces = new Label();
                    private Button editButton = new Button("Modifier");
                    private Button deleteButton = new Button("Supprimer");
                    private Button reserveButton = new Button("Réserver");

                    {
                        hbox.getChildren().addAll(departure, new Label(" -> "), arrival, price, hour, nbPlacesLabel, nbPlaces, editButton, deleteButton, reserveButton);
                        hbox.setSpacing(10);
                        editButton.setOnAction(event -> {
                            // handle edit button action
                            Covoiturage covoiturage = getItem();
                            // open a new view to edit the covoiturage
                            try {
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Updatecov.fxml"));
                                Parent root = fxmlLoader.load();
                                UpdatecovController editCovController = fxmlLoader.getController();
                                editCovController.setCovoiturage(covoiturage);

                                editCovController.setMylistview(mylistview);
                                mylistview.getScene().setRoot(root);
                            } catch (IOException ex) {
                                Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        });

                        deleteButton.setOnAction(event -> {
                            // handle delete button action
                            Covoiturage covoiturage = getItem();
                            try {
                                sc.supprime(covoiturage); // delete from database
                            } catch (SQLException ex) {
                                Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            mylistview.getItems().remove(covoiturage); // remove from ListView
                        });

                        reserveButton.setOnAction(event -> {
                            Covoiturage covoiturage = getItem();
                            if (covoiturage.getNbrplace() > 0) {
                                covoiturage.setNbrplace(covoiturage.getNbrplace() - 1);
                                try {
                                    sc.update(covoiturage); // update database

                                } catch (SQLException ex) {
                                    Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                nbPlaces.setText(String.valueOf(covoiturage.getNbrplace())); // update ListView
                            } else {
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Impossible");
                                alert.setHeaderText("Le covoiturage est complet");
                                alert.setContentText("Il n'y a plus de places disponibles pour ce covoiturage.");
                                alert.showAndWait();
                            }
                        });
                    }

                    @Override
                    protected void updateItem(Covoiturage covoiturage, boolean empty) {
                        super.updateItem(covoiturage, empty);
                        if (empty || covoiturage == null) {
                            setText(null);
                            setGraphic(null);
                        } else {
                            departure.setText(covoiturage.getDepart());
                            arrival.setText(covoiturage.getDestination());
                            hour.setText(covoiturage.getDate_covoiturage());
                            price.setText(covoiturage.getPrix() + " dt");
                            nbPlaces.setText(String.valueOf(covoiturage.getNbrplace()));
                            setText(null);
                            setGraphic(hbox);
                            // apply styles
                            departure.getStyleClass().add("label");
                            arrival.getStyleClass().add("label");
                            hour.getStyleClass().add("text");
                            nbPlacesLabel.getStyleClass().add("label");
                            nbPlaces.getStyleClass().add("text");
                            price.getStyleClass().add("text");
                            editButton.getStyleClass().add("button");
                            deleteButton.getStyleClass().add("button");
                        }
                    }

                    class TextToSpeech {

                        private final Voice voice;

                        public TextToSpeech() {
                            // Initialize FreeTTS voice
                            System.setProperty("freetts.voices", "com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
                            VoiceManager voiceManager = VoiceManager.getInstance();
                            voice = voiceManager.getVoice("kevin16");
                            voice.allocate();
                        }

                        public void speak(String text) {
                            voice.speak(text);
                        }

                    }

                    private void notifyUser(String message) {
                        TextToSpeech tts = new TextToSpeech();
                        tts.speak(message);
                    }
                    /*public  void main(String[] args) {
    String message = "Welcome to the covoiturage list that contains the list of carpools available near to you";
    notifyUser(message);
}*/

                };
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void retour_ajout(ActionEvent event) {

    }

    @FXML
    private void handlePrint(ActionEvent event) {
        printCovoiturages();
    }

   private void printCovoiturages() {

        try {
            ServiceCovoiturage sc = new ServiceCovoiturage();
            List<Covoiturage> data = sc.readAll();
            BaseColor orange = new BaseColor(255, 140, 0); // RGB values for orange
            BaseColor darkBlue = new BaseColor(0, 0, 139); // RGB values for dark blue

            // Create a new PDF document
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream("covoiturages.pdf"));
            document.open();

            //Add an image 
            Image img = Image.getInstance("logofinal.png");

            // Resize the image
            img.scaleToFit(75, 75);
           // Create a paragraph for the image and set its alignment
Paragraph imageParagraph = new Paragraph();
imageParagraph.add(img);
imageParagraph.setAlignment(Element.ALIGN_LEFT);
document.add(imageParagraph);

           // document.add(img);
            // Add a title to the document
            Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD, darkBlue);
            Paragraph title = new Paragraph("Liste des covoiturages", titleFont);

            title.setAlignment(Element.ALIGN_CENTER);

            document.add(title);

            // Add some spacing after the image
            document.add(Chunk.NEWLINE);
            // Add some spacing before the table
            document.add(Chunk.NEWLINE);

            // Create a table with four columns
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);

            // Set the widths of the columns
            float[] columnWidths = {2, 2, 3, 3};
            table.setWidths(columnWidths);

            // Set some cell padding
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Add table headers
            Font headerFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, orange);
            PdfPCell headerCell;

            headerCell = new PdfPCell(new Phrase("Prix", headerFont));
            headerCell.setBackgroundColor(darkBlue);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("Nombre de places", headerFont));
            headerCell.setBackgroundColor(darkBlue);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("Départ", headerFont));
            headerCell.setBackgroundColor(darkBlue);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            headerCell = new PdfPCell(new Phrase("Arrivée", headerFont));
            headerCell.setBackgroundColor(darkBlue);
            headerCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(headerCell);

            // Add the information of all sponsors to the table
            Font dataFont = new Font(Font.FontFamily.TIMES_ROMAN, 10);
            PdfPCell dataCell;

            for (Covoiturage s : data) {
                dataCell = new PdfPCell(new Phrase(Float.toString(s.getPrix()) + "Dt", dataFont));
                dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(dataCell);

                dataCell = new PdfPCell(new Phrase(s.getNbrplace() + " places dispo", dataFont));
                dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                dataCell.setBackgroundColor(orange);
                table.addCell(dataCell);

                dataCell = new PdfPCell(new Phrase(s.getDepart().toString(), dataFont));
                dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(dataCell);

                dataCell = new PdfPCell(new Phrase(s.getDestination().toString(), dataFont));
                dataCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(dataCell);
            }

            // Add the table to the document
            document.add(table);

            document.close();

            // Show a success message
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Impression réussie");
            alert.setContentText("La liste des covoiturages a été imprimée avec succès.");
            alert.showAndWait();
        } catch (Exception e) {
            // Show an error message if an exception occurs
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Erreur lors de l'impression");
            alert.setContentText("Une erreur s'est produite lors de l'impression de la liste des covoiturages.");
            alert.showAndWait();
        }
    }

    @FXML
    private void sortListByPrice(ActionEvent event) {
        try {
            ServiceCovoiturage sc = new ServiceCovoiturage();
            List<Covoiturage> data = sc.trierCovoiturages();
            filteredData = new FilteredList<>(FXCollections.observableList(data), p -> true);
            mylistview.setItems(filteredData);
        } catch (SQLException ex) {
            Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sortListByDate(ActionEvent event) {

        filteredData.setPredicate(null); // remove the filter, if any

        // sort the list by date
        filteredData.sort((c1, c2) -> c1.getDate_covoiturage().compareTo(c2.getDate_covoiturage()));
    }

    @FXML
    private void handleRefreshButton(ActionEvent event) {
        try {
            ServiceCovoiturage sc = new ServiceCovoiturage();
            List<Covoiturage> data = sc.readAll();
            filteredData = new FilteredList<>(FXCollections.observableList(data), p -> true);
            mylistview.setItems(filteredData);
        } catch (SQLException ex) {
            Logger.getLogger(SelectcovController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @FXML
   private void generateQR(ActionEvent event) {
    // Création de l'objet QRCodeWriter
    QRCodeWriter qrCodeWriter = new QRCodeWriter();

    // Paramètres de l'encodeur
    int width = 300;
    int height = 300;
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Enregistrer le QR code");
    File file = fileChooser.showSaveDialog(null);

    // Configuration des paramètres de l'encodeur
    Map<EncodeHintType, Object> hintMap = new HashMap<>();
    hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8");

    try {
        String data = "https://www.youtube.com/watch?v=-ukrEj9mv-s";
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height, hintMap);
        BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
        String fileName = file.getName().concat(".png");
        try (OutputStream out = new FileOutputStream(new File(file.getParent(), fileName))) {
            ImageIO.write(image, "png", out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } catch (WriterException e) {
        e.printStackTrace();
    }
}


}

