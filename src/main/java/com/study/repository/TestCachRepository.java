package com.study.repository;

import com.study.entity.Test;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface TestCachRepository extends ReactiveCrudRepository<Test, Long> {
}
