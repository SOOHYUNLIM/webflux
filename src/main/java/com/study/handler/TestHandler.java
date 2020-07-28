package com.study.handler;

import com.study.entity.Test;
import com.study.service.TestService;
import lombok.RequiredArgsConstructor;
import org.omg.CORBA.ServerRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TestHandler {

    private final TestService testService;

    public Mono<ServerResponse> insert(ServerRequest request) {
        Mono<Test> result = testService.insert(new Test());
        return ServerResponse.ok().body(result, Test.class);
    }

//    public Flux<ServerResponse> getAll(ServerRequest request) {
//        Flux<Test> result = testService.findAll();
//        return ServerResponse.ok().body(result, Test.class);
//    }
}
