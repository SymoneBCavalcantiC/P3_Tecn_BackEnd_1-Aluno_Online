package br.com.alunoonline.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exibir-nome")
public class ExibirNome {
    @GetMapping
    public String exibirNome() {
        return "Daniel";
    }

}
