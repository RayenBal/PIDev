/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entites.Passager;
import utils.DataSource;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author medzr
 */
public class PassagerService {
    
     Connection con=DataSource.getInstance().getConnection();
    
    public void ajouter(Passager p) throws SQLException
    {
    String req = "INSERT INTO `passager`(`nomp`, `prenomp`, `nump`, `adressep`, `emailp`) VALUES (?,?,?,?,?)";

     PreparedStatement pre=new DataSource().getConnection().prepareStatement(req);
        
        
     pre.setString(1,p.getNomp());
     pre.setString(2, p.getPrenomp());
        pre.setString(3,p.getNump());
        pre.setString(4,p.getAdressep());
        pre.setString(5,p.getEmailp());    
     pre.executeUpdate();
    }

public List<Passager> readAll() throws SQLException{
        ArrayList<Passager> listper=new ArrayList<>();
        
        String req="SELECT `nomp`, `prenomp`, `nump`, `adressep`, `emailp` FROM `passager`";
        
        ResultSet res=con.createStatement().executeQuery(req);
        
        
        while (res.next()) {            
            String nomp=res.getString(1);
            String prenomp=res.getString(2);
            String nump=res.getString(3);
            String adressep=res.getString(4);
            String emailp=res.getString(5);
            
            
            Passager c=new Passager();
            c.setNomp(nomp);
            c.setPrenomp(prenomp);
            c.setEmailp(emailp);
            c.setAdressep(adressep);
            c.setNump(nump);
            
           System.out.println(c);
            listper.add(c);
        }
        return listper;
    }
public void update(Passager c,int id) throws SQLException {
        String req="UPDATE `passager` SET `nomp`=?,`prenomp`=?,`nump`=?,`adressep`=?,`emailp`=? where `idp` ="+id+"";
        
        PreparedStatement pre=con.prepareStatement(req);
     
         pre.setString(1,c.getNomp() );
         pre.setString(2,c.getPrenomp());
         pre.setString(3,c.getNump());
         pre.setString(4,c.getAdressep());
         pre.setString(5,c.getEmailp());
         
         
         pre.executeUpdate();
    }
   public boolean supprime(Passager c, int id) throws SQLException {
        try{
            String req ="DELETE FROM `passager` WHERE idp ="+id+"";
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




}
