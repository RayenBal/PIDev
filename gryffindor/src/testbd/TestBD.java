/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbd;

import Entite.Compte;
import Entite.Historique;
import Services.ServiceCompte;
import Services.ServiceHistorique;
import java.sql.*;
import java.util.List;

/**
 *
 * @author Rayen 
 */
public class TestBD {

    private static Connection con;
    private static String url = "jdbc:mysql://localhost:3306/tictacgo";
    private static String login = "root";
    private static String pwd = "";
    private static Statement ste;

    public static void main(String[] args) {
        ServiceCompte ser = new ServiceCompte() {
            @Override
            public List<Compte> readAll() throws SQLException {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
        ServiceHistorique serH = new ServiceHistorique();
        Historique h2 = new Historique(20, "manourtiiiiiiiiiii", "Dhraief", "aaaaaaaaaaaaaaaaa");
        //Compte c2 = new Compte(10,"chauffeur","MANAR", "rrrrr@esprit.tn", "AAAAAAAA",h2);
        // TODO code application logic here
        try {
            con = DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie");
        } catch (SQLException e) {
            System.out.println(e);
        }
/*try{
                  ser.afficher(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
/*try{
                  ser.ajouter(c2);
        }catch (SQLException ex) {
            //System.out.println(ex);
        }*/
        List<Compte> l1 = null;

      /*try {
            l1 = ser.readAll();
        } catch (SQLException ex) {
            System.out.println(ex);
        }*/
        /*try{
                  ser.update(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        /* try{
                  ser.supprime(c2);
        }catch (SQLException ex) {
            System.out.println(ex);}*/
        l1.forEach(e -> {
            System.out.println(e);
        });
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
