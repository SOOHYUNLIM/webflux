package com.study.test.aspect;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.data.redis.core.ReactiveRedisOperations;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

@Aspect
@Component
@RequiredArgsConstructor
public class RedisAspect {

    private final ReactiveRedisOperations reactiveRedisOperations;

    private String generateKey(Object... objects) {
        if(objects == null && objects.length == 0) {
            return "";
        }
        return Arrays.stream(objects).map(Object::toString).collect(Collectors.joining(":"));
    }

    @Around("@annotation(com.study.common.annotation.ReactiveCacheable)")
    public Object reactiveCacheable(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Method method = ((MethodSignature)proceedingJoinPoint.getSignature()).getMethod();

        ParameterizedType parameterizedType = (ParameterizedType)method.getGenericReturnType();
        Type rawType = parameterizedType.getRawType();

        if(!rawType.equals(Mono.class) && !rawType.equals(Flux.class)) {
            throw new IllegalArgumentException("The return type is not Mono/Flux.");
        }

        Object[] args = proceedingJoinPoint.getArgs();
        String key = generateKey(args);
        //key 값을 지정할테고 정규식에 따라 파람을 받아올거고
        //나는 그 파람으로 key를 만들어 내야되고
        //일단 key를 안받고 args로 만든다.


        //캐쉬에 값이 잇으면 바로 리턴
        //아니면 메서드 실행 후 값 넣어놓기

        //결국 return 값이 캐쉬된다. cache name 지정 시 해당 name 사용 - 없을 시 파라미터 값을 키로 만든다
        if(rawType.equals(Mono.class)) {
            return reactiveRedisOperations.opsForValue().get(key).switchIfEmpty(test(key, proceedingJoinPoint.proceed()));
        } else {
            return reactiveRedisOperations.opsForValue().getAndSet(key, proceedingJoinPoint.proceed());
        }
    }

    private Mono<?> test(String key, Object value) {
        reactiveRedisOperations.opsForValue().set(key, value);
        return (Mono<?>) value;
    }
}
