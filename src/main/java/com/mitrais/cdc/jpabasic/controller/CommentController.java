package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Comment;
import com.mitrais.cdc.jpabasic.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping(path = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Comment>> retrieveData() {
        Iterable<Comment> data = commentRepository.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping(path = "",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveData(@RequestBody Comment data){
        commentRepository.save(data);
        return new ResponseEntity(HttpStatus.OK);
    }
}
