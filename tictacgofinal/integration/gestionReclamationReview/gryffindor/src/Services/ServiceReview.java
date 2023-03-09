/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Review;
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
public class ServiceReview implements IServiceReview<Review>{
      Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Review r;
    public ServiceReview() {
        
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
    
    public void ajouter(Review r) throws SQLException
    {
    String req = "INSERT INTO `review`(`avis`) VALUES ( ?);";

     PreparedStatement pre=con.prepareStatement(req);
        
     pre.setString(1,r.getAvis() );
     pre.executeUpdate();
    }

    
    @Override
    public void update(Review r) throws SQLException {
         String req="UPDATE `review` SET `avis`=? where `int_review` ='"+r.getIdr()+"'";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,r.getAvis() );
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Review r) throws SQLException {
         try{
            String req ="DELETE FROM `review` WHERE `int_review` ='"+r.getIdr()+"'";
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
    public List<Review> readAll() throws SQLException{
        ArrayList<Review> listper=new ArrayList<>();
        
        String req="select * from review";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int int_review=res.getInt(1);
            String avis=res.getString(2);
            Review r=new Review(int_review, avis);
            System.out.println(r);
            listper.add(r);
        }
        return listper;
    }

    
    @Override
    public Review findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean afficher(Review r) throws SQLException {
        try{
            String req ="SELECT * FROM `review` WHERE 1";
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
