package com.study.test.handler;

import com.study.test.entity.Sub;
import com.study.test.entity.Test;
import com.study.test.service.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SubHandler {

    private final SubService subService;

    public Mono<ServerResponse> insert(ServerRequest request) {
        Sub sub = new Sub(1L, request.queryParam("name").orElseGet(()-> "Default Name..."));
        Mono<Sub> result = subService.insert(sub);
        return ServerResponse.ok().body(result, Test.class);
    }
}
