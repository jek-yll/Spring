package org.example.tp_blog.controler;


import org.example.tp_blog.exception.EmailExistException;
import org.example.tp_blog.model.User;
import org.example.tp_blog.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UserController {


    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(Model model){
        model.addAttribute("user", new User());
        return "blog/registerForm";
    }

    @PostMapping("/register")
    public String addUser(@ModelAttribute("user")User user){
        try {
            userService.addUser(user);
            System.out.println(user.toString());
            System.out.println("bonjour");
            return "redirect:/";
        } catch (EmailExistException e){
            System.out.println(e.getMessage());
            return "redirect:/register";
        }
    }

}
