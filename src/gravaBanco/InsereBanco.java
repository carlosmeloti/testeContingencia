/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravaBanco;

import conexao.ConnectionFactory;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import model.Pessoa;

/**
 *
 * @author QoS Dev
 */
public class InsereBanco {
    
    Pessoa pessoa = new Pessoa();
    
    
    public void inserePessoa(Pessoa pessoa) throws SQLException{
        // conectando
            Connection con = new ConnectionFactory().getConnection();
            // cria um preparedStatement
            String sql = "insert into contatos" +
                    " (nome,rg)" +
                    " values (?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            // preenche os valores
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getRg());
            
            // executa
            stmt.execute();
            stmt.close();

          
            con.close();
        }
    
    public void gravarEmArquivoTXT(Pessoa pessoa) throws IOException {
	BufferedWriter fr = new BufferedWriter(new FileWriter("C:/programinhas/pessoa.txt",true));//Abre arquivo para escrita
	 fr.write(pessoa.getNome()+"|");//escreve a matricula do aluno no arquivo
	 fr.write(pessoa.getRg());//escreve o nome do aluno no arquivo
         fr.newLine();//passa para a proxima linha
         fr.flush();
	 fr.close();
    
    }
    
    public void leArquivoTXT() throws FileNotFoundException, SQLException{
        Scanner scanner = new Scanner(new FileReader("C:/programinhas/pessoa.txt"))
                       .useDelimiter("\\||\\n");
        while (scanner.hasNext()) {
          String nome = scanner.next();
          String rg = scanner.next();

          pessoa.setNome(nome);
          pessoa.setRg(rg);
            inserePessoa(pessoa);
         
          
          
          
        }
}
}
    
