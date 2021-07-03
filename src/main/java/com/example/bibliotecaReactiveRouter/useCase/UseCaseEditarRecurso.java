package com.example.bibliotecaReactiveRouter.useCase;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseEditarRecurso implements Function<RecursoDTO, Mono<RecursoDTO>> {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();


    public UseCaseEditarRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public Mono<RecursoDTO> apply(RecursoDTO recursoDTO) {
        return repositorio.save(recursoMapper.fromDTO(recursoDTO.getIdRecurso())
                .apply(recursoDTO))
                .map(recursoMapper.fromCollection());
    }

}
