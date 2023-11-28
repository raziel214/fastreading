package com.quimabaya.fastreading.security.infraestructure.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

	/** @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();

	        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
	        corsConfiguration.setAllowedHeaders(Arrays.asList("*"));

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfiguration);

	        return source;
	    }**/
	
	 @Bean
	    CorsConfigurationSource corsConfigurationSource() {
	        CorsConfiguration corsConfiguration = new CorsConfiguration();

	        corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Orígenes permitidos
	        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Métodos HTTP permitidos
	        corsConfiguration.setAllowedHeaders(Arrays.asList("*")); // Todas las cabeceras permitidas
	        corsConfiguration.setAllowCredentials(true); // Permitir credenciales

	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        source.registerCorsConfiguration("/**", corsConfiguration); // Aplicar la configuración a todas las rutas

	        return source;
	    }
}
