package com.example.ejerciciosSesiones10_11_12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests()
                // Cada una de estas lineas son las rutas permitidas sin autenticar
                .requestMatchers("/hola")
                //
                .permitAll()
                .requestMatchers("/**")
                // Normalmente se especifican los roles mediante hasRole
                .hasRole("USER")
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and().csrf().disable();

        return http.build();
    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService(BCryptPasswordEncoder passwordEncoder) {
        // La forma obsoleta y insegura en la cuál se usa la codificación por defecto
//        UserDetails user1 = User.withDefaultPasswordEncoder().username("user1").password("password").roles("USER").build();
//        UserDetails user2 = User.withDefaultPasswordEncoder().username("user2").password("password").roles("USER").build();
//        return new InMemoryUserDetailsManager(user1, user2);

        UserDetails user1 = User.withUsername("user1")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();
        UserDetails user2 = User.withUsername("user2")
                .password(passwordEncoder.encode("password"))
                .roles("USER")
                .build();


        return new InMemoryUserDetailsManager(user1, user2);

    }
}
