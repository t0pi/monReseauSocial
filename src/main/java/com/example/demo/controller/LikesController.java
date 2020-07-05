package com.example.demo.controller;

import com.example.demo.pojo.*;
import com.example.demo.service.LikesService;
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
@Api(tags = {"Like"})
@RestController
@CrossOrigin
@RequestMapping(value = "likes", produces = MediaType.APPLICATION_JSON_VALUE)
public class LikesController {

    @Resource
    private LikesService likesService; // Methods for the queries

    // Adds a likes

    @ApiOperation(value = "Add Likes", response = PostJSON.class)
    @RequestMapping(method = RequestMethod.POST,
            value = "/add/{like}", headers = {"Content-type" +
            "=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public LikesJSON addBook(@ApiParam(value = "Likes to Add",
            required = true) @Valid @RequestBody LikesJSON post) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return likesService.addLike(post);
    }

    // Retrieves author specific like

    @ApiOperation(value = "Get Likes by Post")
    @RequestMapping(method = RequestMethod.GET, value = "/{post}/{author}")
    // FIXME not good path for REST ...
    public List<LikesJSON> getLikesByPost(@ApiParam(value = "Likes post",
            required = true) @PathVariable Post post, User author) {
        return likesService.getLikesByPost(post,author);
    }

    @ApiOperation(value = "Delete Likes by Post")
    @RequestMapping(method = RequestMethod.POST, value = "/{post" +
            "}/{author}")
    // FIXME not good path for REST ...
    public void deleteLike(@ApiParam(value = "Delete post author",
            required = true) @PathVariable Post post,@PathVariable User author) {
        likesService.delete(post,author);
        return;
    }
    

    @ApiOperation(value = "Get all Likes")
    @RequestMapping(method = RequestMethod.GET)
    public List<LikesJSON> getAll() {
        return likesService.getAllLikes();
    }

}
