/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import entites.Passager;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import service.PassagerService;

/**
 * FXML Controller class
 *
 * @author medzr
 */
public class PassagerController implements Initializable {

    @FXML
    private TextField txtnom;
    @FXML
    private TextField txtprenom;
    @FXML
    private TextField txtnum;
    @FXML
    private TextField txtadresse;
    @FXML
    private TextField txtemail;
    @FXML
    private Button btnA;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML

private void Add(ActionEvent event) throws SQLException {
    // Récupérer les valeurs saisies
    String nom = txtnom.getText().trim();
    String prenom = txtprenom.getText().trim();
    String num = txtnum.getText().trim();
    String adresse = txtadresse.getText().trim();
    String email = txtemail.getText().trim();
    
    // Vérifier que tous les champs ont été remplis
    if (nom.isEmpty() || prenom.isEmpty() || num.isEmpty() || adresse.isEmpty() || email.isEmpty()) {
        System.out.println("Veuillez remplir tous les champs");
        return;
    }
    

    
    // Vérifier que le champ "num" contient un nombre entier
    try {
        Integer.parseInt(num);
    } catch (NumberFormatException e) {
        System.out.println("Le numéro de téléphone doit être un entier");
        return;
    }
    
    // Ajouter le passager si toutes les saisies sont valides
    Passager p = new Passager();
    p.setNomp(nom);
    p.setPrenomp(prenom);
    p.setNump(num);
    p.setAdressep(adresse);
    p.setEmailp(email);
    PassagerService ps=new PassagerService();
    ps.ajouter(p);
    System.out.println(p);   
}

    
}
