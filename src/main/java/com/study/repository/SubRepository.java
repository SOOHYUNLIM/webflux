package com.study.repository;

import com.study.entity.Sub;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface SubRepository extends R2dbcRepository<Sub, Long> {

    Flux<Sub> findSubsByTestId(Long testId);
}
