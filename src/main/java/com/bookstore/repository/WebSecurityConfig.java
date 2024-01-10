package com.bookstore.repository;

import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
   @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
            http
                .authorizeHttpRequests((requests) -> requests
                    .requestMatchers("/mylisttechnicians.html").hasRole("ADMIN") 
                    .requestMatchers("/technicians.html").hasRole("USER") 
                    .requestMatchers("/", "/home").hasAnyRole("USER", "ADMIN")
                    .requestMatchers("/signup1", "/signup2").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .successHandler((request, response, authentication) -> {
       
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        
        if (authorities.stream().anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"))) {
           
            response.sendRedirect("/");
        } else {
           
            response.sendRedirect("/book_register");
        }
    })
    .permitAll()
                )
                .logout((logout) -> logout
                    .logoutSuccessUrl("/logout")
                    .permitAll()
					
                );
    
            return http.build();
        }
    
        @Bean
        public UserDetailsService userDetailsService() {
            UserDetails user = User.builder()
                .username("user")
                .password(this.passwordEncoder().encode("123456789"))
                .roles("USER")
                .build();
    
            UserDetails admin = User.builder()
                .username("admin")
                .password(this.passwordEncoder().encode("admin123"))
                .roles("ADMIN")
                .build();
    
            return new InMemoryUserDetailsManager(user, admin);
        }
    
        @Bean
        @Primary
        public BCryptPasswordEncoder passwordEncoder() {
            return new BCryptPasswordEncoder();
        }
}
