package com.example.bibliotecaReactiveRouter.businessusecase;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaCategoriaDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.mapper.RespuestaCategoriaMapper;
import com.example.bibliotecaReactiveRouter.mapper.RespuestaMapper;
import com.example.bibliotecaReactiveRouter.model.Categoria;
import com.example.bibliotecaReactiveRouter.repository.CategoriaRepositorio;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@Validated
public class UseCaseRespuestaCategoria {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();
    private RespuestaCategoriaMapper respuestaCategoriaMapper = new RespuestaCategoriaMapper();
    private final CategoriaRepositorio categoriaRepositorio;

    @Autowired
    public UseCaseRespuestaCategoria(RecursoRepositorio repositorio, CategoriaRepositorio categoriaRepositorio) {
        this.repositorio = repositorio;
        this.categoriaRepositorio = categoriaRepositorio;
    }

    public Flux<RespuestaCategoriaDTO> respuestaCategoria(String id){
        var nombreCategoria = categoriaRepositorio.findById(id);
        var recurso = repositorio.findRecursoByidCategoria(nombreCategoria.map(Categoria::getId));
        var recursoDTO = recurso.map(recursoMapper.fromCollection());
        var fsd =  recursoDTO.buffer();
        var nombre = nombreCategoria.flatMap()
        return fsd.map(respuestaCategoriaMapper.recursoToRespuesta(nombreCategoria.map(Categoria::getDescripcion)));
    }
}
