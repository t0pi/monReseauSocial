package com.example.demo.helper;

import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.security.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

// Some JSON parser equivalent for JSON queries
@Component

public class Mapper {

    public Post mapTo(PostJSON postJSON) {
        Assert.notNull(postJSON, "The postJSON must not be null");
        Post p = new Post();
        // must not set id !
        p.setTitle(postJSON.getTitle());
        p.setAuthor(postJSON.getAuthor());
        p.setPostdate(postJSON.getPostdate());
        p.setContent(postJSON.getContent());
        return p;
    }


    public PostJSON mapTo(Post post) {
        Assert.notNull(post, "The post must not be null");
        PostJSON bJSON = new PostJSON();
        bJSON.setTitle(post.getTitle());
        bJSON.setPostdate(post.getPostdate());
        bJSON.setAuthor(post.getAuthor());
        bJSON.setId(post.getId());
        bJSON.setContent(post.getContent());
        return bJSON;
    }

    public List<PostJSON> mapTo(List<Post> bookList) {
        Assert.notNull(bookList, "The bookList must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
