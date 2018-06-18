package com.mitrais.cdc.jpabasic.repository;

import com.mitrais.cdc.jpabasic.model.unidirectional.PostCommentUni;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentUniRepository extends JpaRepository<PostCommentUni,Long> {
}
