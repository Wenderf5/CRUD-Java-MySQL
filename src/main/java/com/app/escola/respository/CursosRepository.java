package com.app.escola.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.escola.entitys.Cursos;

public interface CursosRepository extends JpaRepository<Cursos, Long> {
}
