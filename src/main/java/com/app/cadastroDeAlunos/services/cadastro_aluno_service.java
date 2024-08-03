package com.app.cadastroDeAlunos.services;

import com.app.cadastroDeAlunos.config.DataBaseConfig;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class cadastro_aluno_service {
    public String cadastroAluno(String nome, String cpf){
        try {
            PreparedStatement stmt = DataBaseConfig.conexao.prepareStatement("INSERT INTO alunos (cpf, nome) VALUES (?, ?)");
            ((PreparedStatement) stmt).setString(1, cpf);
            stmt.setString(2, nome);
            stmt.executeUpdate();
            return "Aluno cadastrado com sucesso!";
        } catch (SQLException ex) {
            ex.printStackTrace();
            return "Erro ao cadastrar aluno: " + ex.getMessage();
        }
    }
}
