/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Assurance;
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
public class ServiceAssurance implements IServiceAssurance<Assurance>{
     Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Assurance a;
    public ServiceAssurance() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    /*public void ajouter(Assurance c) throws SQLException {
            String req = "INSERT INTO `compte`(`id_assurance`, `nom`, `email`, `mot_de_passe`) VALUES "
                    + "( '"+c.getNom()+"', '"+c.getEmail()+"', '"+c.getMot_de_passe()+"');";

            
            ste.executeUpdate(req);
    }*/
 
    @Override
    public void ajouter(Assurance a) throws SQLException
    {
    String req = "INSERT INTO `assurance`(`date_validité`, `immatriculation`) VALUES (?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
   
     pre.setString(1,a.getDate_validité() );
     pre.setString(2,a.getImmatriculation() );
     
     pre.executeUpdate();
    }

    @Override
    public void update(Assurance a) throws SQLException {
         String req="UPDATE `assurance` SET `date_validité`=?,`immatriculation`=? where `immatriculation` ='"+a.getImmatriculation()+"'";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,a.getDate_validité() );
         pre.setString(2,a.getImmatriculation() );
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Assurance a) throws SQLException {
         try{
            String req = "DELETE FROM `assurance` WHERE `immatriculation` = '" + a.getImmatriculation() + "'";
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
    public List<Assurance> readAll() throws SQLException{
        ArrayList<Assurance> listper=new ArrayList<>();
        
        String req="select * from assurance";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id_assurance=res.getInt(1);
            String date_validité=res.getString(2);
            String immatriculation=res.getString(3);
         Assurance c=new Assurance(id_assurance,date_validité, immatriculation);
            System.out.println(c);
            listper.add(c);
        }
        return listper;
    }


    @Override
    public Assurance findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean afficher(Assurance a) throws SQLException {
        try{
            String req ="SELECT * FROM `assurance` WHERE 1";
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
