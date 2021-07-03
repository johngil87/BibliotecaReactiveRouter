package com.example.bibliotecaReactiveRouter.repository;

import com.example.bibliotecaReactiveRouter.model.Autor;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface AutorRepositorio extends ReactiveMongoRepository<Autor, String> {
}
