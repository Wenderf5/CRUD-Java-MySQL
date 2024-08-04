package com.app.escola.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConfig {
    public static Connection conexao;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/dataBaseName", "user", "password");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco de dados.");
        }
    }
}