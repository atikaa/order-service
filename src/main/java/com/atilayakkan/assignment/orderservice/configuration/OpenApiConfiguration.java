package com.atilayakkan.assignment.orderservice.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI getOpenApi(@Value("${application.description}") String description,
                              @Value("${application.version}") String version,
                              @Value("${application.title}") String title,
                              @Value("${application.contact}") String contactName,
                              @Value("${application.email}") String email,
                              @Value("${application.license}") String licenseName) {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title(title)
                        .description(description)
                        .version(version)
                        .contact(new Contact()
                                .name(contactName)
                                .email(email))
                        .license(new License()
                                .name(licenseName)));
    }
}
