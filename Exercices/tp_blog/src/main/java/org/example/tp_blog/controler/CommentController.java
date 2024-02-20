package org.example.tp_blog.controler;

import org.example.tp_blog.model.Comment;
import org.example.tp_blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;


@Controller
public class CommentController {

    private final IBlogService blogService;

    public CommentController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/addComment" )
    public String editComment(@ModelAttribute("comment") Comment comment, @RequestParam("postId")UUID id){
        comment.setPost(blogService.getPostById(id));
        blogService.addComment(comment);
        return "redirect:/post/" + id;
    }
}
