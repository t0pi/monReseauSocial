package com.example.demo.helper;

import com.example.demo.pojo.Messages;
import com.example.demo.pojo.MessagesJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MessagesMapper {
    public Messages mapTo(MessagesJSON bookJSON) {
        Assert.notNull(bookJSON, "The likesJSON must not be null");
        Messages b = new Messages();
        // must not set id !
        b.setDest(bookJSON.getDest());
        b.setAuthor(bookJSON.getAuthor());
        b.setContent(bookJSON.getContent());
        b.setDt(bookJSON.getDt());
        b.setRead(bookJSON.getRead());
        return b;
    }
    public MessagesJSON mapTo(Messages likes) {
        Assert.notNull(likes, "The likes must not be null");
        MessagesJSON b = new MessagesJSON();
        b.setId(b.getId());
        b.setDest(likes.getDest());
        b.setAuthor(likes.getAuthor());
        b.setContent(likes.getContent());
        b.setDt(likes.getDt());
        b.setRead(likes.getRead());
        return b;
    }

    /**public <Compteur> Compteur mapTo(Compteur compteur) {
     Assert.notNull(compteur, "The count must not be null");
     compteur.setCompteur(compteur.getCompteur());
     return compteur;
     }*/

    public List<MessagesJSON> mapTo(List<Messages> likesList) {
        Assert.notNull(likesList, "The likesList must not be null");
        return likesList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
