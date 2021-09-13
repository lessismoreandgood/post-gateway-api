package com.example.postapi.rest;

import com.example.postapi.feign.ClientFeign;
import com.example.postapi.models.Post;
import com.example.postapi.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post/")
public class PostRestController {
    @Autowired
    PostService postService;

    @GetMapping("{post_id}")
    public ResponseEntity<Post> getPost(@PathVariable(name = "post_id") Long postId){
        Post post = postService.getPostById(postId);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<Post> addPost(@RequestBody Post post){
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.savePost(post);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("update/{post_id}")
    public ResponseEntity<Post> updatePost(@PathVariable(name = "post_id") Long postId, @RequestBody Post post){
        if (post == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        postService.savePost(post);

        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @DeleteMapping("delete/{post_id}")
    public ResponseEntity<Post> deletePostById(@PathVariable(name = "post_id") Long postId){
        Post post = postService.getPostById(postId);

        if (post == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        postService.deletePostById(postId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
