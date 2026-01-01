package com.example.logbookback.post.service;

import com.example.logbookback.post.entity.Post;
import com.example.logbookback.post.repository.PostRepository;
import com.example.logbookback.tag.entity.Tag;
import com.example.logbookback.tag.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final TagRepository tagRepository;

    public PostService(PostRepository postRepository, TagRepository tagRepository) {
        this.postRepository = postRepository;
        this.tagRepository = tagRepository;
    }

    @Transactional
    public Post create(String title, String content, Set<Long> tagIds) {
        List<Tag> tagsList = tagRepository.findAllById(tagIds);

        if (tagIds.size() != tagsList.size()) {
            throw new RuntimeException("One or more tags do not exist");
        }

        Set<Tag> tags = new HashSet<>(tagsList);
        Post post = new Post(title, content, tags);

        return postRepository.save(post);
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }
}
