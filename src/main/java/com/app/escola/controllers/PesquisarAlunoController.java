package com.app.escola.controllers;

import com.app.escola.services.PesquisaAlunoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PesquisarAlunoController {

    @PostMapping("/pesquisaraluno")
    private String pesquisarAluno(@RequestBody PesquisaAluno alunoBody){
        PesquisaAlunoService pesquisaAlunoService = new PesquisaAlunoService();
        return pesquisaAlunoService.pesquisaAluno(alunoBody.getNome());
    }

    private static class PesquisaAluno {
        private  String nome;

        // Construtor sem argumentos necessário para deserialização
        private PesquisaAluno() {}

        private String getNome() {
            return nome;
        }
    }
}
