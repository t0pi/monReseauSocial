package com.example.demo.helper;

import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CommentMapper {

    public Comment mapTo(CommentJSON commentJSON) {
        Assert.notNull(commentJSON, "The commentJSON must not be null");
        Comment c = new Comment();
        // must not set id !
        c.setAuthor(commentJSON.getAuthor());
        c.setContent(commentJSON.getContent());
        c.setDate(commentJSON.getDate());
        c.setPostId(commentJSON.getPostId());

        return c;
    }

    public CommentJSON mapTo(Comment comment) {
        Assert.notNull(comment, "The comment must not be null");
        CommentJSON cJSON = new CommentJSON();
        cJSON.setAuthor(comment.getAuthor());
        cJSON.setId(comment.getId());
        cJSON.setPostId(comment.getPostId());
        cJSON.setContent(comment.getContent());
        cJSON.setDate(comment.getDate());
        return cJSON;
    }

    public List<CommentJSON> mapTo(List<Comment> commentList) {
        Assert.notNull(commentList, "The commentList must not be null");
        return commentList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
