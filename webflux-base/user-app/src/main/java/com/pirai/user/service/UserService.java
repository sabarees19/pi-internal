package com.pirai.user.service;

import com.pirai.user.dto.request.UserRequest;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<String> save(UserRequest userRequest);
}
