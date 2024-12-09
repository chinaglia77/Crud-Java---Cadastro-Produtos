package DAO;

import DTO.ProdutoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

/**
 *
 * @author Pichau
 */
public class ProdutoDAO {

    PreparedStatement ps;
    Connection conn;
    ResultSet rs = null;

    public void cadastrarProduto(ProdutoDTO produto) {
        String sql = "INSERT INTO produtos (id_produto, nome_produto, categoria, quantidade_estoque, preco) VALUES(?,?,?,?,?)";

        conn = new ConexaoDAO().conexaoDAO();

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, produto.getIdProduto());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getCategoriaProduto());
            ps.setInt(4, produto.getQtdEstoqueProduto());
            ps.setDouble(5, produto.getPreco());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto" + e, "cadastro produto", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);

        }
    }

    public ArrayList<ProdutoDTO> listarProdutos() {
        ArrayList<ProdutoDTO> listaProdutos = new ArrayList<ProdutoDTO>();

        conn = new ConexaoDAO().conexaoDAO();

        try {
            String sqlListarProdutos = "SELECT * FROM produtos";

            ps = conn.prepareStatement(sqlListarProdutos);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProdutoDTO proDTO = new ProdutoDTO();
                proDTO.setIdProduto(rs.getInt("id_produto"));
                proDTO.setNomeProduto(rs.getString("nome_produto"));
                proDTO.setCategoriaProduto(rs.getString("categoria"));
                proDTO.setQtdEstoqueProduto(rs.getInt("quantidade_estoque"));
                proDTO.setPreco(rs.getDouble("preco"));
              

                listaProdutos.add(proDTO);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produto" + e, "listar produto", JOptionPane.ERROR_MESSAGE);
        }
        return listaProdutos;
    }

    public ArrayList<ProdutoDTO> pesquisarProduto(ProdutoDTO produto) {
        ArrayList<ProdutoDTO> produtoPesquisado = new ArrayList<>();
        conn = new ConexaoDAO().conexaoDAO();

        try {
            String sqlPesquisar = "SELECT * FROM produtos WHERE id_produto = ?";

            ps = conn.prepareStatement(sqlPesquisar);
            ps.setInt(1, produto.getIdProduto());

            rs = ps.executeQuery();

            while (rs.next()) {
                produto.setIdProduto(rs.getInt("id_produto"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setCategoriaProduto(rs.getString("categoria"));
                produto.setQtdEstoqueProduto(rs.getInt("quantidade_estoque"));
                produto.setPreco(rs.getDouble("preco"));

                produtoPesquisado.add(produto);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao pesquisar o produto: " + e, "Pesquisar produto", JOptionPane.ERROR_MESSAGE);
        }

        return produtoPesquisado;
    }

    public Boolean verificarID(ProdutoDTO proDTO) {
        conn = new ConexaoDAO().conexaoDAO();

        try {
            String sqlVerificarID = "SELECT * FROM produtos WHERE id_produto = ?";

            ps = conn.prepareStatement(sqlVerificarID);
            ps.setInt(1, proDTO.getIdProduto());
            rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar o ID" + e);
            return false;
        }

    }

    public void alterarProduto(ProdutoDTO produto) {
        String sql = "UPDATE produtos SET id_produto = ?, nome_produto = ?, categoria = ?, quantidade_estoque = ?, preco = ? WHERE id_produto = ?";

        conn = new ConexaoDAO().conexaoDAO();

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, produto.getIdProduto());
            ps.setString(2, produto.getNomeProduto());
            ps.setString(3, produto.getCategoriaProduto());
            ps.setInt(4, produto.getQtdEstoqueProduto());
            ps.setDouble(5, produto.getPreco());
            ps.setInt(6, produto.getIdProduto());

            ps.execute();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar produto" + e, "alterar produto", JOptionPane.ERROR_MESSAGE);
            System.out.println(e);

        }
    }

    public void excluirProdutos(ProdutoDTO proDTO) {
        String sqlDeletarProduto = "DELETE FROM produtos WHERE id_produto = ?";

        conn = new ConexaoDAO().conexaoDAO();

        try {
            ps = conn.prepareStatement(sqlDeletarProduto);
            
            ps.setInt(1, proDTO.getIdProduto());
            ps.execute();
            ps.close();
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao deletar o produto " + proDTO.getNomeProduto() + ": " + e);
        }

    }

}