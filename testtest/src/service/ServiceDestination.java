/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Destination;
import utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author sarra
 */
public class ServiceDestination implements IService<Destination>{
 
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Destination d;

    public ServiceDestination() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    

   /* public void ajouter(Destination dp) throws SQLException
    {
    String req = "INSERT INTO `destination`(`idd`, `gouvernorat`, `adressed`) VALUES (?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
     pre.setString(1,Integer.toString(dp.getIdd()));
     pre.setString(2,dp.getGouvernorat() );
     pre.setString(3, dp.getAdressed());
    
     pre.executeUpdate();
    }*/
    
    
    
    public void ajouter(Destination dp) throws SQLException, IllegalArgumentException {
    if(dp.getIdd() < 0) {
        throw new IllegalArgumentException("L'identifiant de la destination doit être supérieur ou égal à zéro.");
    }
    if(dp.getGouvernorat() == null || dp.getGouvernorat().isEmpty()) {
        throw new IllegalArgumentException("Le gouvernorat de la destination ne peut pas être vide.");
    }
    if(dp.getAdressed() == null || dp.getAdressed().isEmpty()) {
        throw new IllegalArgumentException("L'adresse de la destination ne peut pas être vide.");
    }

    // Le reste de votre code
    String req = "INSERT INTO `destination`(`idd`, `gouvernorat`, `adressed`) VALUES (?,?,?);";
    PreparedStatement pre=con.prepareStatement(req);
    pre.setString(1,Integer.toString(dp.getIdd()));
    pre.setString(2,dp.getGouvernorat() );
    pre.setString(3, dp.getAdressed());
    pre.executeUpdate();
}
    public void afficherDestinations() throws SQLException {
String req = "SELECT * FROM destination;";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(req);
while(rs.next()) {
    int idd = rs.getInt("idd");
    String gouvernorat = rs.getString("gouvernorat");
    String adresse = rs.getString("adressed");
    
    System.out.println("Destination ID: " + idd);
    System.out.println("Gouvernorat: " + gouvernorat);
    System.out.println("Adresse: " + adresse);
    System.out.println("------------------------");
}
    }


    
    public void update(Destination dp) throws SQLException {
        String req="UPDATE `destination` SET `gouvernorat`=?,`adressed`=?, where `idd` ="+dp.getIdd()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,Integer.toString(dp.getIdd()));
     pre.setString(2,dp.getGouvernorat() );
     pre.setString(3, dp.getAdressed());
     pre.executeUpdate();
    }

   
    public boolean supprime(Destination dp) throws SQLException {
        try{
            String req ="DELETE FROM `destination` WHERE idd ="+dp.getIdd()+"";
         Statement state;
         Connection cnx=DataSource.getInstance().getConnection();
         state=cnx.createStatement();
         state.execute(req);
         return true;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public List<Destination> readAll() throws SQLException{
        ArrayList<Destination> listper=new ArrayList<>();
        
        String req="select * from destination";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int idd=res.getInt(1);
            String gouvernorat=res.getString(2);
            String adressed=res.getString(3);
            
          
    
            Destination dp=new Destination(idd, gouvernorat, adressed);
           System.out.println(dp);
            listper.add(dp);
        }
        return listper;
    }


    public Destination findById(int idd)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void affiche(Destination d2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
