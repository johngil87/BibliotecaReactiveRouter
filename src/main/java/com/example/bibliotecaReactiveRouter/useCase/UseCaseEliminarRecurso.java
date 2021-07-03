package com.example.bibliotecaReactiveRouter.useCase;


import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseEliminarRecurso {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();

    @Autowired
    public UseCaseEliminarRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Mono<Void> eliminerRecurso(String id){
        return repositorio.deleteById(id);
    }

}
