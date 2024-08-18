package com.app.escola.services;

import com.app.escola.respository.AlunoRepository;
import com.app.escola.entitys.Alunos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroAlunoService {
    private AlunoRepository alunoRepository;

    @Autowired
    public CadastroAlunoService(AlunoRepository alunoRepository) {
        this.alunoRepository = alunoRepository;
    }

    public String cadastroAluno(String nome, String cpf) {
        try {
            Alunos aluno = new Alunos(cpf, nome);
            alunoRepository.save(aluno);
            return "Aluno cadastrado com sucesso!";
        } catch (Exception e) {
            return "Erro ao cadastrar aluno." + " " + e;
        }
    }
}
