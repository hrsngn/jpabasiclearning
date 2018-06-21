package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Address;
import com.mitrais.cdc.jpabasic.model.Alias;
import com.mitrais.cdc.jpabasic.model.Comment;
import com.mitrais.cdc.jpabasic.model.User;
import com.mitrais.cdc.jpabasic.repository.CommentRepository;
import com.mitrais.cdc.jpabasic.repository.UserRepository;
import com.mitrais.cdc.jpabasic.repository.impl.UserRepositoryCustomImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private UserRepositoryCustomImpl userRepositoryCustom;

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

    @PostMapping(path = "{id}/comment",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveComment(@PathVariable Integer id,@RequestBody Comment data){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            data.setUser(user.get());
            Comment saved = commentRepository.save(data);
            Set<Comment> comments = user.get().getComments();
            comments.add(saved);
            user.get().setComments(comments);
            userRepository.save(user.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "{id}/address",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveAddress(@PathVariable Integer id,@RequestBody Address data){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setAddress(data);
            userRepository.save(user.get());
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity deleteUser(@RequestBody User user) {
//        userRepository.delete(user);
        userRepositoryCustom.deleteById(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(path = "/name/{data}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity getByName(@PathVariable String data){
        List<User> result = userRepositoryCustom.findByName(data);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    @PutMapping(path = "")
    public ResponseEntity updateName(@RequestBody User user){
        userRepositoryCustom.updateName(user);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path = "/alias/{id}")
    public ResponseEntity saveAlias(@PathVariable Integer id,@RequestBody Alias data){
        Optional<User> user = userRepository.findById(id);
        Set<Alias> setku = user.get().getAlias();
        setku.add(data);
        user.get().setAlias(setku);
        userRepository.save(user.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}
