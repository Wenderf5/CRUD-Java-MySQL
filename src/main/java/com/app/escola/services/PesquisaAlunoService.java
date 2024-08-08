package com.app.escola.services;

import com.app.escola.config.DataBaseConfig;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PesquisaAlunoService {

    public String pesquisaAluno(String aluno){
        try{
            PreparedStatement stmt = DataBaseConfig.conexao.prepareStatement("SELECT * FROM alunoscurso WHERE nomeAluno = ? ");
            ((PreparedStatement) stmt).setString(1, aluno);
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
