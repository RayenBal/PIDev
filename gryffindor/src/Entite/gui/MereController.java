/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class MereController implements Initializable {
    @FXML
    private TabPane tabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // create tabs for each page
            Tab tab1 = new Tab("Page 1");
            Tab tab2 = new Tab("Page 2");
            Tab tab3 = new Tab("Page 3");
            
            // load the FXML files for each page
            FXMLLoader loader1 = new FXMLLoader(getClass().getResource("update.fxml"));
            FXMLLoader loader2 = new FXMLLoader(getClass().getResource("page2.fxml"));
            FXMLLoader loader3 = new FXMLLoader(getClass().getResource("page3.fxml"));
            
            // load the root node for each page
            Node node1 = loader1.load();
            Node node2 = loader2.load();
            Node node3 = loader3.load();
            
            // set the content of each tab to the root node of the corresponding page
            tab1.setContent(node1);
            tab2.setContent(node2);
            tab3.setContent(node3);
            
            // add the tabs to the tab pane
            tabPane.getTabs().addAll(tab1, tab2, tab3);
        } catch (IOException ex) {
            Logger.getLogger(MereController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
 
}
