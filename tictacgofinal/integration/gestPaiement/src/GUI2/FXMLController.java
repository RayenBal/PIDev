/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI2;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.apache.commons.text.StringEscapeUtils;

/**
 * FXML Controller class
 *
 * @author INFOTEC
 */
public class FXMLController implements Initializable {
    static {
        Stripe.apiKey = "sk_test_51MgXUSHDZ477HmaTRBbQ43QrqSPHsC5iUQE5tvFSKL3jVufDWRQ02wnDJ1P8As7ScIybYYpQ3MpGoNZFPI5OSbNI007jqR4B6q";
    }

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField Cn;
     
     @FXML
    private TextField M_id;

    @FXML
    private Button btnA;

    @FXML
    private TextField txtD;

    @FXML
    private TextField txtDate;

    @FXML
    private TextField txtM;

    @FXML
    private TextField txtValide;

    @FXML
    private TextField txtid;
    
    @FXML
     private Label idEL;
    @FXML
    private Label UIDEL;
    @FXML
    private Label TEL;
    @FXML
    private Label DEL;
    @FXML
    private Label PVEL;
    @FXML
    private Label MIDEL;

    @FXML
    void Add(ActionEvent event) {
        
       try {
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tictacgo", "root", "");
                    
         //   int id = Integer.parseInt(txtid.getText());
         int id = 0;
                    try {        
             id = Integer.parseInt(txtid.getText());
            if (id < 0) {
                throw new NumberFormatException();
            }
            } catch (NumberFormatException e) {
            idEL.setText("Invalid ID. Please enter a positive integer.");
            return;
        }
           // int userId = Integer.parseInt(txtM.getText());
           
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
           
           
           String type = txtD.getText().trim();
        if (type.isEmpty()) {
            TEL.setText("Type field is required.");
            return;
        }
          
          String date = txtDate.getText().trim();
        if (date.isEmpty()) {
            DEL.setText("Date field is required.");
            return;
        }
           //  int pvalide = Integer.parseInt(txtValide.getText());
             int pvalide = 0;
        try {
            pvalide = Integer.parseInt(txtValide.getText());
 
    if (pvalide != 0 && pvalide != 1) {
        throw new IllegalArgumentException();
    }
} catch (IllegalArgumentException e) {
    PVEL.setText("Invalid PValide. Please enter 0 or 1.");
    return;
}
             //int MM_id = Integer.parseInt(M_id.getText());
             int MM_id = 0;
        try {
            MM_id = Integer.parseInt(M_id.getText());
            if (MM_id < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
           MIDEL.setText("Invalid MM_id. Please enter a positive integer.");
            return;
        }
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
        idEL.setText("not a valid card number");
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
