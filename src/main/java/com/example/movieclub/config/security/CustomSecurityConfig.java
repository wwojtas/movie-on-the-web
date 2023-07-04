package com.example.movieclub.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import static org.springframework.security.config.Customizer.*;

@Service
public class CustomSecurityConfig {
    private static final String USER_ROLE = "USER";
    private static final String EDITOR_ROLE = "EDITOR";
    private static final String ADMIN_ROLE = "ADMIN";

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers("/admin/**").hasAnyRole(EDITOR_ROLE, ADMIN_ROLE)
                .anyRequest().permitAll()
        )
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return web -> web.ignoring().requestMatchers(
                "/img/**",
                "scripts/**",
                "/styles/**"
        );
    }
}