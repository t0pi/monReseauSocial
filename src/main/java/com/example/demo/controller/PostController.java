package com.example.demo.controller;

import com.example.demo.service.PostService;
import com.example.demo.pojo.PostJSON;
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

// The controller for all posts

@Slf4j
@Api(tags = {"Post"})
@RestController
@CrossOrigin
@RequestMapping(value = "posts", produces = MediaType.APPLICATION_JSON_VALUE)
public class PostController {


    @Resource
    private PostService postService; // Methods for the queries

    // Queries by operation.
    // Retrieves all posts
    @ApiOperation(value = "Get all Posts")
    @RequestMapping(method = RequestMethod.GET)
    public List<PostJSON> getAll() {
        return postService.getAllPosts();
    }

    // Retrieves al post by ID

    @ApiOperation(value = "Get one Post", response = PostJSON.class)
    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public PostJSON getBook(@ApiParam(value = "Post id", required = true) @PathVariable long id) {
        return postService.getPostById(id);
    }

    // Adds a post

    @ApiOperation(value = "Add Post", response = PostJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public PostJSON addBook(@ApiParam(value = "Post to Add", required = true) @Valid @RequestBody PostJSON post) {
        // test with @Valid : @Valid @RequestBody ... get Spring Bad Request 400 if NotEmpty
        // or JPA RollbackException (DB side)
        return postService.addPost(post);
    }

    // Retrieves author specific post

    @ApiOperation(value = "Get Post by Author")
    @RequestMapping(method = RequestMethod.GET, value = "/author/{author}")
    // FIXME not good path for REST ...
    public List<PostJSON> getAllByAuthor(@ApiParam(value = "Author",
            required = true) @PathVariable String author) {
        return postService.getAllPostsByAuthor(author);
    }

    // Retrieves Post by title

    @ApiOperation(value = "Get Post by Title")
    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    // FIXME not good path for REST ...
    public List<PostJSON> getAllByTitle(@ApiParam(value = "Title",
            required = true) @PathVariable String title) {
        return postService.getAllPostsByTitle(title);
    }
}
