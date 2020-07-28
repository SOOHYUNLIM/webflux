package com.study.repository;

import com.study.entity.Test;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TestRepository extends R2dbcRepository<Test, Long> {
}
