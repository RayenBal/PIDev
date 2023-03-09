package Services;

import Entite.Destination;
import Utils.MyDB;
import Entite.Covoiturage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDestination implements IService<Destination> {

    private Connection con = MyDB.getInstance().getConnection();

    @Override
    public void ajouter(Destination dp) throws SQLException {
        String req = "INSERT INTO `destination`(`idd`, `gouvernorat`, `adressed`) VALUES (?,?,?);";

        PreparedStatement pre = con.prepareStatement(req);

        pre.setInt(1, dp.getIdd());
        pre.setString(2, dp.getGouvernorat());
        pre.setString(3, dp.getAdressed());

        pre.executeUpdate();
    }

    @Override
    public List<Destination> readAll() throws SQLException {
        ArrayList<Destination> listper = new ArrayList<>();

        String req = "SELECT * FROM destination";

        PreparedStatement pre = con.prepareStatement(req);

        ResultSet res = pre.executeQuery();

        while (res.next()) {
            int idd = res.getInt(1);
            String gouvernorat = res.getString(2);
            String adressed = res.getString(3);

            Destination dp = new Destination(idd, gouvernorat, adressed);

            listper.add(dp);
        }
        return listper;
    }

    @Override
    public Destination findById(int idd) throws SQLException {
        Destination dp = null;

        String req = "SELECT * FROM destination WHERE idd = ?";

        PreparedStatement pre = con.prepareStatement(req);
        pre.setInt(1, idd);

        ResultSet res = pre.executeQuery();

        if (res.next()) {
            String gouvernorat = res.getString(2);
            String adressed = res.getString(3);

            dp = new Destination(idd, gouvernorat, adressed);
        }

        return dp;
    }

    public void update(Destination dp, int idd) throws SQLException {
    String req = "UPDATE `destination` SET `gouvernorat`=?,`adressed`=? WHERE `idd`=?";
    PreparedStatement pre = con.prepareStatement(req);
    pre.setString(1, dp.getGouvernorat());
    pre.setString(2, dp.getAdressed());
    pre.setInt(3, idd);
    pre.executeUpdate();
}



public boolean supprime(Destination dp) throws SQLException {
    String req = "DELETE FROM `destination` WHERE `idd` = ?";

    PreparedStatement pre = con.prepareStatement(req);
    pre.setInt(1, dp.getIdd());

    int rowsDeleted = pre.executeUpdate();

    return rowsDeleted > 0;
}

    @Override
    public void update(Destination t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void supprime(ServiceDestination sd, int idd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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