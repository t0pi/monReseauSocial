package com.example.demo.service;

import com.example.demo.helper.LikesMapper;
import com.example.demo.pojo.Likes;
import com.example.demo.pojo.LikesJSON;
import com.example.demo.pojo.Post;
import com.example.demo.pojo.User;
import com.example.demo.repository.LikesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

// SQL methods resources
@Slf4j
@Service
public class LikesService {

    @Resource
    private LikesRepository likesRepository;

    @Resource
    private LikesMapper likesMapper;

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "likes")
    public List<LikesJSON> getLikesByPost(Post post, User author)
    {
        List<Likes> b = likesRepository.findByPost(post, author);
        return likesMapper.mapTo(b);
    }

    public List<LikesJSON> delete(Post post, User author)
    {
        List<Likes> b = likesRepository.delete(post, author);
        return likesMapper.mapTo(b);
    }

    public LikesJSON addLike(LikesJSON likes)
    {
        Likes l = likesRepository.save(likesMapper.mapTo(likes));
        return likesMapper.mapTo(l);
    }

    public List<LikesJSON> getAllLikes()
    {
        List<Likes> bookList = likesRepository.findAll();
        return likesMapper.mapTo(bookList);
    }
}
