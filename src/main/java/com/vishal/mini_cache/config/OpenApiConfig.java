package com.vishal.mini_cache.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI cacheOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Mini Cache Engine")
                                .version("1.0")
                                .description(
                                        "Custom Cache Implementation with TTL, Statistics and Cleanup Support"
                                )
                                .contact(
                                        new Contact()
                                                .name("Vishal Vana")
                                                .email("vishalvana592003@gmail.com")
                                )
                );
    }
}