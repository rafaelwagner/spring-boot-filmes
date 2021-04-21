package br.com.rafael.treinamento;

import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.service.api.FilmeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.Assert;

import java.time.Year;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
public class TreinamentoApplicationTests {

	@Autowired
	private FilmeService filmeService;

	@Test
	public void obterTodosOsFilmesTests() {
		List<Filme> result = filmeService.findAll();
		Assert.notEmpty(result, "A Lista de filmes está vazia.");
	}

	@Test
	public void criarFilmeAnoMaiorAtualTests(){
		Filme filme = new Filme();
		filme.setAnoLancamento(new Long (Year.now().getValue() + 1));
		Assertions.assertThrows(RuntimeException.class, () -> filmeService.save(filme));
	}
}
