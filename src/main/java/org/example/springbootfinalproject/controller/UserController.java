package org.example.springbootfinalproject.controller;

import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDetailsService userDetailsService;

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home-page")
    public String homePage() {
        return "home-page";
    }


    @GetMapping("/login")
    public String login(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "form/login-form";
    }


    @GetMapping("/register")
    public String register(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "form/sign-up-form";
    }

    @PostMapping("/register")
    public String registerSava(@ModelAttribute("user") UserDto userDto, Model model) {
        User user = userService.findByEmail(userDto.getUsername());
        if (user != null) {
            model.addAttribute("Userexist", user);
            return "form/sign-up-form";
        }
        userService.save(userDto);
        return "redirect:/register?success";
    }


    @GetMapping("/password-recovery")
    public String passwordResetPage(Model model, UserDto userDto) {
        model.addAttribute("user", userDto);
        return "form/password-recovery-form";
    }


    @GetMapping("/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "list/users-list";
    }


    //    TODO доделать
    @GetMapping("/address")
    public String address(Model model, UserDto userDto) {
//        model.addAttribute("address", );
        return "form/user-address-form";
    }
}
