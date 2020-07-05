package com.example.demo.pojo;

import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/

// Table to generate on launch
@Data
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String title;
    @NotEmpty
    @OneToOne
    private User author;
    @NotEmpty
    private String content;
    @NotEmpty
    private String postdate;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public User getAuthor(){
        return this.author;
    }

    public void setAuthor(User user){
        this.author = user;
    }

    public String getPostdate(){
        return this.postdate;
    }

    public void setPostdate(String postDate){
        this.postdate = postDate;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String ToString(){
        return "Post {" +
                "id : "+ id +","+
                "title : "+ title +","+
                "author : "+ author +","+
                "content : "+ content +","+
                "postDate : "+ postdate +
                "}";
    }
}

