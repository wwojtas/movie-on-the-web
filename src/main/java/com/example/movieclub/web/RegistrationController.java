package com.example.movieclub.web;

import com.example.movieclub.domain.user.UserService;
import com.example.movieclub.domain.user.dto.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/rejestracja")
    public String registrationForm(Model model) {
        UserRegistrationDto userRegistration = new UserRegistrationDto();
        model.addAttribute("user", userRegistration);
        return "registration-form";
    }

    @PostMapping("/rejestracja")
    public String register(UserRegistrationDto userRegistration){
        userService.registerUserWithDefaultRole(userRegistration);
        return "redirect:/";
    }
}
