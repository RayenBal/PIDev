/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Reclamation;
import Entite.Reclamation;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sanabenfadhel
 */
public class ServiceReclamation implements IService<Reclamation>{
 
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Reclamation r;
    public ServiceReclamation() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    /*public void ajouter(Reclamation c) throws SQLException {
            String req = "INSERT INTO `reclamation`(`id_reclamation`, `description`, `email`, `mot_de_passe`) VALUES "
                    + "( '"+c.getNom()+"', '"+c.getEmail()+"', '"+c.getMot_de_passe()+"');";

            
            ste.executeUpdate(req);
    }*/
    
    public void ajouter(Reclamation r) throws SQLException
    {
    String req = "INSERT INTO `reclamation`(`description`, `date_creation`, `idp`, `idc`) VALUES ( ?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
     pre.setString(1,r.getDescription() );
     pre.setString(2, r.getDate_creation());
     pre.setString(3,Integer.toString(r.getIdp()));
     pre.setString(4,Integer.toString(r.getIdc()));
     pre.executeUpdate();
    }

    
    @Override
    public void update(Reclamation r) throws SQLException {
         String req="UPDATE `reclamation` SET `description`=?,`date_creation`=? where `id_reclamation` ="+r.getId()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,r.getDescription() );
         pre.setString(2, r.getDate_creation());
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Reclamation r) throws SQLException {
         try{
            String req ="DELETE FROM `reclamation` WHERE id_reclamation ="+r.getId()+"";
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
    public List<Reclamation> readAll() throws SQLException{
        ArrayList<Reclamation> listper=new ArrayList<>();
        
        String req="select * from reclamation";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id_reclamation=res.getInt(1);
            String description=res.getString(2);
            String date_creation=res.getString("date_creation");
            int idp=res.getInt(4);
            int idc=res.getInt(5);
            Reclamation r=new Reclamation(id_reclamation, description, date_creation,idp,idc);
            System.out.println(r);
            listper.add(r);
        }
        return listper;
    }

    
    @Override
    public Reclamation findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean afficher(Reclamation r) throws SQLException {
        try{
            String req ="SELECT * FROM `reclamation` WHERE 1";
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
