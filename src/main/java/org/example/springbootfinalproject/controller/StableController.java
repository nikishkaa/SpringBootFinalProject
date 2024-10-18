package org.example.springbootfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StableController {
    @GetMapping("/new-stable")
    public String addNewStablePage() {
        return "form/stable-creation-form";
    }
}
