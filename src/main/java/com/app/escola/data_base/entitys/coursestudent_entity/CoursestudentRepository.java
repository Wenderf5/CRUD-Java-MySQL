package com.app.escola.data_base.entitys.coursestudent_entity;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CoursestudentRepository extends JpaRepository<Coursestudent, Long> {
    List<Coursestudent> findAllByIdstudent(Long id);
}
