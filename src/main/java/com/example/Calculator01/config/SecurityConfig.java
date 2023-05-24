package com.example.Calculator01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET, "api/{postcode0}").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "api/{postcode1}/{postcode2}").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "api/postcodes").hasRole("ADMIN")
        );

        http.httpBasic();

        http.csrf().disable();

        return http.build();

    }




    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails yansheng = User.builder()
                .username("yansheng")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails sam = User.builder()
                .username("sam")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(yansheng,sam,susan);
    }

    */
}
