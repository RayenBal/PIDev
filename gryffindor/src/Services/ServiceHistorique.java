/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Historique;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rayen
 */
public class ServiceHistorique implements IService<Historique>{
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Historique h;
    public ServiceHistorique() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void ajouter(Historique c) throws SQLException
    {
    String req = "INSERT INTO `historique`(`id_historique`,`nom`, `prenom`, `historique`) VALUES ( ?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
     pre.setString(1,Integer.toString(c.getId()));
     pre.setString(2,c.getNom() );
     pre.setString(3, c.getPrenom());
     pre.setString(4, c.getHistorique());
     
     pre.executeUpdate();
    }

    @Override
    public void update(Historique c) throws SQLException {
         String req="UPDATE `historique` SET `nom`=?,`prenom`=?,`historique`=? where `id_historique` ="+c.getId()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,c.getNom() );
         pre.setString(2, c.getPrenom());
         pre.setString(3, c.getHistorique());
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Historique c) throws SQLException {
         try{
            String req ="DELETE FROM `historique` WHERE id_historique ="+c.getId()+"";
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Historique> readAll() throws SQLException{
        ArrayList<Historique> listper=new ArrayList<>();
        
        String req="select * from historique";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id_historique=res.getInt(1);
            String nom=res.getString(2);
            String prenom=res.getString("prenom");
            String historique=res.getString(4);
            Historique c=new Historique(id_historique, nom, prenom, historique);
            System.out.println(c);
            listper.add(c);
        }
        return listper;
    }

    @Override
    public Historique findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public boolean afficher(Historique c) throws SQLException {
        try{
            String req ="SELECT * FROM `historique` WHERE 1";
         Statement state;
         Connection cnx=DataSource.getInstance().getConnection();
         state=cnx.createStatement();
         state.execute(req);
         return true ;
        }
        catch(SQLException ex){
            System.err.println(ex.getMessage());
            return false;
        }    
    }
 
    
}
