package com.example.bibliotecaReactiveRouter.mapper;

import com.example.bibliotecaReactiveRouter.DTOs.AutorDTO;
import com.example.bibliotecaReactiveRouter.model.Autor;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AutorMapper {

    public Function<AutorDTO, Autor> fromDTO(){
        return autorDTO -> {
            var autor = new Autor();
            autor.setId(autorDTO.getIdAutor());
            autor.setIdNacionalidad(autorDTO.getIdNacionalidadAutor());
            autor.setNombre(autorDTO.getNombreAutor());
            return autor;
        };
    }

    public Function<Autor, AutorDTO> fromCollection(){
        return autor -> {
            var autorDTO = new AutorDTO();
            autorDTO.setIdAutor(autor.getId());
            autorDTO.setIdNacionalidadAutor(autor.getIdNacionalidad());
            autorDTO.setNombreAutor(autor.getNombre());
            return autorDTO;
        };
    }

    public Function<List<Autor>, List<AutorDTO>> listFromCollection(){
            return listCol-> listCol.stream().map(it-> fromCollection().apply(it)).collect(Collectors.toUnmodifiableList());
    }
}
