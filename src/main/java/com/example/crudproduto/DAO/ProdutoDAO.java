package com.example.crudproduto.DAO;

import com.example.crudproduto.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {
    Connection con;

    public ProdutoDAO(){
        con = MinhaConexao.conexao();
    }

    public List<Produto> buscarProdutos() {
        try {
            //comando sql
            String sql = "SELECT * FROM produto";
            PreparedStatement ps = con.prepareStatement(sql);
            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            //cria uma lista de produtos para retornar
            List<Produto> produto = new ArrayList();
            //laço para buscar todas os produtos do banco
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("valor"));
                produto.add(p);
            }
            //retorna a lista de produtos
            return produto;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean removeProduto(Long id) {
        try {
            String sql = "DELETE FROM produto WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1, id);
            if(ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(com.example.crudproduto.DAO.ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean saveProduto(Produto produto) {
        try {
            //comando sql
            String sql = "INSERT INTO produto (descricao, valor) VALUES (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2, produto.getPreco());

            if(ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(com.example.crudproduto.DAO.ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateProduto(Produto produto) {
        try {
            //comando sql
            String sql = "UPDATE produto SET descricao=?, valor=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setString(1, produto.getDescricao());
            ps.setDouble(2,produto.getPreco());
            ps.setLong(3, produto.getId());

            if (ps.executeUpdate()==1)
                return true;

        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Produto buscarProduto(Long id) {
        try {
            //comando sql
            String sql = "SELECT * FROM produto WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            //referênciar o parâmetro do método para a ?
            ps.setLong(1, id);

            //ResultSet, representa o resultado do comando SQL
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setDescricao(rs.getString("descricao"));
                p.setPreco(rs.getDouble("valor"));
                return p;
            }
        } catch (SQLException ex) {
            Logger.getLogger(com.example.crudproduto.DAO.ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }



}
