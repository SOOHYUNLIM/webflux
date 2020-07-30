package com.study.service;

import com.study.entity.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestService {

    Mono<Test> insert(Test test);

    Mono<Test> findById(Long id);

    Flux<Test> findAll();
}
