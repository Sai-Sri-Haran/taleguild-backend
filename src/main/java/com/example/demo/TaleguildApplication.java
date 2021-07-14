package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@Configuration
public class TaleguildApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaleguildApplication.class, args);
	}

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/*").allowedMethods("");
    }
	
}

