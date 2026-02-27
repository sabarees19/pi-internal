package com.pirai.test.controller;

import com.pirai.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping("/apis/")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("string")
    public Mono<ResponseEntity<String>> getString() {
        return testService.getString()
                .flatMap(string -> Mono.just(ResponseEntity.status(HttpStatus.OK).body(string)));
    }

}