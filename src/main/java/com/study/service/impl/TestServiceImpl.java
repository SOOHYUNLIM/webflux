package com.study.service.impl;

import com.study.entity.Test;
import com.study.repository.TestRepository;
import com.study.service.TestService;
import lombok.RequiredArgsConstructor;
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
    public Mono<Test> findByNo(Long no) {
        return testRepository.findByIdJoinSub(no);
    }

    @Override
    public Flux<Test> findAll() {
        return testRepository.findAll();
    }
}
