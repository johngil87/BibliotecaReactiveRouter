package com.example.bibliotecaReactiveRouter.businessusecase;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.mapper.RespuestaMapper;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
@Validated
public class UseCaseConsultarDisponibilidadRecurso implements Function<String,Mono<RespuestaDTO>> {

    private final RecursoRepositorio repositorio;
    private RecursoMapper recursoMapper = new RecursoMapper();
    private RespuestaMapper respuestaMapper = new RespuestaMapper();

    @Autowired
    public UseCaseConsultarDisponibilidadRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }


    @Override
    public Mono<RespuestaDTO> apply(String id) {
        var recurso = repositorio.findById(id).map(recursoMapper.fromCollection());
        return  recurso.map(respuestaMapper.fromConsultarRecurso());
    }
}
