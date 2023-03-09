/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tryinfcaptcha;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FXML Controller class
 *
 * @author Rayen
 */
public class TryingcaptchaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
      @FXML
    private WebView webView;

    @FXML
    private Button submitButton;

    private String siteKey = "6LcDYd0kAAAAADnf4b0LWZxQvFxOWXZbFUQco32J";
    private String secretKey = "6LcDYd0kAAAAACFhzJ8cBFsoRlgumjlEivMc9qz4";

    public void initialize() {
        WebEngine webEngine = webView.getEngine();

        // Load the reCAPTCHA page in the WebView
        //webEngine.load("https://www.google.com/recaptcha/api.js?render=" + siteKey);
        webEngine.load("https://www.youtube.com/watch?v=yK9DeQFgt1g");

        // Add a listener to the submit button
        submitButton.setOnAction(event -> {
            // Get the user's response from the WebView
            String userResponse = (String) webEngine.executeScript("grecaptcha.getResponse()");

            // Verify the user's response with the reCAPTCHA server
            boolean success = verifyRecaptcha(userResponse);

            if (success) {
                // The user is verified
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("You are a human!");
                alert.showAndWait();
            } else {
                // The user is not verified
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Please prove that you are not a robot!");
                alert.showAndWait();
            }
        });
    }

    private boolean verifyRecaptcha(String userResponse) {
        try {
            String url = "https://www.google.com/recaptcha/api/siteverify?secret=" + secretKey + "&response=" + userResponse;

            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            StringBuilder responseBuilder = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                responseBuilder.append(inputLine);
            }

            in.close();

            Gson gson = new Gson();
            RecaptchaResponse response = gson.fromJson(responseBuilder.toString(), RecaptchaResponse.class);

            return response.success;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static class RecaptchaResponse {
        boolean success;
        String challenge_ts;
        String hostname;

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getChallenge_ts() {
            return challenge_ts;
        }

        public void setChallenge_ts(String challenge_ts) {
            this.challenge_ts = challenge_ts;
        }

        public String getHostname() {
            return hostname;
        }

        public void setHostname(String hostname) {
            this.hostname = hostname;
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
