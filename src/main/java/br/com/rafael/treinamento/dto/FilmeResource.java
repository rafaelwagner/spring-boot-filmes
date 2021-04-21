package br.com.rafael.treinamento.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.hateoas.ResourceSupport;

@Data
@EqualsAndHashCode(callSuper = false)
public class FilmeResource extends ResourceSupport {
    private Long codigo;
    private String titulo;
    private String sinopse;
    private String categoria;
    private String status;
    private Long anoLancamento;
}
