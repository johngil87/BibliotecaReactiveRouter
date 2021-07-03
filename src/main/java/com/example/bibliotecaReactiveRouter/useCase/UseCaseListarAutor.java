package com.example.bibliotecaReactiveRouter.useCase;

import com.example.bibliotecaReactiveRouter.DTOs.AutorDTO;
import com.example.bibliotecaReactiveRouter.mapper.AutorMapper;
import com.example.bibliotecaReactiveRouter.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;


@Service
@Validated
public class UseCaseListarAutor {


    private final AutorRepositorio autorRepositorio;
    private AutorMapper autorMapper = new AutorMapper();

    @Autowired
    public UseCaseListarAutor(AutorRepositorio autorRepositorio) {
        this.autorRepositorio = autorRepositorio;
    }

    public Flux<AutorDTO> ListarAutor(){
        return autorRepositorio.findAll().map(autorMapper.fromCollection());
    }

}
