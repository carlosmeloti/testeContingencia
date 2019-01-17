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
        
        for(int i = 0 ; i <=1 ; i++){
            pessoa.setNome(JOptionPane.showInputDialog("Nome"));
            pessoa.setRg(JOptionPane.showInputDialog("RG"));
            grava.inserePessoa(pessoa);
        }
        con.close();
        JOptionPane.showMessageDialog(null, "Ih! Perdemos a conexão com o Banco, a partir deste momento salvaremos em documentos TXT.");
        System.out.println("Desconectado do Banco");
        
        for(int i = 0 ; i <=1 ; i++){
            pessoa.setNome(JOptionPane.showInputDialog("Nome"));
            pessoa.setRg(JOptionPane.showInputDialog("RG"));
            grava.gravarEmArquivoTXT(pessoa);
        }
        con.close();
        System.out.println("Conectado");
        JOptionPane.showMessageDialog(null, "Opa, a Conexão foi restabelecida!");
        
       
         
       JOptionPane.showMessageDialog(null, "Gravar dados em Contingencia no Banco?");
       grava.leArquivoTXT();
        
       
        
        
        
        
        
        
        
        
        
        
    }
}
