package com.study.test.repository;

import com.study.test.entity.Test;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface TestRepository extends R2dbcRepository<Test, Long> {

}
