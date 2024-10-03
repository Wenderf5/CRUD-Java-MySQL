package com.app.escola.data_base.entitys.student_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cpf;
    private String name;

    //Construtor padrão sem argumentos
    public Student() {

    }

    public Student(String cpf, String name) {
        this.cpf = cpf;
        this.name = name;
    }

    //Geters
    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getName() {
        return name;
    }
}
