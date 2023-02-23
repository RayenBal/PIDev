/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import Entite.Reclamation;
import Services.ServiceReclamation;
import java.sql.*;
import java.util.List;

/**
 *
 * @author 
 */
public class TestBD {

    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/tictacgo";
    private static String login = "root";
    private static String pwd = "";
    private static Statement ste;

    public static void main(String[] args) {
        ServiceReclamation ser = new ServiceReclamation();
        //Reclamation r2 = new Reclamation(10,"RAYENNNNNNNNN", "22/02/2023");
        // TODO code application logic here
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException e) {
            System.out.println(e);
        }
/*try{
                  ser.afficher(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}

try{
                  ser.ajouter(r2);
        }catch (SQLException ex) {
            //System.out.println(ex);
        }
        List<Reclamation> l1 = null;*/

      /*try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
       /* try{
                  ser.update(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        /* try{
                  ser.supprime(r2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        /*l1.forEach(e -> {
            System.out.println(e);
        });*/
        /*try {
            ste = con.createStatement();

            String req = "INSERT INTO `compte`(`id_compte`, `nom`, `email`, `mot_de_passe`) VALUES ( ?,?,?,?);";

            int res = ste.executeUpdate(req);
            System.out.println(res);
            
            ResultSet rest=ste.executeQuery("select * from compte");
            while (rest.next()) {                
                int id_compte=rest.getInt(1);
                String nom=rest.getString("nom");
                String email=rest.getString("email");
                String mot_de_passe=rest.getString("mot_de_passe");
                
                System.out.println("id_compte :"+id_compte+" nom :"+nom+
                        " email :"+email+" mot_de_passe :"+mot_de_passe);
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
    }

}
