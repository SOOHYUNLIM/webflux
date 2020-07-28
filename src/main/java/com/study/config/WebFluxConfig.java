package com.study.config;

import com.study.handler.TestHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@EnableWebFlux
@Configuration
public class WebFluxConfig {
//
//    @Bean
//    public RouterFunction<ServerResponse> routes(TestHandler testHandler) {
//        return RouterFunctions.route(GET("/insert"), testHandler::insert);
//    }
}
