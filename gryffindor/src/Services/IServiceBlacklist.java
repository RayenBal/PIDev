/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IServiceBlacklist<B> {
    void ajouter(B b) throws SQLException;

    void update(B b) throws SQLException;

    boolean supprime(B b) throws SQLException;

    List<B> readAll() throws SQLException;

    B findById(int id_blacklist) throws SQLException;
    
}

