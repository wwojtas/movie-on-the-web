package com.example.movieclub.domain.web.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {


    @GetMapping("/admin")
    public String getAdminPanel(){
        return "admin/admin";
    }
}
