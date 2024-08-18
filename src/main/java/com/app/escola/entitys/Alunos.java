package com.app.escola.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;
    private String nome;

    public Alunos() {
    }

    public Alunos(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
}
