package com.study.test.service.impl;

import com.study.common.annotation.ReactiveCacheable;
import com.study.test.entity.Test;
import com.study.test.repository.TestRepository;
import com.study.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    private final ReactiveRedisOperations reactiveRedisOperations;

    @Override
    public Mono<Test> insert(Test test) {
        return testRepository.save(test);
    }

    @ReactiveCacheable
    @Override
    public Mono<Test> findById(Long id) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return testRepository.findById(id);
    }

    @ReactiveCacheable
    @Override
    public Flux<Test> findAll() {
        return testRepository.findAll();
    }
}
