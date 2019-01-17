/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravaBanco;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author QoS Dev
 */
public class TestaInsere {
    public static void main(String[] args) throws SQLException {
        // conectando
            Connection con = new ConnectionFactory().getConnection();

            // cria um preparedStatement
            String sql = "insert into contatos" +
                    " (nome,rg)" +
                    " values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, "Carlos");
            stmt.setString(2, "464654");
            

            // executa
            stmt.execute();
            stmt.close();

            System.out.println("Gravado!");

            con.close();
        }
    }

