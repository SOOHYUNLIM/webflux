package com.study.config;

import com.study.handler.SubHandler;
import com.study.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;

@EnableWebFlux
@Configuration
public class WebFluxConfig {

    @Bean
    public RouterFunction<ServerResponse> testRoutes(TestHandler testHandler) {
        return RouterFunctions.nest(path("/test"),
                RouterFunctions.route(GET("/insert"), testHandler::insert)
                        .andRoute(GET("/all"), testHandler::getAll)
                        .andRoute(GET("/get/{id}"), testHandler::findById));
    }

    @Bean
    public RouterFunction<ServerResponse> subRoutes(SubHandler subHandler) {
        return RouterFunctions.nest(path("/sub"),
                RouterFunctions.route(GET("/insert"), subHandler::insert));
    }
}
