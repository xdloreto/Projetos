/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Principal;

import Conexão.ConexaoSingleton;
import Excecao.ColecaoException;
import Excecao.ConexaoException;
import Modelo.Produto;
import Persistência.ColecaoDeProduto;
import Persistência.ColecaoDeProdutoemBDR;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Loreto
 */
public class DevMain2 {
    public static void main(String[] args) throws ConexaoException {
        Connection con = ConexaoSingleton.getConexao();
        ColecaoDeProduto cp = new ColecaoDeProdutoemBDR(con);
        
        Produto p1 = new Produto(0,"TESTETESTE", "TESTE", (float)0.0, (float)0.0);
        try {
            cp.inserir(p1);
        } catch (ColecaoException ex) {
            Logger.getLogger(DevMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            List<Produto> registros = cp.todos();
            for (Produto registro : registros) {
                System.out.println(registro.getId() + " " + registro.getNome());
            }
        } catch (ColecaoException ex) {
            Logger.getLogger(DevMain2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
