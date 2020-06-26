package com.company.dnevnik.controllers;
import com.company.dnevnik.entities.User;
import com.company.dnevnik.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/{userId}")
    public String getSaveUser(Model model, @PathVariable(value = "userId", required = false) Long userId){
        model.addAttribute("user", userId == null ? new User() : userService.getUserById(userId));
        return "user/userSaving";
    }
    @GetMapping("/new")
    public String getSaveNewUser(Model model){
        model.addAttribute("user", new User());
        return "user/userSaving";
    }
    @PostMapping
    public String saveNewUser(@ModelAttribute User user){
        userService.saveUser(user);
        return "redirect:/users/usersList";
    }
    @GetMapping("/usersList")
    public String getAllUsers(Model model){
        model.addAttribute("allUsers", userService.getAllUsers());
        return "user/usersList";
    }
    @GetMapping("/delete/{userId}")
    public String deleteUser(@PathVariable("userId") Long userId){
        userService.deleteUserById(userId);
        return "redirect:/user/usersList";
    }
}