package com.example.bibliotecaReactiveRouter.router;

import com.example.bibliotecaReactiveRouter.DTOs.RespuestaDTO;
import com.example.bibliotecaReactiveRouter.businessusecase.UseCaseRespuestaCategoria;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ConsultarPorCategoria {

    @Bean
    public RouterFunction<ServerResponse> consultarPorCat(UseCaseRespuestaCategoria useCaseRespuestaCategoria){
        return route(GET("/consultarPorCategoria/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                        .body(useCaseRespuestaCategoria.respuestaCategoria(request.pathVariable("id")), RespuestaDTO.class));

    }
}
