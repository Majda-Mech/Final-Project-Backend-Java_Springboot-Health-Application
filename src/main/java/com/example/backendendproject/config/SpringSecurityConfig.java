package com.example.backendendproject.config;

import com.example.backendendproject.Services.CustomUserDetailsService;
import com.example.backendendproject.filter.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
    public final CustomUserDetailsService customUserDetailsService;
    private final JwtRequestFilter jwtRequestFilter;
    private final PasswordEncoder passwordEncoder;

    public SpringSecurityConfig(CustomUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter, PasswordEncoder passwordEncoder) {
        this.customUserDetailsService = customUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(customUserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .build();
    }

    @Bean
    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .httpBasic().disable()
                .cors().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/customers/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/customers/").hasRole("USER")
                .antMatchers(HttpMethod.GET,"/customers/{id}").hasRole("USER")
                .antMatchers(HttpMethod.PUT,"/customers/{id}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE,"/customers/{id}").hasRole("USER")

                .antMatchers(HttpMethod.GET,"/authenticate").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/goals").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/goals").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/goals/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/goals/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/goals/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/recipe").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/recipe").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/recipe/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/recipe/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/recipe/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/users").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}/authorities").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/users/{username}/authorities").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/users/{username}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/users/{username}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/products").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/products/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/products/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/products/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.GET,"/diets").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST,"/diets/{goalId}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET,"/diets/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT,"/diets/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE,"/diets/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/users").permitAll()
                .antMatchers(HttpMethod.GET,"/admin").hasAuthority("ADMIN")
                .antMatchers("/authenticated").authenticated()
                .antMatchers("/authenticate").permitAll()
                .antMatchers("/single/uploadDb/").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.GET,"/customers").hasRole("ADMIN")
                .antMatchers("/**").hasAnyAuthority("ROLE_USER","ADMIN")
                .antMatchers(HttpMethod.GET,"/users/{username}").hasAuthority("ROLE_USER")
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
}

