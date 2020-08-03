package com.study.config;

import com.study.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.*;

@Configuration
@EnableRedisRepositories
@RequiredArgsConstructor
public class RedisConfig {

    private final RedisProperties redisProperties;

        private RedisSerializationContext redisSerializationContext() {
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        RedisSerializer<Object> genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();

        return RedisSerializationContext.<String, Object>newSerializationContext()
                .key(stringRedisSerializer)
                .value(genericJackson2JsonRedisSerializer)
                .hashKey(stringRedisSerializer)
                .hashValue(genericJackson2JsonRedisSerializer)
                .build();
    }

    @Bean
    public ReactiveRedisConnectionFactory reactiveRedisConnectionFactory() {
        return new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());
    }

    @Bean
    public ReactiveRedisOperations<String, Object> redisOperations(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, redisSerializationContext());
    }
}
