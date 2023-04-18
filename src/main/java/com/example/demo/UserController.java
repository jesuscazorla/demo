package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping("/users/error")
    public User funnyUser() {
        return new User("This is not an user", "dontmailme@email.com", "404: Lastname not found");
    }
}
