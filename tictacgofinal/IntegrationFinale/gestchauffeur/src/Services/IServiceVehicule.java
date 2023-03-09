/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Vehicule;
import java.sql.SQLException;
import java.util.List;
/**
/**
 *
 * @author asus
 * @param <Vehicule>
 */
public interface IServiceVehicule<Vehicule> {
     boolean  ajouter(Vehicule c) throws SQLException;
     List<Vehicule> readAll() throws SQLException;
     void update(Vehicule c) throws SQLException;
    boolean supprime(Vehicule c) throws SQLException ;
    Vehicule findById(int id) throws SQLException;
}
