package com.rastadrian.spring.sample;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@SpringBootApplication
public class SpringSecSampleApplication {

    @Bean
    public Map<String, UserDetails> users() {
        return new HashMap<>();
    }

    @Bean
    public CommandLineRunner run(AuthenticationConfiguration authenticationConfiguration) {
        return (args) -> {
            ProviderManager providerManager = (ProviderManager) authenticationConfiguration.getAuthenticationManager();
            DaoAuthenticationProvider provider = (DaoAuthenticationProvider) providerManager.getProviders().get(0);
            log.warn("Provider's UserCache is a 'MyUserCache': {}", provider.getUserCache() instanceof MyUserCache);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecSampleApplication.class, args);
    }

}
