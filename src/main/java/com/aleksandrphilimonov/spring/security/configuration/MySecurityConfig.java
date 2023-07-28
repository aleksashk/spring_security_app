package com.aleksandrphilimonov.spring.security.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .hasAnyRole("EMPLOYEE", "HR", "MANAGER")
                .antMatchers("/hr_info")
                .hasRole("HR")
                .antMatchers("/manager")
                .hasRole("MANAGER")
                .and().formLogin().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(userBuilder.username("aleksandr")
                        .password("aleksandr")
                        .roles("EMPLOYEE"))
                .withUser(userBuilder.username("andry")
                        .password("andry")
                        .roles("HR"))
                .withUser(userBuilder.username("zhanna")
                        .password("zhanna")
                        .roles("MANAGER", "HR"));

    }
}
