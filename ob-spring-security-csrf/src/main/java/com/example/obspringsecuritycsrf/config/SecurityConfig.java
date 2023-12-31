package com.example.obspringsecuritycsrf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    http
    //autotarizacion de urls
            .authorizeRequests()
            .antMatchers("/hola").permitAll()
            .anyRequest().authenticated()
            .and().formLogin()
            .and().formLogin().and()
             .httpBasic();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = passwordEncoder();
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(encoder.encode("password")).roles("USER")
                .and()
                .withUser("admin")
                .password(encoder.encode("password")).roles("USER", "ADMIN");
    }


  @Bean
  public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
  }
}