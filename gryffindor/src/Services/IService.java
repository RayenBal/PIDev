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
 * @author sanabenfadhel
 */
public interface IService<R> {

    void ajouter(R r) throws SQLException;

    void update(R r) throws SQLException;

    boolean supprime(R r) throws SQLException;

    List<R> readAll() throws SQLException;

    R findById(int id_reclamation) throws SQLException;
}
