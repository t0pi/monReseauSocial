package com.example.demo.controller;

import com.example.demo.service.UserService;
import com.example.demo.pojo.UserJSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = {"User"})
@RestController
@CrossOrigin
@RequestMapping(value = "users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "Get all Users")
    @RequestMapping(method = RequestMethod.GET)
    public List<UserJSON> getAll() {
        return userService.getAllUsers();
    }

    @ApiOperation(value = "Get one User", response = UserJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public UserJSON getUser(@ApiParam(value = "User id", required = true) @PathVariable long id) {
        return userService.getUserById(id);
    }

    @ApiOperation(value = "Add User", response = UserJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserJSON addUser(@ApiParam(value = "User to Add", required = true) @Valid @RequestBody UserJSON user) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return userService.addUser(user);
    }

    @ApiOperation(value = "Get User by Name")
    @RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
    // FIXME not good path for REST ...
    public List<UserJSON> getAllByName(@ApiParam(value = "Name", required =
            true) @PathVariable String name) {
        return userService.getAllUsersByName(name);
    }

    @ApiOperation(value = "Get Users by Mail")
    @RequestMapping(method = RequestMethod.GET, value = "/mail/{mail}")
    // FIXME not good path for REST ...
    public List<UserJSON> getAllByMail(@ApiParam(value = "Mail", required =
            true) @PathVariable String mail) {
        return userService.getAllUsersByMail(mail);
    }

}
