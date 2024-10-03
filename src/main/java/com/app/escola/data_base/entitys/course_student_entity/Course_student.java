package com.app.escola.data_base.entitys.course_student_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course_student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_course;
    private Long id_student;

    //Construtor padrão sem argumentos
    public Course_student() {

    }

    public Course_student(Long id_course, Long id_student){
        this.id_course = id_course;
        this.id_student = id_student;
    }

    //Geters
    public Long getId() {
        return id;
    }

    public Long getId_course() {
        return id_course;
    }

    public Long getId_student() {
        return id_student;
    }
}
