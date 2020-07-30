package com.study.repository;

import com.study.entity.Test;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface TestRepository extends R2dbcRepository<Test, Long> {

}
