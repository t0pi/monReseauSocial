package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

// JSON Data structure
@Data
public class MessagesJSON implements Serializable {

    private Long id;
    @NotEmpty
    @OneToOne
    private User dest ;
    @NotEmpty
    @OneToOne
    private User author;
    @NotEmpty
    private String content;
    @NotEmpty
    private String dt;
    @NotEmpty
    private Boolean read;

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

    public User getDest(){
        return this.dest;
    }

    public void setDest(User user){
        this.dest = user;
    }

    public String getContent(){
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }

    public String getDt(){
        return this.dt;
    }

    public void setDt(String content){
        this.dt = content;
    }

    public Boolean getRead(){
        return this.read;
    }

    public void setRead(Boolean read){
        this.read = read;
    }

    public String ToString(){
        return "Message {" +
                "id : "+ id +","+
                "dest : "+ dest +","+
                "author : "+ author +","+
                "content : "+ content +","+
                "dt : "+ dt +","+
                "read : "+ read +
                "}";
    }
}
