/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Entite.PaymentMethod;
import java.sql.SQLException;
import java.util.List;

import Utils.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author INFOTEC
 */
public class ServicePaymentMeth implements IService<PaymentMethod> {
    
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;

    public ServicePaymentMeth() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @Override
    public void ajouter(PaymentMethod t) throws SQLException {
        String req = "INSERT INTO `payment_method` ( `M_id`,`UserID`, `type`) VALUES (?, ?, ?)";

     PreparedStatement pre=con.prepareStatement(req);
        
        pre.setInt(1,t.getId());
        pre.setInt(2, t.getUserID());
        pre.setInt(3, t.getType());
        

        pre.executeUpdate();
       }

    @Override
    public void update(PaymentMethod t) throws SQLException {
        String req = "UPDATE `payment_method` SET `UserID`=?, `type`=? WHERE `M_id`=?";
        PreparedStatement pre = con.prepareStatement(req);

        
        pre.setInt(1, t.getUserID());
        pre.setInt(2, t.getType());
        pre.setInt(3, t.getId());
        

        pre.executeUpdate();
         }

    @Override
    public boolean supprime(PaymentMethod t) throws SQLException {
        String req = "DELETE FROM `payment_method` WHERE `M_id`=?";
        PreparedStatement pre = con.prepareStatement(req);

        pre.setInt(1, t.getId());

        int res = pre.executeUpdate();

        return (res != 0);
        }

    @Override
    public List<PaymentMethod> readAll() throws SQLException {
         ArrayList<PaymentMethod> listper=new ArrayList<>();
        
        String req="select * from `payment_method`";
        
        ResultSet res=ste.executeQuery(req);
        
        System.out.println("this is working ");
        while (res.next()) {            
            int id=res.getInt(1);
            int idUser=res.getInt(2);
            int type=res.getInt(3);
            PaymentMethod p=new PaymentMethod(id, idUser, type );
            
            listper.add(p);
        }
        return listper;
          }

    @Override
    public PaymentMethod findById(int id) throws SQLException {
        String req = "SELECT * FROM `payment_method` WHERE `M_id`=?";
        PreparedStatement pre = con.prepareStatement(req);

        pre.setInt(1, id);

        ResultSet res = pre.executeQuery();

        if (res.next()) {
            int userID = res.getInt(2);
            int type = res.getInt(3);
            
            PaymentMethod p = new PaymentMethod(id, userID , type );

            return p;
        } else {
            return null;
        }
       }
    
}
