package GUI;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainWindowController extends Application {

    @FXML
    private VBox mainWindow;

    @FXML
    private Button afficherButton;

    @FXML
    private Button ajouterButton;

    @FXML
    private Button supprimerButton;

    @FXML
    private Button updateButton;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void openAfficherChauffeur() throws IOException {
        Parent afficherParent = FXMLLoader.load(getClass().getResource("AfficherChauffeur.fxml"));
        Scene afficherScene = new Scene(afficherParent);
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setScene(afficherScene);
    }

    public void openAjouterChauffeur() throws IOException {
        Parent ajouterParent = FXMLLoader.load(getClass().getResource("AjouterChauffeur.fxml"));
        Scene ajouterScene = new Scene(ajouterParent);
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setScene(ajouterScene);
    }

    public void openSupprimerChauffeur() throws IOException {
        Parent supprimerParent = FXMLLoader.load(getClass().getResource("SupprimerChauffeur.fxml"));
        Scene supprimerScene = new Scene(supprimerParent);
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setScene(supprimerScene);
    }

    public void openUpdateChauffeur() throws IOException {
        Parent updateParent = FXMLLoader.load(getClass().getResource("UpdateChauffeur.fxml"));
        Scene updateScene = new Scene(updateParent);
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setScene(updateScene);
    }

    public void returnToMain() throws IOException {
        Parent mainParent = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        Scene mainScene = new Scene(mainParent);
        Stage window = (Stage) mainWindow.getScene().getWindow();
        window.setScene(mainScene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
