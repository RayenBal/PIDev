/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entite.gui2;



/**
 *
 * @author ASUS
 */
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class sms {
    // Twilio account SID and auth token
    public static final String ACCOUNT_SID = "AC8b8803d6c9b49559a01c62a335a0da81";
    public static final String AUTH_TOKEN = "4609277f13e2d6296346de64028eb83d";

    // Twilio phone number and recipient phone number
    public static final String TWILIO_PHONE_NUMBER = "+15675571522";
    public static final String RECIPIENT_PHONE_NUMBER = "+21655861890";

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