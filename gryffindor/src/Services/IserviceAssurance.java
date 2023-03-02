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
 * @param <A>
 */
public interface IServiceAssurance<A> {

    void ajouter(A a) throws SQLException;

    void update(A a) throws SQLException;

    boolean supprime(A a) throws SQLException;

    List<A> readAll() throws SQLException;

    A findById(int id_assurance) throws SQLException;
}
