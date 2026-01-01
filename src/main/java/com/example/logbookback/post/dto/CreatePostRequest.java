package com.example.logbookback.post.dto;

import java.util.Set;

public record CreatePostRequest(
        String title,
        String content,
        Set<Long> tags
) {
}
