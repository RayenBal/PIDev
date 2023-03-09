import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class sms {
    // Twilio account SID and auth token
    public static final String ACCOUNT_SID = "AC7820afe394dbafb7a218a18b491c5c07";
    public static final String AUTH_TOKEN = "c1dc4b87078529383977c6dc59704523";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+12706759631";
    public static final String RECIPIENT_PHONE_NUMBER = "+21695411518";

    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber(RECIPIENT_PHONE_NUMBER),
                new PhoneNumber(TWILIO_PHONE_NUMBER),
                "Hello from Java!"
        ).create();

        System.out.println("SMS message SID: " + message.getSid());
    }
}