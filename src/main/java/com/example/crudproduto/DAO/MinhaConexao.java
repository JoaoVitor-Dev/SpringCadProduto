package com.example.crudproduto.DAO;

import java.sql.Connection;

public class MinhaConexao {
    public static Connection conexao(){
        ConectionJDBC conexao = new ConectionMysql();
        return conexao.criarConexao();
    }
}
