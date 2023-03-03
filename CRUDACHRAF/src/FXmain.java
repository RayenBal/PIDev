import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Chauffeur Management System");

        // Create the buttons for the menu
        Button ajouterBtn = new Button("Ajouter Chauffeur");
        Button updateBtn = new Button("Update Chauffeur");
        Button supprimerBtn = new Button("Supprimer Chauffeur");
        Button afficherBtn = new Button("Afficher Chauffeur");

        // Set the action for each button
        ajouterBtn.setOnAction(event -> {
            try {
                Parent ajouterChauffeur = FXMLLoader.load(getClass().getResource("ajouterChauffeur.fxml"));
                Scene ajouterScene = new Scene(ajouterChauffeur);
                primaryStage.setScene(ajouterScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        updateBtn.setOnAction(event -> {
            try {
                Parent updateChauffeur = FXMLLoader.load(getClass().getResource("updateChauffeur.fxml"));
                Scene updateScene = new Scene(updateChauffeur);
                primaryStage.setScene(updateScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        supprimerBtn.setOnAction(event -> {
            try {
                Parent supprimerChauffeur = FXMLLoader.load(getClass().getResource("SupprimerChauffeur.fxml"));
                Scene supprimerScene = new Scene(supprimerChauffeur);
                primaryStage.setScene(supprimerScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        afficherBtn.setOnAction(event -> {
            try {
                Parent afficherChauffeur = FXMLLoader.load(getClass().getResource("AfficherChauffeur.fxml"));
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
