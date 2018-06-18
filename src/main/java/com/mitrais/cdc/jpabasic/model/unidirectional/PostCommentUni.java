package com.mitrais.cdc.jpabasic.model.unidirectional;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "post_comment")
public class PostCommentUni {
    @Id
    @GeneratedValue
    private Long id;

    private String review;

    private Long postId;

    public PostCommentUni() {
    }

    public PostCommentUni(String review) {
        this.review = review;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
