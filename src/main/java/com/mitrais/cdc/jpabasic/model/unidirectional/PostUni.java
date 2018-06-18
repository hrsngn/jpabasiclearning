package com.mitrais.cdc.jpabasic.model.unidirectional;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post")
public class PostUni {
    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JoinColumn(name="postId")
    private List<PostCommentUni> comments = new ArrayList<>();

    public PostUni() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<PostCommentUni> getComments() {
        return comments;
    }

    public void setComments(List<PostCommentUni> comments) {
        this.comments = comments;
    }
}
