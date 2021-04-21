package br.com.rafael.treinamento.controller.endpoint;

import br.com.rafael.treinamento.dto.FilmeResource;
import br.com.rafael.treinamento.dto.FilmeResourceAssembler;
import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.service.api.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/filmes")
public class FilmeEndpoint {

    @Autowired
    private FilmeService filmeService;

    @Autowired
    private FilmeResourceAssembler filmeResourceAssembler;

    @GetMapping
    public List<FilmeResource> findAll() {
        return filmeResourceAssembler.toResources(filmeService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResource> findById(@PathVariable Long id) {
        Filme filme = filmeService.findById(id);
        if (filme == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(filmeResourceAssembler.toResource(filme));
    }

    @PostMapping
    public ResponseEntity<FilmeResource> create(@RequestBody Filme filmeInput, HttpServletRequest request){
        Filme filme = filmeService.save(filmeInput);
        return ResponseEntity.created(URI.create(request.getRequestURL() + "/" + filme.getId())).body(filmeResourceAssembler.toResource(filme));
    }

    @PutMapping
    public FilmeResource update(@RequestBody Filme filme){
        return filmeResourceAssembler.toResource(filmeService.update(filme));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        filmeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/assistindo")
    public List<FilmeResource> findAssistindo(){
      return filmeResourceAssembler.toResources(filmeService.findAssistindo());
    }
}
