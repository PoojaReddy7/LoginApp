package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.model.User;
import com.example.repository.UserRepository;

@Controller
public class AuthController {

    @Autowired
    private UserRepository repo;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String signupPage() {
        return "signup";
    }

   @PostMapping("/signup")
    @ResponseBody
    public String signup(@RequestBody User user) { // Changed to @RequestBody
        repo.save(user);
        return "Signup Successful";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody User user) { // Changed to @RequestBody
        User existingUser = repo.findByEmail(user.getEmail());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            return "Login Successful";
        } else {
            return "Invalid Credentials";
        }
    }
}
