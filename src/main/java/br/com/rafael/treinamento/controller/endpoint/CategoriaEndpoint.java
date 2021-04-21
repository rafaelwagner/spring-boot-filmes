package br.com.rafael.treinamento.controller.endpoint;

import br.com.rafael.treinamento.enums.Categoria;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/categorias")
public class CategoriaEndpoint {

    @GetMapping
    public List<Categoria> findAll(){
        return Arrays.asList(Categoria.values());
    }
}
