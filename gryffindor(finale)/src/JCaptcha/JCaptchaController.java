package JCaptcha;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.github.cage.Cage;
import com.github.cage.GCage;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.ByteArrayInputStream;
import javafx.scene.control.Button;
import javafx.scene.control.Button;

public class JCaptchaController {
    
    private Map<String, String> captchaMap = new ConcurrentHashMap<>();
    private Cage cage = new GCage();
    
    @FXML
    private ImageView captchaImageView;
    @FXML
    private Button refreshButton;
    
    @FXML
    public void initialize() {
        generateCaptcha();
    }
    
 private void generateCaptcha() {
    String captchaText = cage.getTokenGenerator().next();
    captchaMap.put(captchaText.toLowerCase(), captchaText);
    CaptchaImage captchaImage = new CaptchaImage(captchaText);
    Image captchaImageFX = new Image(new ByteArrayInputStream(captchaImage.getText().getBytes()));
    captchaImageView.setImage(captchaImageFX);
}

    
    public void refreshCaptcha() {
        generateCaptcha();
    }
    
    public boolean validateCaptcha(String captchaText) {
        String actualCaptchaText = captchaMap.get(captchaText.toLowerCase());
        return actualCaptchaText != null && actualCaptchaText.equals(captchaText);
    }
    
    private static class CaptchaImage extends OutputStream {
        
        private StringBuilder builder = new StringBuilder();
        
        public CaptchaImage(String captchaText) {
            builder.append(captchaText);
        }
        
        @Override
        public void write(int b) throws IOException {
            builder.append((char) b);
        }
        
        public String getText() {
            return builder.toString();
        }
    }
}
