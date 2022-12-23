package com.mjava.security.securityexample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
    

    @Bean
    SecurityFilterChain dFilterChain(HttpSecurity http) throws Exception {
        return http
                    // autenticated
                    .authorizeHttpRequests(authConfig -> {
                        authConfig.requestMatchers("/admin").authenticated();
                        authConfig.anyRequest().permitAll();
                    })
                    // user fornLogin
                    .formLogin(withDefaults())
                    .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails myUser = User.builder()
                            .username("user")
                            .password("{noop}password")
                            .authorities("ROLE_USER")
                            .build();
        return new InMemoryUserDetailsManager(myUser);
    }


}
