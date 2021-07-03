package com.example.bibliotecaReactiveRouter.mapper;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.DTOs.RespuestaCategoriaDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;

public class RespuestaCategoriaMapper {

    public Function<List<RecursoDTO>, RespuestaCategoriaDTO> recursoToRespuesta(Mono<String> nombre){
        return recursoDTOFlux -> {
            RespuestaCategoriaDTO respuestaCategoriaDTO = new RespuestaCategoriaDTO();
            respuestaCategoriaDTO.setNombreCategoria(nombre);
            respuestaCategoriaDTO.setListRecurso(recursoDTOFlux);
            return respuestaCategoriaDTO;
        };
    }
}
