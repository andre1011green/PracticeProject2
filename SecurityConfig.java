package com.Practice.PracticeProject.SecurityConfiguation;

import com.Practice.PracticeProject.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig
{
    @Autowired
    CustomUserDetailsService customUserDetailsService;

    @Lazy
    public PasswordEncoder getPasswordEncoder()
    {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http.csrf((csrf) -> csrf.disable());
        http
                .authorizeHttpRequests(authorize -> authorize

                        .requestMatchers( "/", "/index", "/error").permitAll()
                        .requestMatchers("/CSS/**").permitAll()
                        .requestMatchers("/IMAGES/**").permitAll()
                        .requestMatchers("/JAVASCRIPT/**").permitAll()
                        .requestMatchers("/home").hasRole("EMPLOYEE")
                        .anyRequest().authenticated()
                )
                .formLogin(formLogin ->
                        formLogin

                                .loginPage("/index.html").permitAll()
                                .loginProcessingUrl("/index.html").permitAll()
                                .defaultSuccessUrl("/home", true)
                                .failureUrl("/login?error=true").permitAll()
                );


        return http.build();

    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(getPasswordEncoder());
    }
}
