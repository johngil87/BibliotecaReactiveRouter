package com.example.bibliotecaReactiveRouter.router;


import com.example.bibliotecaReactiveRouter.DTOs.AutorDTO;
import com.example.bibliotecaReactiveRouter.useCase.UseCaseCrearAutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearAutorRouter {

    @Bean
    public RouterFunction<ServerResponse> crearAutor(UseCaseCrearAutor useCaseCrearAutor) {
        return route(POST("/crearAutor").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(AutorDTO.class)
                        .flatMap(questionDTO -> useCaseCrearAutor.apply(questionDTO)
                                .flatMap(result -> ServerResponse.ok()
                                        .contentType(MediaType.APPLICATION_JSON)
                                        .bodyValue(result))
                        ));
    }
}
