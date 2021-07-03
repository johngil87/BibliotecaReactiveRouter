package com.example.bibliotecaReactiveRouter.businessusecase;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaCategoriaDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseDevolverRecurso {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper;

    @Autowired
    public UseCaseDevolverRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Mono<RespuestaCategoriaDTO> devolverRecurso(String idCategoria) {
        return null;
    }
}
