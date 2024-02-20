package org.example.exo_session.controller;

import jakarta.servlet.http.HttpSession;
import org.example.exo_session.model.User;
import org.example.exo_session.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    private final LoginService loginService;
    @Autowired
    private HttpSession _httpSession;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/login")
    private String loginForm(Model model){
        model.addAttribute("user", new User());
        return "loginForm";
    }

    @PostMapping("/login")
    private String login(@ModelAttribute("user")User user, Model model){

        User userLog = User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();

        User userTest = loginService.getUser();

        if (userLog.getUsername().equals(userTest.getUsername()) && userLog.getPassword().equals(userTest.getPassword())){
            _httpSession.setAttribute("login", "ok");
            System.out.println(_httpSession.getAttribute("login"));
            return "redirect:/securePage";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/securePage")
    private String securePage() {
        if (_httpSession.getAttribute("login").toString().equals("ok")){
            return "securePage";
        } else {
            return "redirect:/";
        }
    }

    @GetMapping("/disconnect")
    private String disconnect(){
        _httpSession.removeAttribute("login");
        return "redirect:/";
    }
}
