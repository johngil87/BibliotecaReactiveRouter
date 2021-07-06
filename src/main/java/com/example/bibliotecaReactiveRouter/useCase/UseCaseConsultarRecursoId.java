package com.example.bibliotecaReactiveRouter.useCase;


import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

@Service
@Validated
public class UseCaseConsultarRecursoId {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();

    @Autowired
    public UseCaseConsultarRecursoId(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Mono<RecursoDTO> consultarRecurso(String id){
        return repositorio.findById(id).map(recursoMapper.fromCollection());
    }
}
