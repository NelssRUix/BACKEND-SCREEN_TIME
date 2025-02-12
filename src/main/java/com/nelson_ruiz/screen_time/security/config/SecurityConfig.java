package com.nelson_ruiz.screen_time.security.config;



import com.nelson_ruiz.screen_time.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    //private final CustomOAuth2UserService oAuth2UserService;    uso para web
    private final JwtTokenProvider jwtTokenProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/","/auth/refresh","auth/google").permitAll()
                        .anyRequest().authenticated()
                );


        //Basado en OAuth2 Login Web.
//                .oauth2Login(oauth-> oauth
//                        .userInfoEndpoint(userInfo ->userInfo.userService(oAuth2UserService))
//                        .successHandler(((request, response, authentication) -> {
//
//                            OAuth2User user = (OAuth2User) authentication.getPrincipal();
//                            String token = jwtTokenProvider.generateToken(user.getAttribute("email"));
//                            String refreshToken = jwtTokenProvider.generateRefreshToken(user.getAttribute("email"));
//
//                            response.setContentType("application/json");
//                            response.getWriter().write(String.format("{\"token\":\"%s\", \"refreshToken\":\"%s\"}", token, refreshToken));
//
//
//                        }))
//                );
        return http.build();
    }
}
