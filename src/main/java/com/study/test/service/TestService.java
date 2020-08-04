package com.study.test.service;

import com.study.test.entity.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TestService {

    Mono<Test> insert(Test test);

    Mono<Test> findById(Long id);

    Flux<Test> findAll();
}
