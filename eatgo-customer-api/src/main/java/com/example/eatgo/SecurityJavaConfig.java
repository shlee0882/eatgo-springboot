package com.example.eatgo;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityJavaConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        // access h2-console, disable formLogin
        http    .cors().disable()
                .csrf().disable()
                .formLogin().disable()
        .headers().frameOptions().disable();

    }
}
