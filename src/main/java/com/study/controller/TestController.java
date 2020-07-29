//package com.study.controller;
//
//import com.study.entity.Test;
//import com.study.service.TestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Flux;
//
//@RequiredArgsConstructor
//@RequestMapping("/test")
//@RestController
//public class TestController {
//
//    private final TestService testService;
//
//    @GetMapping("/all")
//    public Flux<Test> getAll() {
//        return testService.findAll();
//    }
//}
