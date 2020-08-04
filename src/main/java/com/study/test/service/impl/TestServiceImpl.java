package com.study.test.service.impl;

import com.study.test.entity.Test;
import com.study.test.repository.TestRepository;
import com.study.test.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository testRepository;

    @Override
    public Mono<Test> insert(Test test) {
        return testRepository.save(test);
    }

    @Override
    public Mono<Test> findById(Long id) {
        return testRepository.findById(id);
    }

    @Override
    public Flux<Test> findAll() {
        return testRepository.findAll();
    }
}
