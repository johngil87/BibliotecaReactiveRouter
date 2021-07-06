package com.example.bibliotecaReactiveRouter.router;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.businessusecase.UseCaseDevolverRecurso;
import com.example.bibliotecaReactiveRouter.businessusecase.UseCasePrestarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
@Configuration
public class DevolverRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> devolverRecurso(UseCaseDevolverRecurso devolverRecurso) {
        return route(PUT("/devolverRecurso/{id}"),
                request -> ServerResponse.ok()
                        .body(devolverRecurso.prestarRecurso(request.pathVariable("id")), RespuestaDTO.class));
    }
}
