package com.bt.itemmgmt.config;

import com.bt.itemmgmt.service.DomainUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DomainUserDetailsService domainUserDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable();
        httpSecurity.cors().disable();
        httpSecurity.headers().frameOptions().disable();

        httpSecurity
                .authorizeRequests()
                .antMatchers("/api/v1/users/**")
                .hasAnyRole("USER", "ADMIN")
                .antMatchers("/api/v1/admins/**")
                .hasRole("ADMIN")
                .antMatchers("/api/v1/assets/**")
                .permitAll()
                .and()
                .httpBasic();


    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        /*authenticationManagerBuilder
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())
                .withUser("kiran")
                .password(passwordEncoder().encode("user"))
                .roles("USER")
                .and()
                .withUser("vinay")
                .password(passwordEncoder().encode("admin"))
                .roles("USER", "ADMIN");*/

        authenticationManagerBuilder
                .userDetailsService(this.domainUserDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
       // return NoOpPasswordEncoder.getInstance();
        return new BCryptPasswordEncoder();
    }
}