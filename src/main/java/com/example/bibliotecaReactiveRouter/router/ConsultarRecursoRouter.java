package com.example.bibliotecaReactiveRouter.router;


import com.example.bibliotecaReactiveRouter.DTOs.RecursoDTO;
import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.businessusecase.UseCaseConsultarDisponibilidadRecurso;
import com.example.bibliotecaReactiveRouter.useCase.UseCaseConsultarRecursoId;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarRecurso(UseCaseConsultarDisponibilidadRecurso caseConsultarDisponibilidadRecurso) {
        return route(GET("/consultarRecurso/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(caseConsultarDisponibilidadRecurso.apply(request.pathVariable("id")), RespuestaDTO.class));
    }
}
