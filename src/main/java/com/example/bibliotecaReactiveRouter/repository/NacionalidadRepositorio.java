package com.example.bibliotecaReactiveRouter.repository;

import com.example.bibliotecaReactiveRouter.model.Nacionalidad;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface NacionalidadRepositorio extends ReactiveMongoRepository<Nacionalidad, String> {
}
