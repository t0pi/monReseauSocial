package com.example.demo.pojo;

import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/

// Table to generate on launch
@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @ManyToOne
    private Post post;

    @NotEmpty
    private String date;

    @NotEmpty
    @OneToOne
    private User author;

    @NotEmpty
    private String content;

    public void setPostId(Post id) {
        this.post = id;
    }

    public Post getPostId() {
        return post;
    }
}