package com.example.logbookback.post.controller;

import com.example.logbookback.post.dto.CreatePostRequest;
import com.example.logbookback.post.entity.Post;
import com.example.logbookback.post.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public Post create(@RequestBody CreatePostRequest request) {
        return postService.create(request.title(), request.content(), request.tags());
    }

    @GetMapping
    public List<Post> getAll() {
        return postService.getAll();
    }
}