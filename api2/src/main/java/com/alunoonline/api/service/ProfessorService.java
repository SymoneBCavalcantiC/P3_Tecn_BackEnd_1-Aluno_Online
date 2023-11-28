package com.alunoonline.api.service;

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.model.Professor;
import com.alunoonline.api.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {

    @Autowired
    ProfessorRepository repository;

    public Professor create (Professor professor){
        return repository.save(professor);
    }

    public List<Professor> findAll(){
        return repository.findAll();
    }

    public Optional<Professor> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Professor update(Long id, Professor professorUpdated) {
        Professor professorCadastrado = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Professor não encontrado com id: " + id));

        if (professorUpdated.getNome() != null) {
            professorCadastrado.setNome(professorUpdated.getNome());
        }
        if (professorUpdated.getEmail() != null) {
            professorCadastrado.setEmail(professorUpdated.getEmail());
        }
        return repository.save(professorCadastrado);
    }



}
