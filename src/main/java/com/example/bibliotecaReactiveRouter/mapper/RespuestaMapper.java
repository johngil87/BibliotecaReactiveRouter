package com.example.bibliotecaReactiveRouter.mapper;

import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Function;

public class RespuestaMapper {

    private Date objDate = new Date();
    private String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
    private SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);

    public Function<RecursoDTO, RespuestaDTO> fromConsultarRecurso(){
        return recurso->{
            RespuestaDTO respuesta = new RespuestaDTO();
            String mensaje = recurso.isDisponibleRecurso()?"EL libro esta disponible para prestamo" : "El libro no esta disponible";
            respuesta.setMensaje(mensaje);
            respuesta.setEstado(recurso.isDisponibleRecurso());
            respuesta.setNombre(recurso.getTituloRecurso());
            respuesta.setFecha(recurso.getFechaPrestamo());
            return respuesta;
        };
    }

    public Function<RecursoDTO, RespuestaDTO> fromPrestarRecurso(){
        return recurso -> {
            RespuestaDTO respuesta = new RespuestaDTO();
            String mensaje = recurso.isDisponibleRecurso()?"Acabas de obtener el Libro" : "El libro no esta disponible para ser prestado";
            respuesta.setMensaje(mensaje);
            respuesta.setEstado(recurso.isDisponibleRecurso());
            respuesta.setNombre(recurso.getTituloRecurso());
            respuesta.setFecha(objSDF.format(objDate));
            return respuesta;

        };
    }

}
