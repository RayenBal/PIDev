package GUI2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainWindow2Controller {

    private MainWindow2 mainWindow;

    public void setMainWindow(MainWindow2 mainWindow) {
        this.mainWindow = mainWindow;
    }

    @FXML
    private void handleAjouterButton(ActionEvent event) throws Exception {
        mainWindow.showAjouterInterface();
    }

    @FXML
    private void handleSupprimerButton(ActionEvent event) throws Exception {
        mainWindow.showSupprimerInterface();
    }

    @FXML
    private void handleUpdateButton(ActionEvent event) throws Exception {
        mainWindow.showUpdateInterface();
    }

    @FXML
    private void handleAfficherButton(ActionEvent event) throws Exception {
        mainWindow.showAfficherInterface();
    }

    @FXML
    private void handleBackButton(ActionEvent event) throws Exception {
        mainWindow.showMainView();
    }
}
