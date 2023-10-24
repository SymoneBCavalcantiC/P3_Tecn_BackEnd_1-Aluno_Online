package com.alunoonline.api.controller;

import com.alunoonline.api.model.Professor;
import com.alunoonline.api.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorController {

    @Autowired
    ProfessorService service;

    public ResponseEntity<Professor> create(@RequestBody Professor professor){
        Professor professorCreted = service.create(professor);

        return ResponseEntity.status(201).body(professorCreted);
    }
}
