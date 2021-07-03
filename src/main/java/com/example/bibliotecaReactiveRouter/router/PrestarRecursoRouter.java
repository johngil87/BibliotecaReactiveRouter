package com.example.bibliotecaReactiveRouter.router;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.businessusecase.UseCasePrestarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PrestarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> prestarRecurso(UseCasePrestarRecurso prestarRecurso) {
        return route(PUT("/prestarRecurso/{id}"),
                request -> ServerResponse.ok()
                        .body(prestarRecurso.prestarRecurso(request.pathVariable("id")),RespuestaDTO.class));
    }

}
