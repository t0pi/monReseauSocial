package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

// JSON Data structure
@Data
public class CommentJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !

    private Long id;
    @NotEmpty
    private Post postId;
    @NotEmpty
    private String date;
    @NotEmpty
    private User author;
    @NotEmpty
    private String content;

    public void setPostId(Post id) {
        this.postId = id;
    }

    public Post getPostId() {
        return postId;
    }
}
