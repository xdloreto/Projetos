/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Conexão.ConexaoSingleton;
import Conexão.ConnectionFactory;
import Excecao.ColecaoException;
import Excecao.ConexaoException;
import Modelo.Produto;
import Persistência.ColecaoDeProduto;
import Persistência.ColecaoDeProdutoemBDR;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Loreto
 */
public class DevMain {
    public static void main(String[] args) throws ConexaoException {
        Connection con = ConexaoSingleton.getConexao();
        ColecaoDeProduto cp = new ColecaoDeProdutoemBDR(con);
        
        Produto p1 = new Produto("TESTETESTE", "TESTE", (float)1.5, (float)1.5);
        try {
            cp.inserir(p1);
        } catch (ColecaoException ex) {
            Logger.getLogger(DevMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
//        String comando = "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge";
          String comando = "cmd cls";
        try {
            Process exec = Runtime.getRuntime().exec(comando);
            InputStream in = exec.getInputStream();
            Scanner scan = new Scanner(in);
            while( scan.hasNext() ) {
            System.out.println( scan.nextLine() );
            }
            
        } catch (IOException ex) {
            Logger.getLogger(DevMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
