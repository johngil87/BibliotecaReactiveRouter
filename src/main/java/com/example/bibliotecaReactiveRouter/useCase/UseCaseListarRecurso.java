package com.example.bibliotecaReactiveRouter.useCase;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;

@Service
@Validated
public class UseCaseListarRecurso {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();


    public UseCaseListarRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Flux<RecursoDTO> listarRecurso(){
        return repositorio.findAll().map(recursoMapper.fromCollection());
    }
}
