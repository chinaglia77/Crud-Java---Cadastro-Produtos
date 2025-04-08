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
        String sql = "INSERT INTO produto (idProduto, qtdEstoqueProduto, nomeProduto, categoriaProduto, preco) VALUES(?,?,?,?,?)";

        conn = new ConexaoDAO().conexaoDAO();

        try {
            ps = conn.prepareStatement(sql);

            ps.setInt(1, produto.getIdProduto());
            ps.setInt(2, produto.getQtdEstoqueProduto());
            ps.setString(3, produto.getNomeProduto());
            ps.setString(4, produto.getCategoriaProduto());
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
            String sqlListarProdutos = "SELECT * FROM produto";

            ps = conn.prepareStatement(sqlListarProdutos);
            rs = ps.executeQuery();

            while (rs.next()) {
                ProdutoDTO proDTO = new ProdutoDTO();
                proDTO.setIdProduto(rs.getInt("idProduto"));
                proDTO.setQtdEstoqueProduto(rs.getInt("qtdEstoqueProduto"));
                proDTO.setNomeProduto(rs.getString("nomeProduto"));
                proDTO.setCategoriaProduto(rs.getString("categoriaProduto"));
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
            String sqlPesquisar = "SELECT * FROM produto WHERE idProduto = ?";

            ps = conn.prepareStatement(sqlPesquisar);
            ps.setInt(1, produto.getIdProduto());

            rs = ps.executeQuery();

            while (rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setQtdEstoqueProduto(rs.getInt("qtdEstoqueProduto"));
                produto.setNomeProduto(rs.getString("nomeProduto"));
                produto.setCategoriaProduto(rs.getString("categoriaProduto"));
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
            String sqlVerificarID = "SELECT * FROM produto WHERE idProduto = ?";

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
        String sql = "UPDATE produtos SET idProduto = ?, qtdEstoqueProduto = ?, nomeProduto = ?, categoriaProduto = ?, preco = ? WHERE idProduto = ?";

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
        String sqlDeletarProduto = "DELETE FROM produto WHERE idProduto = ?";

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