package com.example.demo.service;

import com.example.demo.helper.UserMapper;
import com.example.demo.pojo.PostJSON;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserJSON;
import com.example.demo.repository.UserRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Service
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserMapper userMapper;

    public List<UserJSON> getAllUsers() {
        // log.info("Called for getAllUsers ...");
        List<User> bookList = userRepository.findAll();
        return userMapper.mapTo(bookList);
    }

    @Cacheable(cacheManager = "redisCacheManager", cacheNames = "users", key =
            "#id")
    public UserJSON getUserById(long id) {
        // log.info("Called for getUserById ...");
        User b = userRepository.getOne(id);
        return userMapper.mapTo(b);
    }

    public UserJSON addUser(UserJSON book) {
        User b = userRepository.save(userMapper.mapTo(book));
        return userMapper.mapTo(b);
    }

    public List<UserJSON> getAllUsersByMail(String mail) {
        List<User> bookList = userRepository.findByMail(mail);
        return userMapper.mapTo(bookList);
    }

    public List<UserJSON> getAllUsersByName(String title) {
        List<User> bookList = userRepository.findByName(title);
        return userMapper.mapTo(bookList);
    }
}
