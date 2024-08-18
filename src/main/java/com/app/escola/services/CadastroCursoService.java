package com.app.escola.services;

import com.app.escola.respository.CursosRepository;
import com.app.escola.entitys.Cursos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroCursoService {
    private CursosRepository cursosRepository;

    @Autowired
    public CadastroCursoService(CursosRepository cursosRepository) {
        this.cursosRepository = cursosRepository;
    }

    public String cadastroCurso(String curso) {
        try {
            Cursos newCurso = new Cursos(curso);
            cursosRepository.save(newCurso);
            return "Curso adicionado com sucesso!";
        } catch (Exception e) {
            return "Erro ao adicionar o curso. " + " " + e;
        }
    }
}
