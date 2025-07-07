package com.spriti.Banking_App.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain springSecurityConfiguration(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers("/createAcc").permitAll()
                            .requestMatchers("/getAcc/**", "/accounts").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/deposit", "/withdraw").hasAnyRole("ADMIN", "MEMBER")
                            .anyRequest().authenticated();
                })
                .csrf(csrf -> csrf.disable())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
