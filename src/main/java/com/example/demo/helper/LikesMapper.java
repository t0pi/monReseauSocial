package com.example.demo.helper;

import com.example.demo.pojo.Likes;
import com.example.demo.pojo.LikesJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LikesMapper {
    public Likes mapTo(LikesJSON bookJSON) {
        Assert.notNull(bookJSON, "The likesJSON must not be null");
        Likes b = new Likes();
        // must not set id !
        b.setAuthor(bookJSON.getAuthor());
        b.setPost(bookJSON.getPost());
        return b;
    }
    public LikesJSON mapTo(Likes likes) {
        Assert.notNull(likes, "The likes must not be null");
        LikesJSON bJSON = new LikesJSON();
        bJSON.setId(likes.getId());
        bJSON.setAuthor(likes.getAuthor());
        bJSON.setPost(likes.getPost());
        return bJSON;
    }

    public List<LikesJSON> mapTo(List<Likes> likesList) {
        Assert.notNull(likesList, "The likesList must not be null");
        return likesList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
