package org.example.tp_blog.controler;

import org.example.tp_blog.model.Comment;
import org.example.tp_blog.service.IBlogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class CommentController {

    private final IBlogService blogService;

    public CommentController(IBlogService blogService) {
        this.blogService = blogService;
    }

    @PostMapping("/addComment" )
    public String editComment( @ModelAttribute("comment") Comment comment){
        blogService.addComment(comment);
        return "redirect:/";
    }
}
