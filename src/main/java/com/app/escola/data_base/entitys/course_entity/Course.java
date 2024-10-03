package com.app.escola.data_base.entitys.course_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    //Construtor padrão sem argumentos
    public Course() {

    }

    public Course(String name) {
        this.name = name;
    }

    //Geters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
