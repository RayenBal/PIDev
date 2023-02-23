package GUI2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainWindow2 extends Application {
    
    private Stage primaryStage;
    private BorderPane mainLayout;

    @Override
    public void start(Stage primaryStage) {
        try {
            this.primaryStage = primaryStage;
            this.primaryStage.setTitle("Main Window");

            showMainView();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void showMainView() throws Exception {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow2.class.getResource("MainView.fxml"));
            mainLayout = loader.load();
            Scene scene = new Scene(mainLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAjouterInterface() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow2.class.getResource("AjouterInfotraffic.fxml"));
            BorderPane ajouterInterface = loader.load();
            mainLayout.setCenter(ajouterInterface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showSupprimerInterface() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow2.class.getResource("SupprimerInfotraffic.fxml"));
            BorderPane supprimerInterface = loader.load();
            mainLayout.setCenter(supprimerInterface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showUpdateInterface() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow2.class.getResource("UpdateInfotrafic.fxml"));
            BorderPane updateInterface = loader.load();
            mainLayout.setCenter(updateInterface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void showAfficherInterface() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainWindow2.class.getResource("AfficherInfotrafic.fxml"));
            BorderPane afficherInterface = loader.load();
            mainLayout.setCenter(afficherInterface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
