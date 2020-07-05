package com.example.demo.service;

import com.example.demo.pojo.Comment;
import com.example.demo.pojo.CommentJSON;
import com.example.demo.helper.CommentMapper;
import com.example.demo.repository.CommentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Service
public class CommentService {
    @Resource
    private CommentRepository commentRepository;

    @Resource
    private CommentMapper commentMapper;

   @Cacheable(cacheManager = "redisCacheManager", cacheNames = "comments")
    public CommentJSON addComment(CommentJSON comment) {
        Comment c = commentRepository.save(commentMapper.mapTo(comment));
        return commentMapper.mapTo(c);
    }

    public List<CommentJSON> getAllCommentsByPost(String id) {
        List<Comment> commentList = commentRepository.findByPostId(id);
        return commentMapper.mapTo(commentList);
    }
}
