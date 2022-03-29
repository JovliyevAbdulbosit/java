package com.payment.test.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfigur extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private  final JwtTokenProvayder jwtTokenProvayder;

    public JwtConfigur(JwtTokenProvayder jwtTokenProvayder) {
        this.jwtTokenProvayder = jwtTokenProvayder;
    }
    @Override
    public void configure(HttpSecurity httpSecurity){
        JwtFilter jwtFilter =new JwtFilter(jwtTokenProvayder);
        httpSecurity.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
