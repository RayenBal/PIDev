/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trypay;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.ChargeCreateParams;
import com.stripe.param.TokenCreateParams;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author INFOTEC
 */
public class NewClass {
    static {
        Stripe.apiKey = "sk_test_51MgXUSHDZ477HmaTRBbQ43QrqSPHsC5iUQE5tvFSKL3jVufDWRQ02wnDJ1P8As7ScIybYYpQ3MpGoNZFPI5OSbNI007jqR4B6q";
    }
    
    
   /* public static void createCharge(String token, long amount, String description) throws StripeException {
        ChargeCreateParams params =
          ChargeCreateParams.builder()
            .setAmount(amount)
            .setCurrency("usd")
            .setDescription(description)
            .setSource(token)
            .build();

        Charge charge = Charge.create(params);
        
        
    }*/
    
    public static void main(String[] args) {
        
       
        try {
        // Create a token for a Visa card
        Map<String, Object> card = new HashMap<>();
        card.put("number", "5555555555554444");
        card.put("exp_month", 12);
        card.put("exp_year", 2024);
        card.put("cvc", "123");

        Map<String, Object> params = new HashMap<>();
        params.put("card", card);

        Token token = Token.create(params);

        // Use the token to create a charge
        ChargeCreateParams chargeParams = ChargeCreateParams.builder()
                .setAmount((long)1000)
                .setCurrency("usd")
                .setDescription("Charge for carpooling service")
                .setSource(token.getId())
                .build();

        Charge charge = Charge.create(chargeParams);

        System.out.println(charge);
    } catch (StripeException e) {
        e.printStackTrace();
    }
        
       /* try {
            TokenCreateParams params =
      TokenCreateParams.builder()
        .setCard(TokenCreateParams.Card.builder()
          .setNumber("4242424242424242")
          .setExpMonth("12")
          .setExpYear("2024")
          .setCvc("123")
          .build())
        .build();
       String token = Token.create(params).toString();
      System.out.println(token);
   
    int amount = 1000; // $10.00 in cents
    String description = "Charge for ca";

    NewClass.createCharge(token , amount, description);
    
} catch (StripeException e) {
    // Handle Stripe API errors
    e.printStackTrace();
} */
    }
}
