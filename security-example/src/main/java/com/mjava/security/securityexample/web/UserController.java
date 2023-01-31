package com.mjava.security.securityexample.web;

import com.mjava.security.securityexample.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import reactor.core.publisher.Flux;


@Log4j2
@RestController
public class UserController {

    private final Flux<UserEntity> users;

    public UserController(Flux<UserEntity> users) {
        this.users = users;
    }

    @GetMapping("/")
    public String index() {
        log.info("Visiting the home page");
        return "Welcome to our home page";

    }

    @GetMapping("/home")
    public String home() {
        return "This is the home page!";
    }

    @GetMapping("/about")
    public String about()  {
        return "This is the private page!!!";
    }

    @GetMapping(produces = MediaType.TEXT_EVENT_STREAM_VALUE, value = "/users")
    Flux<UserEntity> get() {
        return this.users;
    }
}
