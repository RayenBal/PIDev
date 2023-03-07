package utils;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendMail {

  public static void send(String to, String subject, String text) {
    // Sender's email ID needs to be mentioned
    String from = "sarra.bellassoued@esprit.tn"; // Replace with your Gmail address

    // Gmail SMTP server details
    String host = "smtp.gmail.com";
    int port = 587;

    // Get system properties
    Properties properties = System.getProperties();

    // Setup mail server
    properties.put("mail.smtp.host", host);
    properties.put("mail.smtp.port", port);
    properties.put("mail.smtp.auth", "true");
    properties.put("mail.smtp.starttls.enable", "true");

    // Get the default Session object.
    Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("mail mteeek houni", "mdp mail"); // Replace with your Gmail address and password
        }
    });

    try {
       // Create a default MimeMessage object.
       MimeMessage message = new MimeMessage(session);

       // Set From: header field of the header.
       message.setFrom(new InternetAddress(from));

       // Set To: header field of the header.
       message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

       // Set Subject: header field
       message.setSubject(subject);

       // Now set the actual message
       message.setText(text);

       // Send message
       Transport.send(message);
       System.out.println("Sent message successfully....");
    } catch (MessagingException mex) {
       mex.printStackTrace();
    }
  }
}
