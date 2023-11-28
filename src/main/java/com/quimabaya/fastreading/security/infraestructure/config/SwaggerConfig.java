package com.quimabaya.fastreading.security.infraestructure.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info().title("Fats reading 4.0").version("1.0").description("Sistema de entrenamiento para la lectura"))
            .addSecurityItem(new SecurityRequirement().addList("JWT"))
            .components(
                new Components()
                    .addSecuritySchemes("JWT",
                        new SecurityScheme()
                            .name("JWT")
                            .type(SecurityScheme.Type.HTTP)
                            .scheme("bearer")
                            .bearerFormat("JWT")
                    )
            );
    }
    
    
   
}