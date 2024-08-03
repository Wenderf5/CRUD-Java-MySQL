package com.app.cadastroDeAlunos.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Classe que me connecta com o banco de dados
public class DataBaseConfig {
    public static Connection conexao;
    //Metodo que faz a conexão com o banco dedados
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/NomeDoBancoDeDados", "Usuario", "Senha");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver do banco de dados não encontrado.");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar com o banco de dados.");
        }
    }
}
