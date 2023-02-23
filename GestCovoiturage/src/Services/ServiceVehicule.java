/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author ADMIN
 */
import Entite.Vehicule;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;




/**
 *
 * @author ADMIN
 */
public class ServiceVehicule implements IService <Vehicule>{
 
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private Vehicule c;

    public ServiceVehicule() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    @Override
    public boolean  ajouter(Vehicule c) throws SQLException
    {
                boolean verif=true;

    try {   String req = "INSERT INTO `Vehicule`(`immatriculation`,`modele`, `marque`, `type`, `idc` , `nb_places`) VALUES ( ?,?,?,?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        pre.setString(1, c.getImmatriculation());
        pre.setString(2, c.getModele());
        pre.setString(3, c.getMarque());
        pre.setString(4, c.getType());

        pre.setInt(5, c.getIdc());
        pre.setInt(6, c.getNb_places());
        
        
        pre.executeUpdate();

         int rowsInserted = pre.executeUpdate();
     if (rowsInserted > 0) {
        
                           }
            
     }catch(SQLException e){
            System.out.println(e);
            verif=false;
        }
    return verif;
    }

    public void update_vehicule(Vehicule v) throws SQLException {
        String req="UPDATE `vehicules` SET `modele`=?,`marque`=?,`type`=?,`idc`=?,`nb_places`=?, where `immatriculation` ="+v.getImmatriculation()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
       
        pre.setString(1,v.getModele() );
        pre.setString(2,v.getMarque() );
        pre.setString(3,v.getType() );
        pre.setString(4,Integer.toString(v.getIdc()));
        pre.setString(5,Integer.toString(v.getNb_places()));
         pre.executeUpdate();
    }

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
    public boolean supprimer_vehicule(Vehicule v) throws SQLException {
        try{
            String req ="DELETE FROM `vehicules` WHERE immatriculation ="+v.getImmatriculation()+"";
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

    
 /* @Override
    public List<Vehicule> readAll() throws SQLException {
        ArrayList<Vehicule> listveh = new ArrayList<>();

        String req = "select * from Vehicule";

        ResultSet res = ste.executeQuery(req);

        while (res.next()) {
            String immatriulation = res.getString("immatriculation");
            String modele = res.getString("modele");
            String marque = res.getString("depart");
            String type = res.getString("type");
          
            int idc = res.getInt(5);
            int nb_place = res.getInt(6);
 
            Vehicule v;
            //v = new Vehicule("immatriculation", modele, marque, type, idc , nbr_place );
            // System.out.println(p);
            listveh.add(v);
        }
        return listveh;
    }
    @Override
    public Vehicule findById(int id)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
       */

 
   /* public boolean afficher(Vehicule t) throws SQLException {
        try{
            String req ="SELECT * FROM `Vehicule` WHERE immatriculation ='2' ";
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
    }/*
}
   */ 

    @Override
    public void update(Vehicule c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Vehicule c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
   

    public boolean afficher(Vehicule c) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vehicule> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vehicule findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}

