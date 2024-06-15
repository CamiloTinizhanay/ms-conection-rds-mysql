package com.app.msconectionrdsmysql.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.apache.catalina.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("User API")
                        .version("1.0")
                        .description("API for managing users")
                        .termsOfService("http://grupo6.com/terms/")
                        .contact(new Contact()
                                .name("Support Team")
                                .url("http://grupo6.com/contact")
                                .email("grupo6@tecazuay.edu.ec"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")))
                .servers(
                        Arrays.asList(
                                new io.swagger.v3.oas.models.servers.Server().url("http://localhost:8080"),
                                new io.swagger.v3.oas.models.servers.Server().url("http://env-prod:8081")
                ));
    }

    @Bean
    public GroupedOpenApi userApi() {
        return GroupedOpenApi.builder()
                .group("users")
                .pathsToMatch("/api/v1/user/**")
                .build();
    }
}
