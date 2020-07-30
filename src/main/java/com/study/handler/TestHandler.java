package com.study.handler;

import com.study.dto.TestDto;
import com.study.entity.Test;
import com.study.service.SubService;
import com.study.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class TestHandler {

    private final TestService testService;

    private final SubService subService;

    public Mono<ServerResponse> insert(ServerRequest request) {
        Test test = new Test(request.queryParam("title").orElseGet(()-> "Default Title..."));
        Mono<Test> result = testService.insert(test);
        return ServerResponse.ok().body(result, Test.class);
    }

    public Mono<ServerResponse> getAll(ServerRequest request) {
        Flux<Test> result = testService.findAll();
        return ServerResponse.ok().body(result, Test.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        Mono<Test> result = testService.findById(Long.valueOf(request.pathVariable("id")))
                .flatMap(test ->
                    Mono.just(test).zipWith(subService.findByTestId(test.getId()).collectList())
                        .map(tupla -> tupla.getT1().withSubs(tupla.getT2()))
                );
        return ServerResponse.ok().body(result, Test.class);
    }
}
