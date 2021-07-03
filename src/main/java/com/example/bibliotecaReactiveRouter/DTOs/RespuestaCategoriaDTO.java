package com.example.bibliotecaReactiveRouter.DTOs;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


public class RespuestaCategoriaDTO {

    private Mono<String> nombreCategoria;
    private List<RecursoDTO> listRecurso;

    public Mono<String> getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(Mono<String> nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public List<RecursoDTO> getListRecurso() {
        return listRecurso;
    }

    public void setListRecurso(List<RecursoDTO> listRecurso) {
        this.listRecurso = listRecurso;
    }
}
