package com.mjava.security.securityexample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    

    @GetMapping("/home")
    public String home() {
        return "This is the home page!";
    }

    @GetMapping("/admin")
    public String admin()  {
        return "This is the private page!!!";
    }
}
