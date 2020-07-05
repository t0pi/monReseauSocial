package com.example.demo.pojo;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigInteger;

@Data
public class UserJSON implements Serializable {

    // Serializable to avoid Cannot serialize redis ERROR !
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String pwd;
    @NotEmpty
    private String mail;

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPwd(){
        return this.pwd;
    }

    public void setPwd(String pwd){
        this.pwd = pwd;
    }

    public String getMail(){
        return this.mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public String ToString(){
        return "Post {" +
                "id : "+ id +","+
                "name : "+ name +","+
                "pwd : "+ pwd +","+
                "mail : "+ mail +
                "}";
    }
}
