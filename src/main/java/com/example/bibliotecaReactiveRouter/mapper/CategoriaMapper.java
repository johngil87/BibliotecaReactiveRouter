package com.example.bibliotecaReactiveRouter.mapper;

import com.example.bibliotecaReactiveRouter.DTOs.CategoriaDTO;
import com.example.bibliotecaReactiveRouter.model.Categoria;

import java.util.function.Function;

public class CategoriaMapper {

    public Function<Categoria, CategoriaDTO> fromCollection(){
        return categoria -> {
            CategoriaDTO categoriaDTO = new CategoriaDTO();
            categoriaDTO.setIdCategoria(categoria.getId());
            categoriaDTO.setDescripcionCat(categoria.getDescripcion());
            return categoriaDTO;
        };
    }
}
