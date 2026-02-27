package com.pirai.user.service.impl;

import com.pirai.user.communication.WebCommunication;
import com.pirai.user.dto.request.UserRequest;
import com.pirai.user.persistence.entity.Users;
import com.pirai.user.persistence.repository.UsersRepository;
import com.pirai.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;
    private final WebCommunication webCommunication;

    public UserServiceImpl(UsersRepository usersRepository, WebCommunication webCommunication) {
        this.usersRepository = usersRepository;
        this.webCommunication = webCommunication;
    }

    @Override
    public Mono<String> save(UserRequest userRequest) {
        return Mono.just(userRequest).flatMap(ur -> {
            Users users = new Users();
            users.setUserName(ur.getUserName());
            users.setEmailId(ur.getEmailId());
            return Mono.just(users);
        }).flatMap(usersRepository::save).flatMap(users -> webCommunication.getString());
    }

}
