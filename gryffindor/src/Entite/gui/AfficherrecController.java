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
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherrecController implements Initializable {

    @FXML
    private ListView<Reclamation> idtable;
    @FXML
    private Button btsup;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
