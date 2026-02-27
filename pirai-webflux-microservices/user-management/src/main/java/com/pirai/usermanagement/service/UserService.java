package com.pirai.usermanagement.service;


import com.pirai.usermanagement.dto.request.UserRequest;
import com.pirai.usermanagement.dto.response.ApiGetResponse;
import com.pirai.usermanagement.dto.response.ApiResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

    Mono<ApiGetResponse> findAll();

    Mono<ApiResponse> createUser(UserRequest userRequest);
}
