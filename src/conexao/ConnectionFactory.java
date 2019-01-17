/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author QoS Dev
 */
public class ConnectionFactory {
    public Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost/contigencia","root","Thecure81");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
