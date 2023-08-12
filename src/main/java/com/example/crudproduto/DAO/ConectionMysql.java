package com.example.crudproduto.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConectionMysql implements ConectionJDBC{
    public static void main(String[] args) {
        System.out.println(new ConectionMysql().criarConexao());
    }
    @Override
    public Connection criarConexao(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/produto";
            String usuario = "root";
            String senha = "";

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConectionMysql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
