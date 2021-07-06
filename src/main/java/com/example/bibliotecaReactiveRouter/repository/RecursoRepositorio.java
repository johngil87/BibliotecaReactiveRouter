package com.example.bibliotecaReactiveRouter.repository;

import com.example.bibliotecaReactiveRouter.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecursoRepositorio extends ReactiveMongoRepository<Recurso, String> {

    Mono<Recurso> findRecursoBytitulo(String titulo);
    Flux<Recurso> findRecursoByidCategoria(Mono<String> id);

}
