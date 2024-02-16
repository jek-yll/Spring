package org.example.tp_blog.controler;

import jakarta.validation.Valid;
import org.example.tp_blog.model.Post;
import org.example.tp_blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class PostControler {

    private final IBlogService blogService;

    public PostControler(IBlogService blogService){
        this.blogService = blogService;
    }

    @GetMapping("/") // http://localhost:8080/
    public String homePage(Model model){
        model.addAttribute("posts", blogService.getAllPosts());
        return "homePage";
    }

    @GetMapping("/post/edit") // http://localhost:8080/post/edit
    public String formPost(@RequestParam(value = "id", required = false)UUID id, Model model){
        if (id != null){
            model.addAttribute("post", blogService.getPostById(id));
        } else {
            model.addAttribute("post", new Post());
        }
        return "blog/formPostPage";
    }

    @PostMapping("/post/edit")
    public String editPost(@Valid @ModelAttribute("post")Post post, BindingResult result){
        if (result.hasErrors()){
            return "blog/formPostPage";
        } else {
            if (post.getId() != null){
                blogService.editPost(post.getId(), post);
                return "redirect:/";
            } else {
                blogService.addPost(post);
                return "redirect:/";
            }
        }
    }

    @GetMapping("post/{id}") // http://localhost:8080/post/*
    public String consultPost(@PathVariable("id")UUID id, Model model){
        model.addAttribute("post", blogService.getPostById(id));
        return "blog/postPage";
    }

    @GetMapping("post/delete/{id}") // http://localhost:8080/post/delete/*
    public String deletePost(@PathVariable UUID id){
        blogService.deletePost(id);
        return "redirect:/";
    }
}
