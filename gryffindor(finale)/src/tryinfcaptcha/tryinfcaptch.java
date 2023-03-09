package tryinfcaptcha; 

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class tryinfcaptch extends Application {
     private String siteKey = "6LcDYd0kAAAAADnf4b0LWZxQvFxOWXZbFUQco32J";
    private String secretKey = "6LcDYd0kAAAAACFhzJ8cBFsoRlgumjlEivMc9qz4";

    @Override
    public void start(Stage primaryStage) throws Exception {
        
         StackPane root = new StackPane();
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        //engine.load("https://www.google.com/recaptcha/api.js?render=" + siteKey);
        engine.load("https://www.youtube.com/watch?v=yK9DeQFgt1g");
        root.getChildren().add(webView);
        primaryStage.setTitle("reCAPTCHA Example");
      //  system.out.println("helloo");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


/*import javafx.application.Application;
import javafx.concurrent.Worker;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;

public class tryinfcaptch extends Application {

    @Override
    public void start(Stage primaryStage) {
        WebView webView = new WebView();
        WebEngine engine = webView.getEngine();
        engine.getLoadWorker().stateProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == Worker.State.SUCCEEDED) {
                // Execute reCAPTCHA script
                JSObject window = (JSObject) engine.executeScript("window");
                window.setMember("recaptchaCallback", new RecaptchaCallback());
                engine.executeScript("grecaptcha.enterprise.ready(function() { " +
                        "grecaptcha.enterprise.execute('6LfQF9skAAAAAOhFkGSU_qGh5k3mhXs3JO0_tzAb', {action: 'login'})" +
                        ".then(function(token) { recaptchaCallback.onSuccess(token); }); });");
            }
        });
        engine.load("https://www.google.com/recaptcha/enterprise.js?render=6LfQF9skAAAAAOhFkGSU_qGh5k3mhXs3JO0_tzAb");

        primaryStage.setScene(new Scene(webView, 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class RecaptchaCallback {
        public void onSuccess(String token) {
            System.out.println("reCAPTCHA token: " + token);
        }
    }
}*/

