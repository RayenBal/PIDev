/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Rayen
 */
public class SignIn  extends Application{
    
    Connection con;
    PreparedStatement ste;
    public SignIn(){
       con=DataSource.getInstance().getConnection();
    }
    
    public boolean checkCredentials(String email, String password) throws SQLException {
        boolean isValid = false;
        PreparedStatement stmt = null;
        ResultSet rs = null;
      
            // Prepare a statement to check for the existence of the email and password combination
            stmt = con.prepareStatement("SELECT COUNT(*) FROM compte WHERE email = ? AND mot_de_passe = ?");
            stmt.setString(1, email);
            
            stmt.setString(2, password);
           
            // Execute the query and get the result set
            rs = stmt.executeQuery();
            
            // Check the result set to see if the email and password combination exists
            if (rs.next()) {
                int count = rs.getInt(1);
                isValid = (count > 0);
            }
        
        return isValid;
    }

    @Override
    public void start(Stage stage) throws Exception {
       Parent root = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        
    }
    
   
    public static void main(String[] args) {
        launch(args);
    }
}
