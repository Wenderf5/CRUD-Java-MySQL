package com.app.escola.services;

import com.app.escola.config.DataBaseConfig;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroCursoService {

    public String cadastroCurso(String curso){
        try{
            PreparedStatement stmt = DataBaseConfig.conexao.prepareStatement("INSERT INTO cursos (nome) VALUES (?)");
            ((PreparedStatement) stmt).setString(1, curso);
            stmt.executeUpdate();
            return "Curso cadastrado com sucesso!";
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
