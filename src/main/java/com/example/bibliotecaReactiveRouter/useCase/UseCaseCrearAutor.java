package com.example.bibliotecaReactiveRouter.useCase;

import com.example.bibliotecaReactiveRouter.DTOs.AutorDTO;
import com.example.bibliotecaReactiveRouter.mapper.AutorMapper;
import com.example.bibliotecaReactiveRouter.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseCrearAutor implements Function<AutorDTO, Mono<AutorDTO>> {

    private final AutorRepositorio autorRepositorio;
    private AutorMapper autorMapper = new AutorMapper();

    @Autowired
    public UseCaseCrearAutor(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }


    @Override
    public Mono<AutorDTO> apply(AutorDTO autorDTO) {
        var autor = autorRepositorio.save(autorMapper.fromDTO().apply(autorDTO));
        return autor.map(autorMapper.fromCollection());
    }
}
