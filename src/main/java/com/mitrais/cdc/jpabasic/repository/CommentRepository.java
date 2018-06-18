package com.mitrais.cdc.jpabasic.repository;

import com.mitrais.cdc.jpabasic.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
