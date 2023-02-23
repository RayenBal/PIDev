/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Compte;
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
public class ServiceCompte implements IService<Compte>{
 
    Connection con=DataSource.getInstance().getConnection();
    
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
 
    public void ajouter(Compte c) throws SQLException
    {
    String req = "INSERT INTO `compte`(`type_user`,`nom`, `email`, `mot_de_passe`, `id_historique`) VALUES (?,?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
   
     pre.setString(1,c.getType_user() );
     pre.setString(2,c.getNom() );
     pre.setString(3, c.getEmail());
     pre.setString(4, c.getMot_de_passe());
     pre.setString(5,Integer.toString(c.getId_historique()));
     
     pre.executeUpdate();
    }

    @Override
    public void update(Compte c) throws SQLException {
         String req="UPDATE `compte` SET `type_user`=?,`nom`=?,`email`=?,`mot_de_passe`=?,`id_historique`=? where `id_compte` ="+c.getIdc()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
         pre.setString(1,c.getType_user() );
         pre.setString(2,c.getNom() );
         pre.setString(3, c.getEmail());
         pre.setString(4, c.getMot_de_passe());
         pre.setString(5,Integer.toString(c.getId_historique()));
         pre.executeUpdate();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Compte c) throws SQLException {
         try{
            String req ="DELETE FROM `compte` WHERE id_compte ="+c.getIdc()+"";
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
            int id_historique=res.getInt(6);
         Compte c=new Compte(id_compte,type_user, nom, email, mot_de_passe,id_historique);
            System.out.println(c);
            listper.add(c);
        }
        return listper;
    }


    @Override
    public Compte findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean afficher(Compte c) throws SQLException {
        try{
            String req ="SELECT * FROM `compte` WHERE 1";
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
