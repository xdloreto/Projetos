/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conexão;

import Excecao.ConexaoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Gustavo Loreto
 */
public class ConexaoSingleton {
    
    private static Connection conexao;
    
    private static Connection novaConexao() throws ConexaoException {
        Connection con = null;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String usuario = "postgres";
        String senha = "postgres";
        try {
            con = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new ConexaoException("Erro ao conectar-se com o banco de dados!");
        }
        return con;
    }
    
    public static Connection getConexao() throws ConexaoException {
        if(conexao == null) {
            conexao = novaConexao();
        }
        return conexao;
    }
    
    public static void finalizarConexao() throws ConexaoException {
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new ConexaoException("Erro ao fechar a conexão com o banco de dados!", e);
        }
        conexao = null;
    }
}
