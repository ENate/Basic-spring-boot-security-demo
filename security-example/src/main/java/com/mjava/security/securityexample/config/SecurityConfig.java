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
                    // authenticated
                    .authorizeHttpRequests(authConfig -> {
                        authConfig.requestMatchers("/").permitAll();
                        authConfig.requestMatchers("/error").permitAll();
                        authConfig.requestMatchers("/favicon.ico").permitAll();
                        authConfig.anyRequest().authenticated();
                    })
                    // user formLogin
                    .formLogin(withDefaults())
                    // .oauth2ResourceServer(spec -> spec.jwt(Customizer.withDefaults()))
                    .build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails myUser = User.builder()
                            .username("nath")
                            .password("{noop}password")
                            .authorities("ROLE_USER")
                            .build();
        return new InMemoryUserDetailsManager(myUser);
    }


}
