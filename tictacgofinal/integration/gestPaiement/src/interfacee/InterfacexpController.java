/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacee;

import Entite.Paiement;
import Services.ServicePaiement;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.apache.commons.text.StringEscapeUtils;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class InterfacexpController implements Initializable {
     static {
        Stripe.apiKey = "sk_test_51MgXUSHDZ477HmaTRBbQ43QrqSPHsC5iUQE5tvFSKL3jVufDWRQ02wnDJ1P8As7ScIybYYpQ3MpGoNZFPI5OSbNI007jqR4B6q";
    }
     
      @FXML
    private Button Add;

    @FXML
    private Button Delete;

    @FXML
    private Button Display;

    @FXML
    private Label LBL1;

    @FXML
    private Label LBL2;

    @FXML
    private Button Search;

    @FXML
    private Button Update;

    @FXML
    private Pane panesta;
    
    @FXML
    private TextField txtD;

    @FXML
    private TextField Cn;
       
    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtM;

    @FXML
    private TextField txtValide;

    @FXML
    private TextField txtid;
    
     @FXML
    private TextField txtD2;

    @FXML
    private TextField Cn2;
       
    @FXML
    private TextField txtDate2;

    @FXML
    private TextField txtM2;

    @FXML
    private TextField txtValide2;

    @FXML
    private TextField txtid2;
    
    @FXML
    private TextField M_id2;
    
    @FXML
    private Label labelup;
    
    
    @FXML
    private TextField M_id;

    @FXML
    private Pane pane2;
    
   

    @FXML
    private Pane pane3;

    @FXML
    private Pane pane4;

    @FXML
    private Pane pane5;

    /**
     * Initializes the controller class.
     
     */
 
    @FXML
    public void handleClick(ActionEvent event){
        System.out.println("HELLOOOOO");
    if (event.getSource()==Add ){
       // LBL1.setText("ADD");
        panesta.toFront();
      
       

    }
    else if (event.getSource()==Update ){
       // LBL1.setText("Update");
        pane2.toFront();
       
    }
    else if (event.getSource()==Delete ){
       // LBL1.setText("DELETE");
        pane3.toFront();
    }
    else if (event.getSource()==Search ){
        //LBL1.setText("SEARCH");
       
        pane4.toFront();
    }
    else if (event.getSource()==Display ){
    //    LBL1.setText("DISPLAY");
      
        pane5.toFront();
    } 
    }
    
      @FXML
    void Add(ActionEvent event) {
        
       try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");
                    
            int id = Integer.parseInt(txtid.getText());
       /*  int id = 0;
                    try {        
             id = Integer.parseInt(txtid.getText());
            if (id < 0) {
                throw new NumberFormatException();
            }
            } catch (NumberFormatException e) {
            idEL.setText("Invalid ID. Please enter a positive integer.");
            return;
        } */
            int userId = Integer.parseInt(txtM.getText());
           /*
           int userId = 0;
        try {
            userId = Integer.parseInt(txtM.getText());
            if (userId < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            UIDEL.setText("Invalid User ID. Please enter a positive integer.");
            return;
        }
           */
           
           String type = txtD.getText().trim();
       /* if (type.isEmpty()) {
            TEL.setText("Type field is required.");
            return;
        } */
          
          String date = txtDate.getText().trim();
      /*  if (date.isEmpty()) {
            DEL.setText("Date field is required.");
            return;
        } */
             int pvalide = Integer.parseInt(txtValide.getText());
      /*       int pvalide = 0;
        try {
            pvalide = Integer.parseInt(txtValide.getText());
 
    if (pvalide != 0 && pvalide != 1) {
        throw new IllegalArgumentException();
    }
} catch (IllegalArgumentException e) {
    PVEL.setText("Invalid PValide. Please enter 0 or 1.");
    return;
}  */
             int MM_id = Integer.parseInt(M_id.getText());
          /*   int MM_id = 0;
        try {
            MM_id = Integer.parseInt(M_id.getText());
            if (MM_id < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
           MIDEL.setText("Invalid MM_id. Please enter a positive integer.");
            return;
        }*/
             java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
            Paiement p = new Paiement (id, userId , type ,sqlDate, pvalide , MM_id);
            ServicePaiement PS = new ServicePaiement();
            PS.ajouterPST(p);
           
            
            // Clear the text fields
           
            
            System.out.println("Payment added to the database.");
            
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
        }
       
        try {
        // Create a token for a Visa card
        Map<String, Object> card = new HashMap<>();
          String cardNumber = Cn.getText();
         if (cardNumber == null || cardNumber.isEmpty() || !cardNumber.matches("[0-9]+")) {
       // Cn.setText("not a valid card number");
  }
         String encodedCardNumber = encode(cardNumber);
        card.put("number", encodedCardNumber);
        card.put("exp_month", 12);
        card.put("exp_year", 2024);
        card.put("cvc", "123");

        Map<String, Object> params = new HashMap<>();
        params.put("card", card);

        Token token = Token.create(params);

        // Use the token to create a charge
        ChargeCreateParams chargeParams = ChargeCreateParams.builder()
                .setAmount((long)Integer.parseInt(txtM.getText()))
                //.setAmount((long)2000)
                .setCurrency("usd")
                .setDescription(txtD.getText())
                .setSource(token.getId())
                .build();

        Charge charge = Charge.create(chargeParams);
            txtid.clear();
            txtM.clear();
            txtD.clear();
            txtDate.clear();
            txtValide.clear();
            Cn.clear();
            M_id.clear();
        System.out.println(charge);
    } catch (StripeException e) {
        e.printStackTrace();
    }
        
      
    }
    private static String encode(String input) {
  return StringEscapeUtils.escapeHtml4(input);
}
    
     @FXML
    void Update(ActionEvent event) {
      try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");
        System.out.println("fatma");

        // get the updated data from the input fields
      //  int id = Integer.parseInt(txtid.getText());
        int id;
        try {
            id = Integer.parseInt(txtid2.getText());
        } catch (NumberFormatException e) {
          //  idER.setText("Invalid ID. Please enter a positive integer.");
            return;
        }
       // int userId = Integer.parseInt(txtM.getText());
       int userId;
        try {
            userId = Integer.parseInt(txtM2.getText());
             if (userId < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
       //     prER.setText("Invalid User ID. Please enter a positive integer.");
            return;
        }
        String type = txtD2.getText();
          
        if (type.isEmpty()) {
       //     desER.setText("Payment type cannot be empty.");
            return;
        }
        System.out.println(userId + type );
        String date = txtDate2.getText();
       
        if (date.isEmpty()) {
          //  DaER.setText("Payment date cannot be empty.");
            return;
        }
       
        int pvalide;
        try {
            pvalide = Integer.parseInt(txtValide2.getText());
            if (pvalide != 0 && pvalide != 1) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
         //   VER.setText("Invalid PValide. Please enter either 0 or 1.");
            return;
        }
       
        
         int MM_id;
        try {
            MM_id = Integer.parseInt(M_id2.getText());
            if (userId < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
          //  ideer.setText("Invalid MM ID. Please enter a positive integer.");
            return;
        }
        System.out.println("fatma");
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        // create a new Paiement object with the updated data
        Paiement p = new Paiement(id, userId, type, sqlDate, pvalide, MM_id);
        // update the database with the new Paiement object
        ServicePaiement PS = new ServicePaiement();
        PS.update(p);

        // clear the input fields
        txtid2.clear();
        txtM2.clear();
        txtD2.clear();
        txtDate2.clear();
        txtValide2.clear();
        Cn2.clear();
        M_id2.clear();
        System.out.println("Payment updated in the database.");
    } catch (SQLException e) {
        System.out.println("Error: " + e.getMessage());
    } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
    }
    } 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
