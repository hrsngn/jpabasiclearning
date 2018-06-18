package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Comment;
import com.mitrais.cdc.jpabasic.model.User;
import com.mitrais.cdc.jpabasic.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> retrieveData() {
        Iterable<User> users = userRepository.findAll();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteUser(@RequestBody User user) {
        userRepository.delete(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
