/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistência;

import Excecao.ColecaoException;
import Modelo.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


//CLASSE RESPONSÁVEL POR MANIPULAR O BANCO DE DADOS
/**
 *
 * @author Gustavo Loreto
 */
public class ColecaoDeProdutoemBDR implements ColecaoDeProduto { // MANIPULADOR
    
    private Connection conexao;

    public ColecaoDeProdutoemBDR(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public List<Produto> porNome(String nome) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome FROM PRODUTO WHERE produto_nome LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, "%"+nome+"%");
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("produto_id"), rs.getString("produto_nome"), rs.getString("produto_unidade_medida"), rs.getFloat("produto_preco"), rs.getFloat("produto_estoque"));
                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao obter pelo nome!", e);
        } finally {
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
        return lp;
    }

    @Override
    public List<Produto> todos() throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome, produto_preco, produto_estoque, produto_unidade_medida FROM PRODUTO;";
            ps = this.conexao.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Produto p = new Produto(rs.getInt("produto_id"), rs.getString("produto_nome"), rs.getString("produto_unidade_medida"), rs.getFloat("produto_preco"), rs.getFloat("produto_estoque"));
                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao obter os produtos do banco de dados!!!!", e);
                   
        } finally {
            
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
        return lp;
    }

    @Override
    public Produto porId(int id) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Produto> lp = null;
        
        try {
            lp = new ArrayList<Produto>();
            String sql = "SELECT produto_id, produto_nome FROM PRODUTO WHERE produto_id LIKE ?";
            ps = this.conexao.prepareStatement(sql);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            while(rs.next()) {
                Produto p = new Produto(rs.getInt("produto_id"), rs.getString("produto_nome"), rs.getString("produto_unidade_medida"), rs.getFloat("produto_preco"), rs.getFloat("produto_estoque"));
                lp.add(p);
            }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao obter pelo nome!", e);
        } finally {
            try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
        return lp.get(0);
    }
    
    @Override
    public void inserir(Produto produto) throws ColecaoException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            String sql = "INSERT INTO PRODUTO(produto_nome, produto_unidade_medida, produto_preco, produto_estoque) VALUES (?, ?, ?, ?)";
            ps = this.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, produto.getNome());
            ps.setString(2, produto.getUnidade_medida());
            ps.setFloat(3, produto.getPreco());
            ps.setFloat(4, produto.getEstoque());
            ps.execute();
            rs = ps.getGeneratedKeys();
//            if (rs.next()) {
//                produto.setId(rs.getInt(1));
//            }
        } catch (SQLException e) {
            try {
                throw new ColecaoException("Erro ao inserir a pessoa no banco de dados!", e);
            } catch (ColecaoException ex) {
                Logger.getLogger(ColecaoDeProdutoemBDR.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {
              try {
                ps.close();
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
                }
            }
        }

    @Override
    public void alterar(int id, Produto produto) throws ColecaoException {
        PreparedStatement ps = null;
        try {
            String sql = "UPDATE PRODUTO SET produto_nome=? WHERE produto_id=?";
            ps = this.conexao.prepareStatement(sql);
            ps.setString(1, produto.getNome());
            ps.setInt(2, id);
            ps.execute();
        } catch(SQLException e) {
                throw new ColecaoException("Erro ao alterar o produto no banco de dados!", e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
        }
    }
}

    @Override
    public void remover(String[] id) throws ColecaoException {
        PreparedStatement ps = null;
        try {
           String sql = "DELETE FROM PRODUTO WHERE produto_id=?";
           ps = this.conexao.prepareStatement(sql);
           for (String e : id) {
                ps.setInt(1, Integer.parseInt(e));
                ps.execute();
           }
        } catch (SQLException e) {
            throw new ColecaoException("Erro ao remover o produto fdsfdsfsd do banco de dados!" + e);
        } finally {
            try {
                ps.close();
            } catch (SQLException e) {
                throw new ColecaoException("Erro ao fechar o manipulador de banco de dados!", e);
            }
        }
    }
}
