package com.app.escola.data_base.entitys.coursestudent_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coursestudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idcourse;
    private Long idstudent;

    //Construtor padrão sem argumentos
    public Coursestudent() {

    }

    public Coursestudent(Long idcourse, Long idstudent){
        this.idcourse = idcourse;
        this.idstudent = idstudent;
    }

    //Geters
    public Long getId() {
        return id;
    }

    public Long getId_course() {
        return idcourse;
    }

    public Long getId_student() {
        return idstudent;
    }
}
