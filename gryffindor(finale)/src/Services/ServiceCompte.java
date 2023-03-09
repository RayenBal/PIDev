/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Compte;
import Utils.MyDB;
//import gui.gestpaiement.FXMLController;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

/**
 *
 * @author Rayen
 */
public class ServiceCompte implements IServiceCompte<Compte>{
 
    Connection con=MyDB.getInstance().getConnection();
    
    private Statement ste;
    private Compte c;
    public ServiceCompte() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    /*public void ajouter(Compte c) throws SQLException {
            String req = "INSERT INTO `compte`(`id_compte`, `nom`, `email`, `mot_de_passe`) VALUES "
                    + "( '"+c.getNom()+"', '"+c.getEmail()+"', '"+c.getMot_de_passe()+"');";

            
            ste.executeUpdate(req);
    }*/
 
    @Override
    public void ajouter(Compte c) throws SQLException
    {
    String req = "INSERT INTO `compte`(`type_user`,`nom`, `email`, `mot_de_passe`) VALUES (?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
   
     pre.setString(1,c.getType_user() );
     pre.setString(2,c.getNom() );
     pre.setString(3, c.getEmail());
     pre.setString(4, c.getMot_de_passe());
     
     pre.executeUpdate();
    }

    @Override
    public void update(Compte c) throws SQLException {
         String req="UPDATE `compte` SET `type_user`=?,`nom`=?,`email`=?,`mot_de_passe`=? where `email` ='"+c.getEmail()+"'";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,c.getType_user() );
         pre.setString(2,c.getNom() );
         pre.setString(3, c.getEmail());
         pre.setString(4, c.getMot_de_passe());
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Compte c) throws SQLException {
         try{
            String req = "DELETE FROM `compte` WHERE `email` = '" + c.getEmail() + "'";
         Statement state;
         Connection cnx=MyDB.getInstance().getConnection();
         state=cnx.createStatement();
         state.execute(req);
         return true;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Compte> readAll() throws SQLException{
        ArrayList<Compte> listper=new ArrayList<>();
        
        String req="select * from compte";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id_compte=res.getInt(1);
            String type_user=res.getString(2);
            String nom=res.getString(3);
            String email=res.getString("email");
            String mot_de_passe=res.getString(5);
         Compte c=new Compte(id_compte,type_user, nom, email, mot_de_passe);
            System.out.println(c);
            listper.add(c);
        }
        return listper;
    }
    public String findByEmail(String EmailS)  throws SQLException{
        String req = "SELECT `mot_de_passe` FROM `compte` WHERE `email` ='"+EmailS+"'";

         Statement stmt = con.createStatement();
    ResultSet res = stmt.executeQuery(req);

        if (res.next()) {
            String mp = res.getString("mot_de_passe");
            return mp;
        }
        return null;
    }
    
    public boolean afficher(Compte c) throws SQLException {
        try{
            String req ="SELECT * FROM `compte` WHERE 1";
         Statement state;
         Connection cnx=MyDB.getInstance().getConnection();
         state=cnx.createStatement();
         state.execute(req);
         return true ;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }    
    }

    public Compte findById(int id_compte) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
        
        
       
    public String getUserType(String EmailS) throws SQLException {
    String req = "SELECT `type_user` FROM `compte` WHERE `email` ='"+EmailS+"'";

         Statement stmt = con.createStatement();
    ResultSet res = stmt.executeQuery(req);

        if (res.next()) {
            String type_user = res.getString("type_user");
            return type_user;
        }
        return null;
}
}
