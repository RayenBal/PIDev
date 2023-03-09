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
        
        
       // pre.executeUpdate();

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
    String req = "UPDATE `Vehicule` SET `modele`=?,`marque`=?,`type`=?,`idc`=?,`nb_places`=? WHERE `immatriculation` = ?";

    if (v.getImmatriculation() == null || v.getImmatriculation().isEmpty()) {
        throw new SQLException("Immatriculation cannot be empty");
    }

    if (v.getMarque() == null || v.getMarque().isEmpty()) {
        throw new SQLException("Marque cannot be empty");
    }

    if (v.getModele() == null || v.getModele().isEmpty()) {
        throw new SQLException("Modele cannot be empty");
    }

    if (v.getType() == null || v.getType().isEmpty()) {
        throw new SQLException("Type cannot be empty");
    }

    

    



    PreparedStatement pre = con.prepareStatement(req);

    pre.setString(1, v.getModele());
    pre.setString(2, v.getMarque());
    pre.setString(3, v.getType());
    pre.setInt(4, v.getIdc());
    pre.setInt(5, v.getNb_places());
    pre.setString(6, v.getImmatriculation());

    pre.executeUpdate();
}

    /**
     *
     * @param v
     * @return
     * @throws SQLException
     */
   public boolean supprimer_vehicule(Vehicule c) throws SQLException {
    try {
        String req = "DELETE FROM `Vehicule` WHERE immatriculation = ?";
        PreparedStatement ps;
        Connection cnx = DataSource.getInstance().getConnection();
        ps = cnx.prepareStatement(req);
        ps.setString(1, c.getImmatriculation());
        ps.executeUpdate();
        return true;
    } catch (SQLException ex) {
        System.err.println(ex.getMessage());
        return false;
    }
}


    
@Override
public List<Vehicule> readAll() throws SQLException {
    ArrayList<Vehicule> listveh = new ArrayList<>();
    String req = "select * from Vehicule";
    ResultSet res = ste.executeQuery(req);
    while(res.next()) {
        String immatriculation = res.getString(1);
        String marque = res.getString(2);
        String modele = res.getString(3);
        String type = res.getString(4);
        int idc = res.getInt(5);
        int nb_places = res.getInt(6);
        Vehicule c = new Vehicule(immatriculation,marque,modele,type,idc,nb_places);
        listveh.add(c);
    
    }
    return listveh;










}

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

    /*@Override
    public List<Vehicule> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    @Override
    public Vehicule findById(int id) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public List<Vehicule> searchVehicule(String query) throws SQLException {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    List<Vehicule> result = new ArrayList<>();
    
    try {
        conn = DataSource.getInstance().getConnection();
        String sql = "SELECT * FROM vehicule WHERE marque LIKE ? OR modele LIKE ?";
        stmt = conn.prepareStatement(sql);
        stmt.setString(1, "%" + query + "%");
        stmt.setString(2, "%" + query + "%");
        rs = stmt.executeQuery();

        while (rs.next()) {
            Vehicule v = new Vehicule();
            v.setImmatriculation(rs.getString("immatriculation"));
            v.setMarque(rs.getString("marque"));
            v.setModele(rs.getString("modele"));
            v.setType(rs.getString("type"));
            v.setNb_places(rs.getInt("nb_places"));
            result.add(v);
        }
    } catch (SQLException e) {
        // handle the SQLException here
        // you can log the error or throw a custom exception to inform the caller of the method
        throw new RuntimeException("An error occurred while searching for vehicles.", e);
    } finally {
        // close the ResultSet, PreparedStatement, and Connection in the finally block
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return result;
}



  
}

