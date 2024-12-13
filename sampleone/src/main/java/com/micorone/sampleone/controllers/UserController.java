package com.micorone.sampleone.controllers;

import com.micorone.sampleone.entities.User;
import com.micorone.sampleone.repository.UserRepository;
import org.slf4j.LoggerFactory;
import  org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/test")
    public String firstCheck() {
        return "Hello world";
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserData() {
        LOGGER.error("getting all the users from database");
        return new ResponseEntity<>(userRepository.findAll() , HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        LOGGER.info("entered into getUser based on id");
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            LOGGER.info("enter into get user is present");
            return ResponseEntity.ok(user.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/user")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userRepository.save(user);
        return ResponseEntity.created(URI.create(saveUser.getId().toString())).body(saveUser);

    }




}
