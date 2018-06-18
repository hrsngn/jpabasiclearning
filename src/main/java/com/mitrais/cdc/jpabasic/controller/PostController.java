package com.mitrais.cdc.jpabasic.controller;

import com.mitrais.cdc.jpabasic.model.Comment;
import com.mitrais.cdc.jpabasic.model.unidirectional.PostCommentUni;
import com.mitrais.cdc.jpabasic.model.unidirectional.PostUni;
import com.mitrais.cdc.jpabasic.repository.PostCommentUniRepository;
import com.mitrais.cdc.jpabasic.repository.PostUniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    PostUniRepository postUniRepository;

    @Autowired
    PostCommentUniRepository postCommentUniRepository;

    @GetMapping("")
    public ResponseEntity<List<PostUni>> getAll() {
        List<PostUni> data = postUniRepository.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("/postComment")
    public ResponseEntity<List<PostCommentUni>> getAllPostComment() {
        List<PostCommentUni> data = postCommentUniRepository.findAll();
        return new ResponseEntity(data, HttpStatus.OK);
    }
}
