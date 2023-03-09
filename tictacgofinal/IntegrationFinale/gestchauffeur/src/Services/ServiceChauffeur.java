/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Chauffeur;
import Utils.MyDB;
import Entite.Covoiturage;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author sanabenfadhel
 */
public class ServiceChauffeur implements IService<Chauffeur>{
 
    Connection con=MyDB.getInstance().getConnection();
    
    private Statement ste;
    private Chauffeur p;

    public ServiceChauffeur() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void ajouter(Chauffeur c) throws SQLException
    {
    String req = "INSERT INTO `chauffeur`(`nomc`, `prenomc`, `numc`, `adressec`, `emailc`,`idd`) VALUES (?,?,?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
  
     pre.setString(1,c.getNomc() );
     pre.setString(2, c.getPrenomc());
     pre.setString(3, c.getNumc());
     pre.setString(4, c.getAdressec());
     pre.setString(5, c.getEmailc());
     pre.setInt(6,c.getIdd());
                
 
     
     pre.executeUpdate();
    }

    @Override
    public void update(Chauffeur c) throws SQLException {
        String req="UPDATE `chauffeur` SET `nomc`=?,`prenomc`=?,`numc`=?,`adressec`=?,`emailc`=? ,`idd`=? where `idc` ="+c.getIdc()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
     
         pre.setString(1,c.getNomc() );
         pre.setString(2, c.getPrenomc());
         pre.setString(3, c.getNumc());
         pre.setString(4, c.getAdressec());
         pre.setString(5, c.getEmailc());
         pre.setInt(6,c.getIdd());
         
         pre.executeUpdate();
    }

    @Override
    public boolean supprime(Chauffeur c) throws SQLException {
        try{
            String req ="DELETE FROM `chauffeur` WHERE idc ="+c.getIdc()+"";
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
    }

    @Override
    public List<Chauffeur> readAll() throws SQLException{
        ArrayList<Chauffeur> listper=new ArrayList<>();
        
        String req="select * from chauffeur";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int idc=res.getInt(1);
            String nomc=res.getString(2);
            String prenomc=res.getString(3);
            String numc=res.getString(4);
            String adressec=res.getString(5);
            String emailc=res.getString(6);
            int idd=res.getInt(7);
            
            Chauffeur c=new Chauffeur(idc, nomc, prenomc, numc,adressec,emailc,idd);
           System.out.println(c);
            listper.add(c);
        }
        return listper;
    }

    @Override
    public Chauffeur findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ajouter(Covoiturage t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Covoiturage t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Covoiturage t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
