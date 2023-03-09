package GUI2; 

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainWindow2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Infotraffic Management System");

        // Create the buttons for the menu
        Button ajouterBtn = new Button("Ajouter infotraffic");
        Button updateBtn = new Button("Update infotraffic");
        Button supprimerBtn = new Button("Supprimer infotraffic");
        Button afficherBtn = new Button("Afficher infotraffic");

        // Set the action for each button
        ajouterBtn.setOnAction(event -> {
            try {
                Parent ajouterChauffeur = FXMLLoader.load(getClass().getResource("AjouterInfotraffic.fxml"));
                Scene ajouterScene = new Scene(ajouterChauffeur);
                primaryStage.setScene(ajouterScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        updateBtn.setOnAction(event -> {
            try {
                Parent updateChauffeur = FXMLLoader.load(getClass().getResource("UpdateInfotrafic.fxml"));
                Scene updateScene = new Scene(updateChauffeur);
                primaryStage.setScene(updateScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        supprimerBtn.setOnAction(event -> {
            try {
                Parent supprimerChauffeur = FXMLLoader.load(getClass().getResource("SupprimerInfotraffic.fxml"));
                Scene supprimerScene = new Scene(supprimerChauffeur);
                primaryStage.setScene(supprimerScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        afficherBtn.setOnAction(event -> {
            try {
                Parent afficherChauffeur = FXMLLoader.load(getClass().getResource("AfficherInfotrafic.fxml"));
                Scene afficherScene = new Scene(afficherChauffeur);
                primaryStage.setScene(afficherScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Add the buttons to the menu
        VBox menuLayout = new VBox(10);
        menuLayout.getChildren().addAll(ajouterBtn, updateBtn, supprimerBtn, afficherBtn);

        // Set the menu as the primary scene
        Scene menuScene = new Scene(menuLayout, 300, 200);
        primaryStage.setScene(menuScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}