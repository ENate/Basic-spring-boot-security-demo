package com.mjava.security.securityexample.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mjava.security.securityexample.entity.UserEntity;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import reactor.core.publisher.Flux;

import java.util.Map;

@Configuration
public class WebSocReactiveEndpt {
    private final ObjectMapper objectMapper;

    public WebSocReactiveEndpt(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @SneakyThrows
    private String from(UserEntity userEntity) {
        return this.objectMapper.writeValueAsString(userEntity);
    }

    @Bean
    WebSocketHandler webSocketHandler(Flux<UserEntity> userEntityFlux) {
        return session ->  {

                Flux<WebSocketMessage> map = userEntityFlux
                        .map(this::from)
                        .map(session::textMessage);
                return session.send(map);

        };
    }
    @Bean
    SimpleUrlHandlerMapping simpleUrlHandlerMapping(WebSocketHandler webSocketHandler) {
        return new SimpleUrlHandlerMapping(Map.of("/usr/users", webSocketHandler), 10);
    }
}
