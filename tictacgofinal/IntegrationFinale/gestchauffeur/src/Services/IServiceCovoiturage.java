/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import Entite.Covoiturage;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author asus
 * @param Covoiturage
 */
public interface IServiceCovoiturage<Covoiturage>{
    boolean  ajouter(Covoiturage c) throws SQLException;
         void update(Covoiturage c) throws SQLException ;
             boolean supprime(Covoiturage c) throws SQLException ;
List<Covoiturage> readAll() throws SQLException;
Covoiturage findById(int id) throws SQLException;
}
