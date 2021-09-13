package com.example.postapi.services.impl;

import com.example.postapi.models.Post;
import com.example.postapi.repositories.PostRepository;
import com.example.postapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;

    @Override
    public Post getPostById(Long id) {
        return postRepository.getById(id);
    }

    @Override
    public Post savePost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}
