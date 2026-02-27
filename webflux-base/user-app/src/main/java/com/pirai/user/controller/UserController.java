package com.pirai.user.controller;

import com.pirai.user.dto.request.UserRequest;
import com.pirai.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/apis/user/")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("save")
    public Mono<ResponseEntity<String>> save(@RequestBody UserRequest userRequest) {
        return Mono.just(userRequest).flatMap(userService::save).
                flatMap(string -> Mono.just(ResponseEntity.status(HttpStatus.OK).body(string)));
    }

}