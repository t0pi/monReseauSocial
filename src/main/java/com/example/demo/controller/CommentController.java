package com.example.demo.controller;

import com.example.demo.pojo.PostJSON;
import com.example.demo.service.CommentService;
import com.example.demo.pojo.CommentJSON;
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

// The controller for all comments

@Slf4j
@Api(tags = {"Comment"})
@RestController
@CrossOrigin
@RequestMapping(value = "comments", produces = MediaType.APPLICATION_JSON_VALUE)

public class CommentController {

    @Resource
    private CommentService commentService; // Methods for the queries

    // Queries by operation.

    // Select comments by post id
    @ApiOperation(value = "Get comment by post id")
    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    // FIXME not good path for REST ...
    public List<CommentJSON> getAllByPostId(@ApiParam(value = "PostId",
            required = true) @PathVariable String id) {
        return commentService.getAllCommentsByPost(id);
    }

    // Adds a comment
    @ApiOperation(value = "Add Comments", response = PostJSON.class)
    @RequestMapping(method = RequestMethod.POST, headers = {"Content-type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public CommentJSON addComment(@ApiParam(value = "Comment to Add", required = true) @Valid @RequestBody CommentJSON comment) {
        return commentService.addComment(comment);
    }
}
