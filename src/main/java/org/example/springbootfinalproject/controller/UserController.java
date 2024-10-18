package org.example.springbootfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/home-page")
    public String homePage() {
        return "home-page";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "form/login-form";
    }

    @GetMapping("/register")
    public String registerPage() {
        return "form/sign-up-form";
    }

    @GetMapping("/password-recovery")
    public String passwordResetPage() {
        return "form/password-recovery-form";
    }
}
