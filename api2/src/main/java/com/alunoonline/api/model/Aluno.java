package com.alunoonline.api.model;
//Pacote MODEL é responsável pelas classes de entidade, conexão com BD

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //informa ao Spring que essa classe representa uma entidade. Cria uma tabela no banco de dados.
@Data //insere os getters and setters
@AllArgsConstructor //insere um construtor com todos os parâmetros
@NoArgsConstructor //insere um construtor vazio
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String curso;

}
