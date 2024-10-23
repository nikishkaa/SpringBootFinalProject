package org.example.springbootfinalproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnnouncementController {
    @GetMapping("/announcement")
    public String addNewStablePage() {
        return "form/announcement-add-form";
    }
}
