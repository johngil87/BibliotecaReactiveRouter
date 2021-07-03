package com.example.bibliotecaReactiveRouter.router;

import com.example.bibliotecaReactiveRouter.DTOs.AutorDTO;
import com.example.bibliotecaReactiveRouter.useCase.UseCaseListarAutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;

@Configuration
public class ListarAutorRouter {

    @Bean
    public RouterFunction<ServerResponse> listarAutor(UseCaseListarAutor useCaseListarAutor) {
        return route(GET("/consultarAutor").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(BodyInserters.fromPublisher(useCaseListarAutor.ListarAutor(), AutorDTO.class)));
    }

}
