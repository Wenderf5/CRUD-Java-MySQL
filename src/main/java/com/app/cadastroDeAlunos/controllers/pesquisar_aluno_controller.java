package com.app.cadastroDeAlunos.controllers;

import com.app.cadastroDeAlunos.Main;
import com.app.cadastroDeAlunos.config.DataBaseConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class pesquisar_aluno_controller {

    @PostMapping("/pesquisaraluno")
    public String pesquisarAluno(@RequestBody Main.pesquisaaluno aluno){
        try{
            //Query de consulta no banco de dados
            PreparedStatement stmt = DataBaseConfig.conexao.prepareStatement("SELECT * FROM alunoscursos WHERE nomeAluno = ? ");
            ((PreparedStatement) stmt).setString(1, aluno.getNome());
            ResultSet rs = stmt.executeQuery();

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayNode resultadoJSON = objectMapper.createArrayNode();

            while(rs.next()){
                ObjectNode alunoJSON = objectMapper.createObjectNode();
                alunoJSON.put("cpfAluno", rs.getString("cpfAluno"));
                alunoJSON.put("nomeAluno", rs.getString("nomeAluno"));
                alunoJSON.put("cursoAluno", rs.getString("cursoAluno"));

                resultadoJSON.add(alunoJSON);
            }
            return objectMapper.writeValueAsString(resultadoJSON);
        }catch (SQLException ex){
            ex.printStackTrace();
            return "Erro ao pesquisar aluno: " + ex.getMessage();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
