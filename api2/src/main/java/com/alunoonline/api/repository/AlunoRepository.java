package com.alunoonline.api.repository;
// A Interface é um "contrato" que "obriga" as classes que a chamarem, a implementarem todos os seus métodos.
// Pacote REPOSITORY é responsável pela comunicação com os dados(BD) que o service precisa.
// tem que estender a classe Jpa do Spring Data para ligar com o BD: criar a "ponte"
// os métodos necessários estão no framework e foram importados com a anotação e o "extends"

import com.alunoonline.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
