package com.example.bibliotecaReactiveRouter.businessusecase;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaCategoriaDTO;
import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.mapper.RecursoMapper;
import com.example.bibliotecaReactiveRouter.mapper.RespuestaMapper;
import com.example.bibliotecaReactiveRouter.model.Recurso;
import com.example.bibliotecaReactiveRouter.repository.RecursoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Validated
public class UseCaseDevolverRecurso {

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
    private RecursoMapper recursoMapper = new RecursoMapper();
    private final RecursoRepositorio repositorio;
    private RespuestaMapper respuestaMapper = new RespuestaMapper();

    @Autowired
    public UseCaseDevolverRecurso(RecursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public Mono<RespuestaDTO> prestarRecurso(String nombre) {

        var resultado = repositorio.findById(nombre);
        var editarResultado = resultado.flatMap(repuesta-> {
            if(!repuesta.isDisponible()){
                repuesta.setDisponible(true);
                repuesta.setFecha(objSDF.format(objDate));
            }
            return repositorio.save(repuesta);
        });
        var bole = resultado.map(Recurso::isDisponible);
        return editarResultado.map(recursoMapper.fromCollection()).map(edit1-> respuestaMapper.fromPrestarRecurso().apply(edit1,bole));
    }
}
