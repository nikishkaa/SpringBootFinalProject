package org.example.springbootfinalproject.controller;

import org.example.springbootfinalproject.dto.userdto.UserDto;
import org.example.springbootfinalproject.entity.user.User;
import org.example.springbootfinalproject.service.userservice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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


    @GetMapping("/forgot-password")
    public String passwordResetPage() {
        return "form/password-recovery-form";
    }


    @GetMapping("/users")
    public String users(Model model) {
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


    @GetMapping(value = "/delete-user-{email}")
    public String deleteUser(UserDto userDto, Model model) {

//        public String deleteUser(@PathVariable("email") String userEmail /*TODO ДЛЯ ЧЕГО ТУТ ЭТА ПЕРЕМЕННАЯ И ПОЧЕМУ БЕЗ НЕЕ НЕ РАБОТАЕТ!!!!!!!!!!!!!!!!!!!!!! , UserDto userDto, Model model) {

        users(model);
        userService.deleteByEmail(userDto.getEmail());
        return "list/users-list";
    }

    @GetMapping(value = "/update-user-{email}")
    public String updateUser(@PathVariable String email, Model model) {
        User user = userService.findByEmail(email);
        model.addAttribute("user", user);
        model.addAttribute("edit", true);
        return "form/sign-up-form";
    }

    @PostMapping(value = {"/edit-office-{id}"})
    public String updateOffice(@Validated UserDto userDto, BindingResult result,
                               ModelMap model, @PathVariable String email) {
        if (result.hasErrors()) {
            return "form/sign-up-form";
        }
        userService.deleteByEmail(email);

        userService.updateUser(userDto, email);
        model.addAttribute("success", "user " + userDto.getEmail() + " updated successfully");

        return "list/users-list";
    }
}
