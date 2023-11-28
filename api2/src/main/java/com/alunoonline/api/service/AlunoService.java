package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository repository;

    public Aluno create(Aluno aluno){
        return repository.save(aluno);
    }
    public List<Aluno> findAll(){
        return repository.findAll();
    }

    public Optional<Aluno> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Aluno update(Long id, Aluno alunoUpdated) {
        Aluno alunoCadastrado = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado com id: " + id));

        if (alunoUpdated.getNome() != null) {
            alunoCadastrado.setNome(alunoUpdated.getNome());
        }
        if (alunoUpdated.getEmail() != null) {
            alunoCadastrado.setEmail(alunoUpdated.getEmail());
        }
        if (alunoUpdated.getCurso() != null) {
            alunoCadastrado.setCurso(alunoUpdated.getCurso());
        }

        return repository.save(alunoCadastrado);
    }

}
