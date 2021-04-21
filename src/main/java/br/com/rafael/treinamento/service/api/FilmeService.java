package br.com.rafael.treinamento.service.api;

import br.com.rafael.treinamento.entity.Filme;

import java.util.List;

public interface FilmeService {
    List<Filme> findAll();

    List<Filme> findAssistindo();

    Filme findById(Long id);

    Filme save(Filme filme);

    Filme update(Filme filme);

    void delete(Long id);
}
