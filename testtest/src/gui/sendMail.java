package gui ; 
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class sendMail {
   public static void main(String[] args) throws Exception {
      // Set properties
      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "587");

      // Create a Session object
      Session session = Session.getInstance(props, new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("sarra.bellassoued@esprit.tn", "201JFT1850");
         }
      });

      try {
         // Create a MimeMessage object
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress("sarra.bellassoued@esprit.tn"));
         message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("mohamedachraf.zribi@esprit.tn"));
         message.setSubject("Testing Email");
         message.setText("Hello, This is a test email");

         // Send the message
         Transport.send(message);
         System.out.println("Email sent successfully.");
      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
   }
}
