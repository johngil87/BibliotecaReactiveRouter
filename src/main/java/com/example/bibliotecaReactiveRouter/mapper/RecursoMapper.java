package com.example.bibliotecaReactiveRouter.mapper;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.model.Recurso;

import java.util.function.Function;

public class RecursoMapper {

    public Function<RecursoDTO, Recurso> fromDTO(String id){
            return dto -> {
                var recurso = new Recurso();
                recurso.setId(id);
                recurso.setTitulo(dto.getTituloRecurso());
                recurso.setIdTipoRecurso(dto.getIdTipoRecurso());
                recurso.setFecha(dto.getFechaPrestamo());
                recurso.setIdCategoria(dto.getIdCategoriaRecurso());
                recurso.setIdAutor(dto.getIdAutorRecurso());
                recurso.setDisponible(dto.isDisponibleRecurso());
                return recurso;
            };
    }

    public Function<Recurso,RecursoDTO> fromCollection(){
        return recurso -> {
            var dto = new RecursoDTO();
            dto.setIdRecurso(recurso.getId());
            dto.setTituloRecurso(recurso.getTitulo());
            dto.setIdTipoRecurso(recurso.getIdTipoRecurso());
            dto.setFechaPrestamo(recurso.getFecha());
            dto.setIdCategoriaRecurso(recurso.getIdCategoria());
            dto.setIdAutorRecurso(dto.getIdAutorRecurso());
            dto.setDisponibleRecurso(recurso.isDisponible());
            return dto;
        };
    }



}
