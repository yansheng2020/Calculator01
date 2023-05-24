package com.example.Calculator01.config;

import com.example.Calculator01.interceptor.HttpRequestLoggingInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public HttpRequestLoggingInterceptor loggingInterceptor() {
        return new HttpRequestLoggingInterceptor();
    }
}
