/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Blacklist;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ServiceBlacklist {
     Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Blacklist b;
    public ServiceBlacklist() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    

    
    public void ajouter(Blacklist b) throws SQLException
    {
    String req = "INSERT INTO `blacklist`(`list`, `nb_reclamation`, `idp`, `idc`) VALUES ( ?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
     pre.setString(1,b.getList() );
     pre.setString(2, Integer.toString(b.getNb_reclamation()));
      pre.setString(3,Integer.toString(b.getIdp()));
     pre.setString(4,Integer.toString(b.getIdc()));
     pre.executeUpdate();
    }

    
    public void update(Blacklist b) throws SQLException {
         String req="UPDATE `blacklist` SET `list`=?,`nb_reclamation`=? where `id_blacklist` ="+b.getId()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,b.getList() );
         pre.setString(2, Integer.toString(b.getNb_reclamation()));
       
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public boolean supprime(Blacklist b) throws SQLException {
         try{
            String req ="DELETE FROM `blacklist` WHERE id_blacklist ="+b.getId()+"";
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

    
    
    public List<Blacklist> readAll() throws SQLException{
        ArrayList<Blacklist> listper=new ArrayList<>();
        
        String req="select * from blacklist";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id_blacklist=res.getInt(1);
            String list=res.getString("list");
            int nb_reclamation =res.getInt(3);
                 int idp=res.getInt(4);
                 int idc=res.getInt(5);
            Blacklist b=new Blacklist(id_blacklist, list, nb_reclamation,idp,idc);
            System.out.println(b);
            listper.add(b);
        }
        return listper;
    }

  
    public Blacklist findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean afficher(Blacklist b) throws SQLException {
        try{
            String req ="SELECT * FROM `blacklist` WHERE 1";
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
