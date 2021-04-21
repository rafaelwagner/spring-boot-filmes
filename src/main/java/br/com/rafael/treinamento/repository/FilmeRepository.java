package br.com.rafael.treinamento.repository;

import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.enums.Categoria;
import br.com.rafael.treinamento.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findByStatus(Status status);

    List<Filme> findByCategoriaOrderByAnoLancamentoAsc(Categoria categoria);

    @Query("SELECT f FROM Filme f WHERE f.categoria = ?1 ORDER BY anoLancamento")
    List<Filme> buscaPorCategoriaOrdenadoPorAnoLancamentoAsc(Categoria categoria);
}
