package com.mjava.security.securityexample.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class UserController {
    
    @GetMapping("/")
    public String index() {
        log.info("Visiting the home page");
        return "Welcome to our home page";

    }

    @GetMapping("/home")
    public String home() {
        return "This is the home page!";
    }

    @GetMapping("/admin")
    public String admin()  {
        return "This is the private page!!!";
    }
}
