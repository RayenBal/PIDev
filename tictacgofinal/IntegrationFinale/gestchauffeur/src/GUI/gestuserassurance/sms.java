/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.gestuserassurance;


/**
 *
 * @author sarra
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ASUS
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;


public class sms {
    // Twilio account SID and auth token
    public static final String ACCOUNT_SID = "AC6a164657d7c30aad1ee70fca45baf1fe";
    public static final String AUTH_TOKEN = "23bf591b33c82dd076da32692fb7b6f1";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+15675571734";
    public static final String RECIPIENT_PHONE_NUMBER = "+21650980376";

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