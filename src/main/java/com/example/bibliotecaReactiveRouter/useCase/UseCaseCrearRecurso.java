package com.example.bibliotecaReactiveRouter.useCase;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseCrearRecurso implements Function<RecursoDTO, Mono<RecursoDTO>> {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();

    @Autowired
    public UseCaseCrearRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        var recurso = repositorio.save(recursoMapper.fromDTO(null).apply(recursoDTO));
        return recurso.map(recursoMapper.fromCollection());
    }


}
