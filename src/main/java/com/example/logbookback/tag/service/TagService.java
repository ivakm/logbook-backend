package com.example.logbookback.tag.service;

import com.example.logbookback.tag.entity.Tag;
import com.example.logbookback.tag.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Tag create(String name) {
        Tag tag = new Tag(name);
        return tagRepository.save(tag);
    }

    @Transactional
    public Tag rename(Long id, String name) {
        Tag tag = tagRepository.findById(id).orElseThrow();
        tag.rename(name);
        return tag;
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }
}
