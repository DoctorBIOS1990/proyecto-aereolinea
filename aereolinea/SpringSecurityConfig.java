package com.springboot.aereolinea;

import org.slf4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.slf4j.LoggerFactory;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    private static final Logger logger = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {

        PasswordEncoder encoder = passwordEncoder();

        UserDetails user = User.builder()
                .passwordEncoder(encoder::encode)
                .username("Supervisor")
                .password("12345")
                .roles("Supervisor")
                .build();

        UserDetails admin = User.builder()
                .passwordEncoder(encoder::encode)
                .username("Administrador")
                .password("12345")
                .roles("Supervisor", "Administrador")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // Authorization configuration
        http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/listar", "/index", "/construccion").permitAll()
                        .requestMatchers("/aereopuerto/listar/**").hasRole("Supervisor")
                        .requestMatchers("/api/v1/**").permitAll()
                        .requestMatchers("/agregar/**").permitAll()

                        // SOLO SUPERVISOR
                        .requestMatchers("/aereopuerto/listar/**").hasRole("Supervisor")
                        .requestMatchers("/tarifa/listar/**").hasRole("Supervisor")
                        .requestMatchers("/reserva/listar/**").hasRole("Supervisor")
                        .requestMatchers("/avion/listar/**").hasRole("Supervisor")
                        .requestMatchers("/vuelo/listar/**").hasRole("Supervisor")
                        .requestMatchers("/tramo/listar/**").hasRole("Supervisor")
                        .requestMatchers("/pasajero/listar/**").hasRole("Supervisor")

                        // SOLO ADMIN
                        .requestMatchers("/avion/listar/**", "/avion/form/**", "/editar/**").hasRole("Administrador").requestMatchers("/vuelo/listar/**", "/vuelo/form/**").hasRole("Administrador")
                        .requestMatchers("/tarifa/form/**", "/tarifa/listar/**").hasRole("Administrador")
                        .requestMatchers("/aereopuerto/form/**", "/aereopuerto/listar/**").hasRole("Administrador")
                        .requestMatchers("/vuelo/listar/**", "/vuelo/form/**").hasRole("Administrador")
                        .requestMatchers("/pasajero/form/**", "/pasajero/listar/**").hasRole("Administrador")
                        .requestMatchers("/reserva/listar/**", "/reserva/form/**").hasRole("Administrador")
                        .requestMatchers("/tramo/listar/**", "/tramo/form/**").hasRole("Administrador")

                        .anyRequest().hasRole("Administrador")
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .defaultSuccessUrl("/index", true)
                        .permitAll()
                )
                .logout(LogoutConfigurer::permitAll);

        return http.build();
    }
}
