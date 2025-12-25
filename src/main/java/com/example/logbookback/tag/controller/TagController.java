package com.example.logbookback.tag.controller;

import com.example.logbookback.tag.dto.ChangeTagRequest;
import com.example.logbookback.tag.dto.CreateTagRequest;
import com.example.logbookback.tag.entity.Tag;
import com.example.logbookback.tag.service.TagService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public Tag create(@RequestBody CreateTagRequest request) {
        return tagService.create(request.name());
    }

    @GetMapping
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @PutMapping("/{id}")
    public Tag rename(
            @PathVariable Long id,
            @RequestBody ChangeTagRequest request) {

        return tagService.rename(id, request.name());
    }
}
