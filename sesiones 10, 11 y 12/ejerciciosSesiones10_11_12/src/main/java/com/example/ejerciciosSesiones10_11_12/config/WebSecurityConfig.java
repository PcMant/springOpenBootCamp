package com.example.ejerciciosSesiones10_11_12.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

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
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder().username("user1").password("password").roles("USER").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("user2").password("password").roles("USER").build();

        return new InMemoryUserDetailsManager(user1, user2);
    }
}
