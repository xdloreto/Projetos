/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import java.util.List;
import Modelo.Produto;

/**
 *
 * @author Gustavo Loreto
 */
public interface ColecaoDeProduto extends Colecao<Produto> {
    
    public List<Produto> porNome(String nome) throws ColecaoException;
    
}
