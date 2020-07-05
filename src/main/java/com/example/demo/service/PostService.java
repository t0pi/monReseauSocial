package com.example.demo.service;

import com.example.demo.helper.Mapper;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.PostJSON;
import com.example.demo.repository.PostRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// SQL methods resources
@Slf4j
@Service
public class PostService {

    @Resource
    private PostRepository postRepository;

    @Resource
    private Mapper mapper;

    private Logger LOGGER = Logger.getLogger("logger");

    public List<PostJSON> getAllPosts() {
        //log.info("Called for getAllBooks ...");
        List<Post> bookList = postRepository.findAll();
        return mapper.mapTo(bookList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "books", key = "#id")
    public PostJSON getPostById(long id) {
        //log.info("Called for getBookById ...");
        LOGGER.log(Level.INFO,"Post ID : " + id);
        Post b = postRepository.getOne(id);
        return mapper.mapTo(b);
    }

    public PostJSON addPost(PostJSON book) {
        Post b = postRepository.save(mapper.mapTo(book));
        return mapper.mapTo(b);
    }

    public List<PostJSON> getAllPostsByAuthor(String author) {
        List<Post> bookList = postRepository.findByAuthor(author);
        return mapper.mapTo(bookList);
    }

    public List<PostJSON> getAllPostsByTitle(String title) {
        List<Post> bookList = postRepository.findByTitle(title);
        return mapper.mapTo(bookList);
    }
}
