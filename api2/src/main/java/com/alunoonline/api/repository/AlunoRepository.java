package com.alunoonline.api.repository;
//Pacote REPOSITORY é responsável pela comunicação com os dados que o service precisa.

import com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
