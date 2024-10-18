package org.example.springbootfinalproject.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth ->
                auth.requestMatchers("/register").permitAll().requestMatchers("home")
                        .permitAll().requestMatchers("users").permitAll().requestMatchers("home-page")
                        .permitAll().requestMatchers("password-recovery").permitAll()
                        .requestMatchers("new-stable").permitAll()
                        .requestMatchers("add-horse").permitAll() //TODO role
                        .requestMatchers("/css/**").permitAll().requestMatchers("/js/**").permitAll().requestMatchers("/img/**").permitAll());

        // LOGIN
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login").loginProcessingUrl("/login").defaultSuccessUrl("/home", true)
                        .permitAll());
        // LOGOUT
        http.logout(logout ->
                logout.invalidateHttpSession(true).clearAuthentication(true)
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout").permitAll());
        return http.build();
    }


}
