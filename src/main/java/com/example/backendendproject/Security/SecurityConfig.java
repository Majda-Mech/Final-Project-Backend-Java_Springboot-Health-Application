package com.example.backendendproject.Security;//package com.example.endprojectsmechapplication.Security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//import javax.servlet.Filter;
//
//
//@Configuration
//class SpringSecurityConfig {
//    public final MyUserDetailsService customUserDetailsService;
//    private final JwtRequestFilter jwtRequestFilter;
//    public SpringSecurityConfig(MyUserDetailsService customUserDetailsService, JwtRequestFilter jwtRequestFilter) {
//        this.customUserDetailsService = customUserDetailsService;
//        this.jwtRequestFilter = jwtRequestFilter;
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .userDetailsService(customUserDetailsService)
//                .passwordEncoder(passwordEncoder())
//                .and()
//                .build();
//    }
//
//    @Bean
//    protected SecurityFilterChain filter (HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .httpBasic().disable()
//                .cors().and()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/users").permitAll()
//                .antMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
//                .antMatchers("/authenticated").authenticated()
//                .antMatchers("/authenticate").permitAll()
//                .antMatchers("/single/uploadDb/").hasAuthority("ADMIN")
//                .antMatchers("/**").hasAnyAuthority("USER", "ADMIN")
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.addFilterBefore((Filter) jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
//        return http.build();
//    }
//}
