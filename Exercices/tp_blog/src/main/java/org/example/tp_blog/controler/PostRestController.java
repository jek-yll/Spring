package org.example.tp_blog.controler;

import jakarta.validation.Valid;
import org.example.tp_blog.model.Post;
import org.example.tp_blog.service.IBlogService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/blog")
public class PostRestController {

    private final IBlogService blogService;

    public PostRestController(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/posts") // http://localhost:8080/api/v1/blog/posts
    public List<Post> getPosts(){
        return blogService.getAllPosts();
    }

    @GetMapping("/post/{id}") // http://localhost:8080/api/v1/blog/post/*
    public Post getPost(@PathVariable UUID id){
        return blogService.getPostById(id);
    }

    @DeleteMapping("/post/{id}") // http://localhost:8080/api/v1/blog/post/*
    public Boolean deletePost(@PathVariable UUID id){
        return blogService.deletePost(id);
    }

    @PostMapping("/post") // http://localhost:8080/api/v1/blog/post
    public ResponseEntity<String> addPost(@Valid @RequestBody Post post, BindingResult result){
        if (result.hasErrors()){
            StringBuilder errors = new StringBuilder();
            result.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" / "));
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        } else {
            blogService.addPost(post);
            return new ResponseEntity<>("Post added successfully with id : " + post.getId(), HttpStatus.CREATED);
        }
    }

    @PutMapping("/post/{id}") // http://localhost:8080/api/v1/blog/post/*
    public ResponseEntity<String> updateStudent(@PathVariable UUID id, @Valid @RequestBody Post postUpdated, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            StringBuilder errors = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError -> errors.append(objectError.toString()).append(" / "));
            return new ResponseEntity<>(errors.toString(), HttpStatus.BAD_REQUEST);
        } else {
            blogService.editPost(id, postUpdated);
            return new ResponseEntity<>("Post edited successfully", HttpStatus.ACCEPTED);
        }
    }

}
