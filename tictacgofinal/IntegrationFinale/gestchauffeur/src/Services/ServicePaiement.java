/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Paiement;
import Utils.MyDB;
import Entite.Covoiturage;
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
public class ServicePaiement implements IService<Paiement>{
 
    Connection con=MyDB.getInstance().getConnection();
    
    private Statement ste;

    public ServicePaiement() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    @Override
    public void ajouter(Paiement t) throws SQLException {
            String req = "INSERT INTO `paiement` ( `idpy` , `Prix`, `descp`, `datepaiement`  , `paiementValide`, `M_id`) VALUES "
                    + "( '"+t.getId()+"','"+t.getmontant() +"', '"+t.getDescription()+"', '"+t.getDate()+"' , '"+t.getPvalide()+"' , '" +t.getM_id()+"');";

            System.out.println(req);
            ste.executeUpdate(req);
    }
    
    public void ajouterPST(Paiement p) throws SQLException
    {
     String req = "INSERT INTO `paiement` ( `idpy`,`Prix`, `descp`, `datepaiement`  , `paiementValide` , `M_id`) VALUES (?, ?, ?, ?,?, ?)";

     PreparedStatement pre=con.prepareStatement(req);
        
        pre.setInt(1,p.getId());
        pre.setDouble(2, p.getmontant());
        pre.setString(3, p.getDescription());
        pre.setDate(4, new java.sql.Date(p.getDate().getTime()));
         pre.setString(5, Integer.toString(p.getPvalide()));
        pre.setInt(6, p.getM_id());

        pre.executeUpdate();
    }
    
    

    @Override
    public void update(Paiement t) throws SQLException {
        String req = "UPDATE `paiement` SET `Prix`=?, `descp`=? ,`datepaiement`=?, `paiementValide`=? , `M_id`=? WHERE `idpy`=?";
        PreparedStatement pre = con.prepareStatement(req);

        pre.setDouble(1, t.getmontant());
        pre.setDate(3, new java.sql.Date(t.getDate().getTime()));
         pre.setString(2, t.getDescription());
        pre.setInt(4, t.getPvalide());
        pre.setInt(6, t.getId());
        pre.setInt(5, t.getM_id());
        pre.executeUpdate();
       // System.out.println(pre.executeUpdate());
        //throw new UnsupportedOperationException("Not supported yet.");
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean supprime(Paiement t) throws SQLException {
        String req = "DELETE FROM `paiement` WHERE `idpy`=?";
        PreparedStatement pre = con.prepareStatement(req);

        pre.setInt(1, t.getId());

        int res = pre.executeUpdate();

        return (res != 0);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Paiement> readAll() throws SQLException{
        ArrayList<Paiement> listper=new ArrayList<>();
        
        String req="select * from paiement";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int id=res.getInt(1);
            double montant=res.getDouble(2);
            String Description=res.getString(3);
            Date datePaiement=res.getDate(4);
            int paiementValide = res.getInt(5);
            int M_id = res.getInt(6);
            Paiement p=new Paiement(id, montant, Description ,  datePaiement ,paiementValide, M_id);
           // System.out.println(p);
            listper.add(p);
        }
        return listper;
    }

    @Override
    public Paiement findById(int id)  throws SQLException{
         String req = "SELECT * FROM `paiement` WHERE `idpy`=?";
        PreparedStatement pre = con.prepareStatement(req);

        pre.setInt(1, id);

        ResultSet res = pre.executeQuery();

        if (res.next()) {
            double montant = res.getDouble(2);
            String Description = res.getString(3);
            Date datePaiement = res.getDate(4);
            int paiementValide = res.getInt(5);
            int M_id = res.getInt(6);
            Paiement p = new Paiement(id, montant , Description , datePaiement , paiementValide, M_id);

            return p;
        } else {
            return null;
        }
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
