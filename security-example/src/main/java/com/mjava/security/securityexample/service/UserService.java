package com.mjava.security.securityexample.service;

import com.mjava.security.securityexample.entity.UserEntity;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

@Configuration
public class UserService {
    private final String[] names ="master,ertzh,hjuitz,njkiu,dfret,xcdfew,mnhjg,loikut,bnvfde".split(",");
    private final AtomicInteger counter= new AtomicInteger();

    private final Flux<UserEntity> users = Flux.fromStream(
            Stream.generate(() -> {
                var id = counter.incrementAndGet();
                return new UserEntity(id, names[id % names.length]);
            })
    ).delayElements(Duration.ofSeconds(4));

    @Bean
    Flux<UserEntity> userEntityFlux() {
        return this.users.publish().autoConnect();
    }

    public Flux<UserEntity> fluxUsers() {
        return null;
    }
}
