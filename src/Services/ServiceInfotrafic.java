/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Entite.Chauffeur;
import Entite.infotrafic;
import Utils.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import java.util.Map;


/**
 *
 * @author 
 */
public class ServiceInfotrafic implements IService<infotrafic>{
 
    Connection con=DataSource.getInstance().getConnection();
    
    private Statement ste;
    private infotrafic i;

    public ServiceInfotrafic() {
        
        try {
            ste=con.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @Override
    public void ajouter(infotrafic it) throws SQLException
    {
    String req = "INSERT INTO `infotrafic`(`type`, `description`,`idc`) VALUES (?,?,?);";

     PreparedStatement pre=con.prepareStatement(req);
        
        
     pre.setString(1,it.getType());
     pre.setString(2, it.getDescription());
        pre.setInt(3,it.getIdc());
        
     
    
     pre.executeUpdate();
    }

    @Override
    public void update(infotrafic it) throws SQLException {
        String req="UPDATE `infotrafic` SET `type`=?,`description`=?,`idc`=? WHERE `idi` ="+it.getIdi()+"";
        
        PreparedStatement pre=con.prepareStatement(req);
  
     pre.setString(1,it.getType() );
     pre.setString(2, it.getDescription());
       pre.setInt(3,it.getIdc());
     
     pre.executeUpdate();
    }

    @Override
    public boolean supprime(infotrafic it) throws SQLException {
        try{
            String req ="DELETE FROM `infotrafic` WHERE idi ="+it.getIdi()+"";
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

    @Override
    public List<infotrafic> readAll() throws SQLException{
        ArrayList<infotrafic> listper=new ArrayList<>();
        
      Chauffeur c1=new Chauffeur();
      infotrafic f1=new infotrafic(); 
        
        String req="select * from infotrafic";
        
        ResultSet res=ste.executeQuery(req);
        
        
        while (res.next()) {            
            int idi=res.getInt(1);
            String type=res.getString(2);
            String description=res.getString(3);
            int idc=res.getInt(4);
             // res.getObject(f1.getIdc(), (Map<String, Class<?>>) c1);
            
          
    
            infotrafic it=new infotrafic(idi, type, description,idc);
           System.out.println(it);
            listper.add(it);
        }
        return listper;
    }


    @Override
    public infotrafic findById(int idi)  throws SQLException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
