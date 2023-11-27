package com.alunoonline.api.model;
//Pacote MODEL é responsável pelas classes de entidade, conexão com o BD

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //informa ao Spring que essa classe representa uma entidade. Cria uma tabela no banco de dados.
@Data //insere os getters and setters; toString; equals...
@AllArgsConstructor //insere um construtor com todos os parâmetros
@NoArgsConstructor //insere um construtor vazio
public class Aluno {

    @Id //especifica que o atributo é a chave primária desta entidade
    @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia usada na persistência do ID, que vai autoincrementar a cada novo aluno
    private Long id;
    private String nome;
    private String email;
    private String curso;

}
