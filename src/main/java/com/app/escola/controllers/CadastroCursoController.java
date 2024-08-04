package com.app.escola.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.escola.services.CadastroCursoService;

@RestController
class CadastroCursoController {

    @PostMapping("/cadastrocurso")
    private String cadastroCurso(@RequestBody Curso cursoBody){
        CadastroCursoService cadastroCursoService = new CadastroCursoService();
        System.out.println(cursoBody.getCursoName());
        return cadastroCursoService.cadastroCurso(cursoBody.getCursoName());
    }

    private static class Curso {
        private String cursoName;

        // Construtor sem argumentos necessário para deserialização
        public Curso() {

        }

        public String getCursoName() {
            return cursoName;
        }
    }
}
