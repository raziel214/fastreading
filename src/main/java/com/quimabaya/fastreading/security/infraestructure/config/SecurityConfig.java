package com.quimabaya.fastreading.security.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.quimabaya.fastreading.security.aplication.service.JwtUtil;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
	
	 private final JwtFilter jwtFilter;
	 private final JwtUtil jwtUtil;
	 private final UserDetailsService userDetailsService;
	 private final CorsConfigurationSource corsConfigurationSource;
	 
	 @Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		 http
	        .csrf().disable()
	        .cors().and() // Esto habilitará la configuración CORS global definida en CorsConfig
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	        .authorizeHttpRequests()
	        .requestMatchers("/public/**", "/api/auth/login", "/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/index.html", "/webjars/**").permitAll()
	        .requestMatchers("/api/customers/**").hasAnyRole("1", "0")
	        .requestMatchers(HttpMethod.GET, "/api/pizzas/**").hasAnyRole("1", "0")
	        .requestMatchers(HttpMethod.POST, "/api/pizzas/**").hasRole("1")
	        .requestMatchers(HttpMethod.PUT).hasRole("1")
	        .requestMatchers("/api/orders/random").hasAuthority("random_order")
	        .requestMatchers("/api/orders/**").hasRole("1")
	        .anyRequest().authenticated()
	        .and()
	        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

	    return http.build();

	    }
	 
	 @Bean
	    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
	        return configuration.getAuthenticationManager();
	    }

	    @Bean
	    public PasswordEncoder passwordEncoder() {
	        return new BCryptPasswordEncoder();
	    }
	    
	    @Bean
	    public JwtFilter jwtTokenFilter() {
	        return new JwtFilter(jwtUtil,userDetailsService);
	    }
	

}
