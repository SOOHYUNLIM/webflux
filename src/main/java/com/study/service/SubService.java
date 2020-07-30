package com.study.service;

import com.study.entity.Sub;
import reactor.core.publisher.Mono;

public interface SubService {

    Mono<Sub> insert(Sub sub);
}
