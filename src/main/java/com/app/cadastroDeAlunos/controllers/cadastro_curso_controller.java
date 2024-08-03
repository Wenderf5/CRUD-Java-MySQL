package com.app.cadastroDeAlunos.controllers;

import com.app.cadastroDeAlunos.Main;
import com.app.cadastroDeAlunos.config.DataBaseConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class cadastro_curso_controller {

    @PostMapping("/cadastrocurso")
    public String addcurso(@RequestBody Main.curso curso){
        try{
            PreparedStatement stmt = DataBaseConfig.conexao.prepareStatement("INSERT INTO cursos (nome) VALUES (?)");
            ((PreparedStatement) stmt).setString(1, curso.getNome());
            stmt.executeUpdate();
            return "Curso adicionado!";
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
