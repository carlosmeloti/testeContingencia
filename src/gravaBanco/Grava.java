/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravaBanco;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import conexao.ConnectionFactory;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Pessoa;

/**
 *
 * @author QoS Dev
 */
public class Grava {
    public static void main(String[] args) throws SQLException, IOException {
        
        Pessoa pessoa = new Pessoa();
        InsereBanco grava = new InsereBanco();
        Connection con = new ConnectionFactory().getConnection();
        
        JOptionPane.showMessageDialog(null, "Bem vindo ao programa de teste de contingencia de Banco de dados. Por Willer Lacerda.");
        
        pessoa.setNome("Fernando");
        pessoa.setRg("65464");
        grava.inserePessoa(pessoa);
        pessoa.setNome("José");
        pessoa.setRg("4234231");
        grava.inserePessoa(pessoa);
        pessoa.setNome("Maria");
        pessoa.setRg("3452345");
        grava.inserePessoa(pessoa);
        pessoa.setNome("Rodrigo");
        pessoa.setRg("32452345");
        grava.inserePessoa(pessoa);
        pessoa.setNome("Mariana");
        pessoa.setRg("3453245");
        grava.inserePessoa(pessoa);
        
        con.close();
        JOptionPane.showMessageDialog(null, "Ih! Perdemos a conexão com o Banco, a partir deste momento salvaremos em documentos TXT.");
        System.out.println("Desconectado do Banco");
        
        pessoa.setNome("Josefa Textina");
        pessoa.setRg("234234");
        grava.gravarEmArquivoTXT(pessoa);
        pessoa.setNome("Jose Textino");
        pessoa.setRg("34535");
        grava.gravarEmArquivoTXT(pessoa);

        System.out.println("Conectado");
        JOptionPane.showMessageDialog(null, "Opa, a Conexão foi restabelecida!");
        
        JOptionPane.showMessageDialog(null, "Gravar dados em Contingencia no Banco?");
        grava.leArquivoTXT();
        
       
        
        
        
        
        
        
        
        
        
        
    }
}
