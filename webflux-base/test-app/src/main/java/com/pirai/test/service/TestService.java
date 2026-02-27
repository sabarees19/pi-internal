package com.pirai.test.service;

import reactor.core.publisher.Mono;

public interface TestService {

    Mono<String> getString();
}
