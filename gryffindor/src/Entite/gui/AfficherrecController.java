
package Entite.gui;

import Entite.Reclamation;
import Services.ServiceReclamation;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherrecController implements Initializable {
/*
    nitializable and the method it adds are used when you want to interact with 
    
    stuff injected with @FXML. During construction those variables aren't filled so 
    you cannot interact with them so JavaFX will call the Initializable interface 
    after everything is set up.
    At that point those variables are available and can be manipulated.
    */
    
    @FXML
    private TableView<Reclamation> idtable;
    @FXML
    private Button btsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableColumn<Reclamation, Integer> idCol = new TableColumn<>("ID");
        idCol.setPrefWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Reclamation, String> descriptionCol = new TableColumn<>("Description");
        descriptionCol.setPrefWidth(200);
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Reclamation, String> dateCol = new TableColumn<>("Date");
        dateCol.setPrefWidth(100);
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));

        idtable.getColumns().addAll(idCol, descriptionCol, dateCol);
    }    

    @FXML
    private void Afficherrec(ActionEvent event) throws SQLException {
        ServiceReclamation sc = new ServiceReclamation();
        List<Reclamation> ctab = sc.readAll();
        System.out.println(ctab);
        ObservableList<Reclamation> r = FXCollections.observableArrayList(ctab);
        idtable.setItems(r);
    }

}
