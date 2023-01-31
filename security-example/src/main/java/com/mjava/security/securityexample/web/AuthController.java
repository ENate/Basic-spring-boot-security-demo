package com.mjava.security.securityexample.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController("auth")
public class AuthController {

    @GetMapping("/admin")
    public String admin(@PathVariable String name) {
        return "Hello: " + name + ". This is the way!";
    }
    
}
