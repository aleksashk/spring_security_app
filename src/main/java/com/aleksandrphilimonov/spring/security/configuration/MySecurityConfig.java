package com.aleksandrphilimonov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(UserBuilder.username("aleksandr")
                        .password("aleksandr")
                        .roles("EMPLOYEE"))
                .withUser(UserBuilder.username("andry")
                        .password("andry")
                        .roles("HR"))
                .withUser(UserBuilder.username("zhanna")
                        .password("zhanna")
                        .roles("MANAGER", "HR"));

    }
}
