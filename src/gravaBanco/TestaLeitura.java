/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gravaBanco;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import model.Pessoa;

/**
 *
 * @author QoS Dev
 */
public class TestaLeitura {
    public static void main(String[] args) throws FileNotFoundException {
        Pessoa pessoa = new Pessoa();
        Scanner scanner = new Scanner(new FileReader("C:/programinhas/pessoa.txt"))
                       .useDelimiter("\\||\\n");
while (scanner.hasNext()) {
  String nome = scanner.next();
  String cidade = scanner.next();
  
  pessoa.setNome(nome);
  pessoa.setRg(cidade);
  
  System.out.println(pessoa.getNome());
  System.out.println(pessoa.getRg());
 
}
    }
    
}
