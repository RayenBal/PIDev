package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rayen
 */
import java.sql.SQLException;
import java.util.List;

public interface IserviceHistorique<H> {
    void ajouter(H h) throws SQLException;

    void update(H h) throws SQLException;

    boolean supprime(H h) throws SQLException;

    List<H> readAll() throws SQLException;

    H findById(int id_compte) throws SQLException;
    
}
