package com.example.securityworkshop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfig {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(autz->
                        autz
                                .requestMatchers("/hello/forAdmin/**").hasRole("ADMIN")
                                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                .requestMatchers("/hello/forUser/**").hasRole("USER")
                                .requestMatchers("/hello/forAll").permitAll()
                                .requestMatchers("/api/login").permitAll()
                .requestMatchers("dummyV2/**").hasRole("ADMIN"))
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    UserDetailsService userDetailsService(){
       UserDetails user1= User.builder()
                .username("Mateusz")
                .password(encoder().encode("pass"))
                .roles("ADMIN")
                .build();
        UserDetails user2= User.builder()
                .username("Monika")
                .password(encoder().encode("pass"))
                .roles("USER")
                .build();
        UserDetails user3=User.builder()
                .username("Gosc")
                .password(encoder().encode("pass"))
                .roles("GUEST")
                .build();
        return new InMemoryUserDetailsManager(user1, user2,user3);
    }

    @Bean
    AuthenticationManager authenticationManager(
            AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
