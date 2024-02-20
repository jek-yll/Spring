package org.example.tp_blog.controler;


import org.example.tp_blog.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "blog/registerForm";
    }

}
