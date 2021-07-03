package com.example.bibliotecaReactiveRouter.repository;

import com.example.bibliotecaReactiveRouter.model.Categoria;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface CategoriaRepositorio extends ReactiveMongoRepository<Categoria, String> {
}
