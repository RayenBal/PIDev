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
 * @author Rayen
 * @param <C>
 */
public interface IServiceCompte<C> {

    void ajouter(C c) throws SQLException;

    void update(C c) throws SQLException;

    boolean supprime(C c) throws SQLException;

    List<C> readAll() throws SQLException;

    C findById(int id_compte) throws SQLException;
}
