package com.selva.Course_Reg_System.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(customizer -> customizer.disable())
        .authorizeHttpRequests(request -> request
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/user/**").hasAnyRole("ADMIN","USER")
                .requestMatchers("/public/**").permitAll()
                .anyRequest().authenticated())
//        .formLogin(Customizer.withDefaults())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }


//    @Bean
//    public UserDetailsService userDetailsService(){
//        List<UserDetails> users = new ArrayList<>();
//
//        UserDetails u1 = User
//                .withDefaultPasswordEncoder()
//                .username("sam")
//                .password("1111")
//                .roles("USER")
//                .build();
//
//        UserDetails u2 = User
//                .withDefaultPasswordEncoder()
//                .username("ajay")
//                .password("qqq")
//                .roles("USER")
//                .build();
//
//        UserDetails u3 = User
//                .withDefaultPasswordEncoder()
//                .username("asal")
//                .password("qwe")
//                .roles("USER")
//                .build();
//
//        users.add(u1);
//        users.add(u2);
//        users.add(u3);
//
////        return new InMemoryUserDetailsManager(users);
//        return new InMemoryUserDetailsManager(u1,u2,u3);
//    }
}
