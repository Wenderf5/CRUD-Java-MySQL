package com.app.escola.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.app.escola.entitys.Alunos;

public interface AlunoRepository extends JpaRepository<Alunos, Long> {
}
