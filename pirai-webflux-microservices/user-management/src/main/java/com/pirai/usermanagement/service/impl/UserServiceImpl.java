package com.pirai.usermanagement.service.impl;

import com.pirai.usermanagement.communication.WebCommunication;
import com.pirai.usermanagement.constants.MessageKeyConstants;
import com.pirai.usermanagement.dto.request.UserRequest;
import com.pirai.usermanagement.dto.response.ApiGetResponse;
import com.pirai.usermanagement.dto.response.ApiResponse;
import com.pirai.usermanagement.exception.BadRequestException;
import com.pirai.usermanagement.exception.ResourceNotFoundException;
import com.pirai.usermanagement.persistence.repository.UserRepository;
import com.pirai.usermanagement.service.UserService;
import com.pirai.usermanagement.utils.mapper.UserMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final WebCommunication webCommunication;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository usersRepository, WebCommunication webCommunication, UserMapper userMapper) {
        this.userRepository = usersRepository;
        this.webCommunication = webCommunication;
        this.userMapper = userMapper;
    }

    @Override
    public Mono<ApiGetResponse> findAll() {
        return userRepository.findAll()
                .map(userMapper::mapToUserResponse)
                .switchIfEmpty(Mono.error(new ResourceNotFoundException(MessageKeyConstants.USER_NOT_FOUND)))
                .collectList()
                .map(userResponses -> {
                    ApiGetResponse apiGetResponse = new ApiGetResponse();
                    apiGetResponse.setResult(userResponses);
                    return apiGetResponse;
                });
    }



    @Override
    public Mono<ApiResponse> createUser(UserRequest userRequest) {
        return Mono.just(userRequest).map(userMapper::mapToUserEntity)
                .flatMap(userRepository::save)
                .flatMap(users -> webCommunication.getSampleValue());
    }



}
