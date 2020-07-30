package com.study.service.impl;

import com.study.entity.Sub;
import com.study.repository.SubRepository;
import com.study.service.SubService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class SubServiceImpl implements SubService {

    private final SubRepository subRepository;

    @Override
    public Mono<Sub> insert(Sub sub) {
        return subRepository.save(sub);
    }

    @Override
    public Flux<Sub> findByTestId(Long testId) {
        return subRepository.findSubsByTestId(testId);
    }

}
