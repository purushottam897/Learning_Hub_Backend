package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// Added missing imports for Spring Security
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF protection
            .authorizeHttpRequests()
                .requestMatchers("/api/**").permitAll() // Allow all API requests without authentication for testing
            .and()
            .httpBasic(); // Enable basic auth for other endpoints

        return http.build();
    }
}
