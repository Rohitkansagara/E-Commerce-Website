package com.a99.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    // Creating a SecurityFilterChain bean for Spring Security 6.x
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Disable CSRF protection. Ensure that this is appropriate for your application.
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.GET, "/api/products/**", "/api/categories/**").permitAll() // Public access to products and categories
                        .requestMatchers(HttpMethod.POST, "/api/auth/register", "/api/auth/login").permitAll() // Public access to auth endpoints
                        .requestMatchers(HttpMethod.POST, "/api/orders/**").authenticated() // Only authenticated users can place orders
                        .requestMatchers(HttpMethod.POST, "/api/products/**", "/api/categories/**").hasRole("ADMIN") // Only admin can access product/category management
                        .anyRequest().authenticated() // Any other request needs authentication
                )
                .httpBasic(Customizer.withDefaults()); // Use HTTP Basic Authentication (can be replaced with JWT or OAuth2 based on your setup)

        return http.build();
    }

    // PasswordEncoder Bean to handle password encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // Custom UserDetailsService for in-memory users (replace with database logic for production)
    @Bean
    public UserDetailsService userDetailsService() {
        return username -> User.builder()
                .username(username)
                .password(passwordEncoder().encode("password")) // Example password, encode it properly in production
                .roles("USER") // Assigning the "USER" role by default, adjust according to your needs
                .build();
    }
}
