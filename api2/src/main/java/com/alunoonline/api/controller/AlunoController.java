package com.alunoonline.api.controller;
//Pacote CONTROLLER é o orquestrador. Recebe as chamadas do usuário e retorna-lhe dados.

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //é uma controller do sistema a partir das requisições REST
@RequestMapping("/aluno") //mapeamento da URL da requisição HTTP
public class AlunoController {

    @Autowired //informa ao framework a injeção da dependência service em controller
    AlunoService service;

    @PostMapping //responsável por um POST request
    @ResponseStatus(HttpStatus.CREATED) //código HTTP de retorno da requisição
    public ResponseEntity<Aluno> create(@RequestBody Aluno aluno){
        Aluno alunoCreated = service.create(aluno);

        return ResponseEntity.status(201).body(alunoCreated);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Aluno> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Aluno> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
