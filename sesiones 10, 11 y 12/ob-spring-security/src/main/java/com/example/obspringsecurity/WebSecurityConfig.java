package com.example.obspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

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
                .httpBasic();

        return http.build();

    }

    @Bean
    public HttpFirewall looseHttpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);
        firewall.setAllowSemicolon(true);

        return firewall;
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build();
        UserDetails user2= User.withDefaultPasswordEncoder().username("user2").password("password").roles("USER").build();

        return new InMemoryUserDetailsManager(user, user2);

    }

}
