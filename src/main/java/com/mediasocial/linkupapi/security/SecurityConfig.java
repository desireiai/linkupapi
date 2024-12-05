package com.mediasocial.linkupapi.security;

import com.mediasocial.linkupapi.services.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Value("${api.key.header:X-API-KEY}")
    private String principalRequestHeader;

    @Value("${api.key.value:your-api-key-here}")
    private String principalRequestValue;

    @Autowired
    @Lazy
    private CustomUserDetailsService userDetailsService;

 

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Filtre pour l'API Key
        ApiKeyAuthFilter apiKeyFilter = new ApiKeyAuthFilter(principalRequestHeader);
        apiKeyFilter.setAuthenticationManager(new ApiKeyAuthManager(principalRequestValue));

        http.csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/login").permitAll() // Autorise l'accès public à la route de connexion
                .requestMatchers("/api/utilisateurs/**").authenticated() // Nécessite une authentification via API Key
                .anyRequest().authenticated()) 
                .addFilterBefore(apiKeyFilter, UsernamePasswordAuthenticationFilter.class); // Ajout du filtre API Key 
                return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
