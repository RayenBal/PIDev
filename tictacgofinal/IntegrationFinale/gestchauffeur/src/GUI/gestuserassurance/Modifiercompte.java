package GUI.gestuserassurance;

import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.mysql.cj.jdbc.Driver;
import static javafx.application.Application.launch;


public class Modifiercompte extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Modifiercompte.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}