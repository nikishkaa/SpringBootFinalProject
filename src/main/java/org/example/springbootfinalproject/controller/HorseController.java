package org.example.springbootfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HorseController {
    @GetMapping("/add-horse")
    public String addNewStablePage() {
        return "form/horse-add-form";
    }
}
