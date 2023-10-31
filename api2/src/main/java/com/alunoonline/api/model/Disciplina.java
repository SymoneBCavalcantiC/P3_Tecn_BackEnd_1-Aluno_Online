package com.alunoonline.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne //indica o relacionamento entre as entidades disciplina e professor
    @JoinColumn(name = "professor_id") //junta as colunas das tabelas professor e disciplina
    private Professor professor;

}
