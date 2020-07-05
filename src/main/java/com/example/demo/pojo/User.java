package com.example.demo.pojo;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import java.math.BigInteger;

//see https://fxrobin.developpez.com/tutoriels/java/lombok-retour-experience/
@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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