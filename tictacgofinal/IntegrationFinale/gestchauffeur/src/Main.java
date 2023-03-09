import Utils.MyDB;
import java.io.IOException;
import java.sql.Connection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
    
//  public static Stage mainStage;
    Stage stage;
    Parent parent;
    
    
    @Override
    public void start(Stage primaryStage){
       this.stage= primaryStage;
        try {
             parent = FXMLLoader.load(getClass().getResource("GUI/gestuserassurance/Testback.fxml"));
             Scene scene = new Scene(parent);
             stage.setScene(scene);
        stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
       
        
        
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        launch(args);
        Connection con=MyDB.getInstance().getConnection();
      
        System.out.println(con);
    }
}
