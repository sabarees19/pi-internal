package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.dto.User;
import org.example.repository.UserRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/apis/")
@RequiredArgsConstructor
public class ProfileController {

    private final UserRepo userRepo;

    @GetMapping(value = "users")
    public List<User> getUsers() {
        log.info("getUsers");
        return userRepo.findAll();
    }

    @GetMapping(value = "user/{id}")
    public User getUser(@PathVariable Long id) {
        log.info("getUser");
        return userRepo.findById(id).orElse(new User());
    }

    @PostMapping(value = "user")
    public User saveUser(@RequestBody User user) {
        log.info("saveUser");
        return userRepo.save(user);
    }

}