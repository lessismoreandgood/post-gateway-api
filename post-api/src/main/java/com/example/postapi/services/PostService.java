package com.example.postapi.services;

import com.example.postapi.models.Post;

public interface PostService {
    Post getPostById(Long id);

    Post savePost(Post post);

    void deletePostById(Long id);
}
