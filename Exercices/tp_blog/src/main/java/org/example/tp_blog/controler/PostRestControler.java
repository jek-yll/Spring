package org.example.tp_blog.controler;

import org.example.tp_blog.model.Post;
import org.example.tp_blog.service.IBlogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/blog")
public class PostRestControler {

    private final IBlogService blogService;

    public PostRestControler(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/posts") // http://localhost:8080/api/v1/blog/posts
    public List<Post> getPosts(){
        return blogService.getAllPosts();
    }

}
