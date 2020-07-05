package com.example.demo.helper ;

import com.example.demo.pojo.User;
import com.example.demo.pojo.UserJSON;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    public User mapTo(UserJSON bookJSON) {
        Assert.notNull(bookJSON, "The bookJSON must not be null");
        User b = new User();
        // must not set id !
        b.setName(bookJSON.getName());
        b.setPwd(bookJSON.getPwd());
        b.setMail(bookJSON.getMail());
        return b;
    }

    public UserJSON mapTo(User book) {
        Assert.notNull(book, "The book must not be null");
        UserJSON bJSON = new UserJSON();
        bJSON.setName(book.getName());
        bJSON.setPwd(book.getPwd());
        bJSON.setId(book.getId());
        bJSON.setMail(book.getMail());
        return bJSON;
    }

    public List<UserJSON> mapTo(List<User> bookList) {
        Assert.notNull(bookList, "The userlist must not be null");
        return bookList.stream().map(this::mapTo).collect(Collectors.toList());
    }
}
