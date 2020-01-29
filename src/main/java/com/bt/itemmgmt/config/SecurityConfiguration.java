package com.bt.itemmgmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.cors().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .authorizeRequests()
                .antMatchers("/api/v1/admins/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/users/**")
                .hasRole("USER")
                .antMatchers("/api/v1/assets/**")
                .permitAll();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("kiran")
                .password("user")
                .roles("USER")
                .and()
                .withUser("vinay")
                .password("admin")
                .roles("USER", "ADMIN");


    }
}