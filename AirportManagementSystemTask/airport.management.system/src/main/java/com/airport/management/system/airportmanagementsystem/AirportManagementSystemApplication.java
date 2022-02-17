package com.airport.management.system.airportmanagementsystem;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@OpenAPIDefinition
@EnableJpaRepositories("com.airport.management.system.airportmanagementsystem.repositories")
public class AirportManagementSystemApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(AirportManagementSystemApplication.class);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AirportManagementSystemApplication.class);
    }
}

