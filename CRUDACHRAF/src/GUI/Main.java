/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import Entite.infotrafic;
import Services.ServiceInfotrafic;
import Entite.Chauffeur;
import Services.ServiceChauffeur;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author sarra
 */
public class Main extends Application{

     @Override
    public void start(Stage primaryStage) {
        
    
        try {
               System.out.println("aa");
            
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            
            
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("AjouterChauffeur");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
           System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }


}
