package br.com.rafael.treinamento.entity;

import br.com.rafael.treinamento.enums.Categoria;
import br.com.rafael.treinamento.enums.Status;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Filme {

    private static final String SEQ_NAME = "FILME_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    private Long id;

    private String titulo;
    private String sinopse;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Status status;
    private  Long anoLancamento;
}
