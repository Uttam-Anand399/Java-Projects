package com.ay.config;

import com.ay.security.JwtRequestFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;


@Configuration
public class SecurityConfig {
	  private final JwtRequestFilter jwtRequestFilter;

	    // ✅ Constructor injection of JwtRequestFilter
	    public SecurityConfig(JwtRequestFilter jwtRequestFilter) {
	        this.jwtRequestFilter = jwtRequestFilter;
	    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);  // Allow credentials (cookies, authorization headers, etc.)
        config.setAllowedOrigins(Arrays.asList("http://localhost:5173")); // Frontend React URL
        config.setAllowedHeaders(Arrays.asList("*")); // Allow all headers
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allowed HTTP methods

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);  // Allow CORS for all paths
        return source;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for now
            .cors(cors -> {})  // Enable CORS
            .authorizeHttpRequests(auth -> auth
                .requestMatchers( "/login","/register","/api/crops/**","/api/soils/**","/api/bookings/**","/api/products/**","/api/orders/**","/api/expert-consultations/**","/api/trainings/**","/api/languages/**","/api/helpline/**","/api/resources/**","/ws/**","/topic/**","/app/**").permitAll()  // Allow login/register routes and crop endpoints
                .anyRequest().authenticated() // Require authentication for other requests
            )
            .sessionManagement(sess -> sess
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);  // JWT filter
        return http.build();
    }

}
