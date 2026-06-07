package com.qms.platform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
  
@Configuration
public class SwaggerConfig {

	@Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("Platform Service API")
                .description("Queue Management System - Platform Service")
                .version("1.0.0")
                .contact(new Contact()
                    .name("College QMS Team")
                    .email("support@college.edu")))
            .addSecurityItem(new SecurityRequirement().addList("Bearer Auth"))
            .components(new Components()
                .addSecuritySchemes("Bearer Auth", new SecurityScheme()
                    .type(SecurityScheme.Type.HTTP)
                    .scheme("bearer")
                    .bearerFormat("JWT")));
    }
}