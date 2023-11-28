package com.alunoonline.api.service;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Enum.StatusMatricula;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.repository.MatriculaAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaAlunoService {

    private static final Double MEDIA_PARA_APROVACAO = 7.0;

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

    public List<MatriculaAluno> findAll(){
        return repository.findAll();
    }

    public Optional<MatriculaAluno> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public void patchNotas(Long id, PatchNotasRequest patchNotasRequest) {
        Optional<MatriculaAluno> matriculaAluno = repository.findById(id);

        if (!matriculaAluno.isPresent()) {
            throw new IllegalArgumentException("Matrícula não encontrada.");
        }

        MatriculaAluno matriculaUpdated = matriculaAluno.get();

        if (matriculaUpdated.getStatus() == StatusMatricula.TRANCADO) {
            throw new IllegalStateException("Não é possível atribuir notas para uma matrícula trancada.");
        }

        if (patchNotasRequest.getNota1() != null) {
            matriculaUpdated.setNota1(patchNotasRequest.getNota1());
        }

        if (patchNotasRequest.getNota2() != null) {
            if (matriculaUpdated.getNota1() == null) {
                throw new IllegalStateException("Não é possível atribuir a segunda nota sem o registro da primeira nota.");
            }
            matriculaUpdated.setNota2(patchNotasRequest.getNota2());
        }

        calcularMediaEAtualizarStatus(matriculaUpdated);
        repository.save(matriculaUpdated);
    }

    private void calcularMediaEAtualizarStatus(MatriculaAluno matricula) {
        if (matricula.getNota1() != null && matricula.getNota2() != null) {
            double media = (matricula.getNota1() + matricula.getNota2()) / 2.0;
            StatusMatricula status = media >= MEDIA_PARA_APROVACAO ? StatusMatricula.APROVADO : StatusMatricula.REPROVADO;
            matricula.setStatus(status);
        }
    }


}
