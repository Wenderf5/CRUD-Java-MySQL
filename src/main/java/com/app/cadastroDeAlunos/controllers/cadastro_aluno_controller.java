package com.app.cadastroDeAlunos.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.cadastroDeAlunos.services.cadastro_aluno_service;

@RestController
public class cadastro_aluno_controller {

    @PostMapping("/cadastroaluno")
    public String cadastroaluno(@RequestBody aluno alunobody) {
        cadastro_aluno_service cadastroAlunoService = new cadastro_aluno_service();
        return cadastroAlunoService.cadastroAluno(alunobody.getNome(), alunobody.getCpf());
    }

    public static class aluno{
        String cpf;
        String nome;

        //Contructor da classe aluno
        public aluno(String nome, String cpf){
            this.cpf = cpf;
            this.nome = nome;
        }

        public String getCpf(){
            return cpf;
        }
        public String getNome(){
            return nome;
        }
    }
}
