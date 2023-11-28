package com.alunoonline.api.controller;

import com.alunoonline.api.dtos.PatchNotasRequest;
import com.alunoonline.api.model.MatriculaAluno;
import com.alunoonline.api.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno){
        service.create(matriculaAluno);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<MatriculaAluno> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<MatriculaAluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void patchNotas(
            @RequestBody PatchNotasRequest patchNotasRequest,
            @PathVariable Long id
            ) {
        service.patchNotas(id, patchNotasRequest);
    }

}
