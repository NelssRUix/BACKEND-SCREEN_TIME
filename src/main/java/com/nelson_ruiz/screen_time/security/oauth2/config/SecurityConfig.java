package com.nelson_ruiz.screen_time.security.oauth2.config;


import com.nelson_ruiz.screen_time.security.oauth2.service.interfaces.OAuth2UserServiceCustom;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, OAuth2UserServiceCustom oAuth2UserServiceCustom) throws Exception {

        return httpSecurity
                .cors(withDefaults())
                .authorizeHttpRequests(request -> {
                    request.requestMatchers(HttpMethod.GET, "/", "/user/login").permitAll();
                    request.anyRequest().authenticated();
                })
                .oauth2Login(oauth2 -> oauth2
                        .userInfoEndpoint(userInfo -> userInfo
                                .userService(userRequest -> oAuth2UserServiceCustom.processOAuthUser(userRequest))))
                .build();
    }
}
