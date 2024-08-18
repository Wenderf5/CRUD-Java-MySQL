package com.app.escola.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.escola.services.CadastroAlunoService;

@RestController
class CadastroAlunoController {
    private CadastroAlunoService cadastroAlunoService;

    @Autowired
    public CadastroAlunoController(CadastroAlunoService cadastroAlunoService) {
        this.cadastroAlunoService = cadastroAlunoService;
    }

    @PostMapping("/cadastroaluno")
    private String cadastroAluno(@RequestBody Aluno alunoBody) {
        return cadastroAlunoService.cadastroAluno(alunoBody.getNome(), alunoBody.getCpf());
    }

    private static class Aluno {
        private String cpf;
        private String nome;

        private Aluno(String nome, String cpf) {
            this.cpf = cpf;
            this.nome = nome;
        }

        private String getCpf() {
            return cpf;
        }

        private String getNome() {
            return nome;
        }
    }
}
