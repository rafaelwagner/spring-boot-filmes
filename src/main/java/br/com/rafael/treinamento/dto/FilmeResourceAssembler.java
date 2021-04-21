package br.com.rafael.treinamento.dto;

import br.com.rafael.treinamento.entity.Filme;
import br.com.rafael.treinamento.controller.endpoint.FilmeEndpoint;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilmeResourceAssembler extends ResourceAssemblerSupport<Filme, FilmeResource> {

    public FilmeResourceAssembler() {
        super(FilmeEndpoint.class, FilmeResource.class);
    }

    @Override
    public FilmeResource toResource(Filme filme) {
        FilmeResource filmeResource = new FilmeResource();

        filmeResource.setCodigo(filme.getId());
        filmeResource.setTitulo(filme.getTitulo());
        filmeResource.setSinopse(filme.getSinopse());
        filmeResource.setCategoria(filme.getCategoria().name());
        filmeResource.setStatus(filme.getStatus().name());
        filmeResource.setAnoLancamento(filme.getAnoLancamento());

        filmeResource.add(
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(FilmeEndpoint.class).findById(filme.getId())).withSelfRel(),
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(FilmeEndpoint.class).update(filme)).withRel("put"),
                ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(FilmeEndpoint.class).delete(filme.getId())).withRel("delete")
        );

        return filmeResource;
    }

    public List<FilmeResource> toResources(List<Filme> filmes){
        List<FilmeResource> filmeResources = new ArrayList();
        for (Filme filme: filmes){
            filmeResources.add(toResource(filme));
        }
        return filmeResources;
    }
}