package com.pirai.usermanagement.controller;

import com.pirai.usermanagement.constants.MessageKeyConstants;
import com.pirai.usermanagement.dto.request.UserRequest;
import com.pirai.usermanagement.dto.response.ApiGetResponse;
import com.pirai.usermanagement.dto.response.ApiResponse;
import com.pirai.usermanagement.service.UserService;
import com.pirai.usermanagement.utils.CommonUtils;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequestMapping("/apis/user")
public class UserController {

    private final MessageSource messageSource;
    private final UserService userService;

    public UserController(MessageSource messageSource, UserService userService) {
        this.messageSource = messageSource;
        this.userService = userService;
    }

    @PostMapping
    public Mono<ResponseEntity<ApiResponse>> createUser(@RequestBody UserRequest userRequest) {
        return Mono.just(userRequest)
                .flatMap(userService::createUser)
                .doOnNext(apiResponse -> CommonUtils.successMessage(MessageKeyConstants.SUCCESS, messageSource, apiResponse, userRequest))
                .map(apiResponse -> ResponseEntity.status(HttpStatus.CREATED).body(apiResponse));
    }

    @GetMapping
    public Mono<ResponseEntity<ApiGetResponse>> getAllUsers() {
        return userService.findAll()
                .doOnNext(apiGetResponse -> CommonUtils.successMessage(MessageKeyConstants.SUCCESS, messageSource, apiGetResponse, null))
                .map(apiGetResponse -> ResponseEntity.status(HttpStatus.OK).body(apiGetResponse));
    }


}