package org.example.springbootfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/home-page")
    public String homePage() {
        return "html/home-page";
    }


}
