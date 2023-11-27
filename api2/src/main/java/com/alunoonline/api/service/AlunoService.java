package com.alunoonline.api.service;
/* Pacote SERVICES: separar as regras de negócio, regras da aplicação
e regras de aplicação para que possam ser testadas e reutilizadas
por outras partes.
 */

import com.alunoonline.api.model.Aluno;
import com.alunoonline.api.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service //informa ao framework que esta é a classe de serviço
public class AlunoService {

    @Autowired //informa ao spring a injeção da dependência repository em service
    AlunoRepository repository;
    public Aluno create(Aluno aluno){
        return repository.save(aluno); //retorna o aluno criado

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

}
