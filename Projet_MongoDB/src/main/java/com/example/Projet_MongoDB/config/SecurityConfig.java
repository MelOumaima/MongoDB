package com.example.Projet_MongoDB.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // Définir un utilisateur en mémoire
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withUsername("admin")
                        .password("password")
                        .roles("USER")
                        .build()
        );
        return manager;
    }

    // PasswordEncoder (NoOp pour test uniquement)
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    // Configuration de la sécurité avec la nouvelle API
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactiver CSRF pour une API REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/encadrants").permitAll() // accès public
                        .anyRequest().authenticated() // tout le reste nécessite auth
                )
                .httpBasic(Customizer.withDefaults()); // Utiliser Basic Auth

        return http.build();
    }
}