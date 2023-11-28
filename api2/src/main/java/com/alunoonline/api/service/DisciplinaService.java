package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Disciplina;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {

    @Autowired
    DisciplinaRepository repository;

    public Disciplina create(Disciplina disciplina){
        return repository.save(disciplina);
    }

    public List<Disciplina> findAll(){
        return repository.findAll();
    }

    public List<Disciplina> findByProfessorId(Long professorId){
        return repository.findByProfessorId(professorId);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Disciplina update(Long id, Disciplina disciplinaUpdated, Professor professorUpdated) {
        Disciplina disciplinaCadastrada = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Disciplina não encontrada com id: " + id));

        if (disciplinaUpdated.getNome() != null) {
            disciplinaCadastrada.setNome(disciplinaUpdated.getNome());
        }
        if (disciplinaUpdated.getProfessor() != null) {
            disciplinaCadastrada.setProfessor(disciplinaUpdated.getProfessor());
        }
        return repository.save(disciplinaCadastrada);
    }
}
