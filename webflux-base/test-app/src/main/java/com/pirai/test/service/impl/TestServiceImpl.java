package com.pirai.test.service.impl;

import com.pirai.test.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class TestServiceImpl implements TestService {

    @Override
    public Mono<String> getString() {
        return Mono.just("test");
    }

}
