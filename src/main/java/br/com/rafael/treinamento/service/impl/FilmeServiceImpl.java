package br.com.rafael.treinamento.service.impl;

import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.enums.Status;
import br.com.rafael.treinamento.repository.FilmeRepository;
import br.com.rafael.treinamento.service.api.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class FilmeServiceImpl implements FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Override
    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    @Override
    public List<Filme> findAssistindo() {
        return filmeRepository.findByStatus(Status.ESTOU_ASSISTINDO);
    }

    @Override
    public Filme findById(Long id) {
        return filmeRepository.findById(id).orElse(null);
    }

    @Override
    public Filme save(Filme filme) {
        normalize(filme);
        validate(filme);
        return filmeRepository.save(filme);
    }

    @Override
    public Filme update(Filme filme) {
        validateUpdate(filme);
        return filmeRepository.save(filme);
    }

    @Override
    public void delete(Long id) {
        filmeRepository.deleteById(id);
    }

    private void normalize(Filme filme){
        filme.setStatus(Status.NAO_VI_AINDA);
        filme.setId(null);
    }

    private void validateUpdate(Filme filme){
        validate(filme);
        if (filme.getId() == null){
            throw new RuntimeException("Não é possível alterar um filme sem código");
        }
    }
    private void validate(Filme filme){
        if (filme.getAnoLancamento() > Year.now().getValue()) {
            throw new RuntimeException("Não é possível cadastrar um filme ainda não lançado!");
        }
    }
}
