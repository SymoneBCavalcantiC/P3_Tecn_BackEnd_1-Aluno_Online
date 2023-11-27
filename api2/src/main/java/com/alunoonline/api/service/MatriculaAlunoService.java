package com.alunoonline.api.service;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.Enum.StatusMatricula;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatriculaAlunoService {

    @Autowired
    MatriculaAlunoRepository repository;

    public void create(MatriculaAluno matriculaAluno){
        if (matriculaAluno.getNota1() != null || matriculaAluno.getNota2() != null){
            throw new IllegalStateException("Não é possível realizar a matrícula com notas já definidas.");
        }
        if (matriculaAluno.getStatus() == StatusMatricula.APROVADO) {
            throw new IllegalArgumentException("Não é possível criar uma matrícula já aprovada.");
        }
        matriculaAluno.setStatus(StatusMatricula.MATRICULADO);
        repository.save(matriculaAluno);
    }

    public void patchNotas(Long id, PatchNotasRequest patchNotasRequest){

    }
}
