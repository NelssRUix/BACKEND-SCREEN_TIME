package com.nelson_ruiz.screen_time.security.oauth2.service;

import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.nelson_ruiz.screen_time.security.jwt.JwtTokenProvider;
import com.nelson_ruiz.screen_time.user.UserFactory;
import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import com.nelson_ruiz.screen_time.user.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final JwtTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;
    private final UserFactory userFactory;
    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String googleClientId;

    public Map<String, String> authenticateWithGoogle(String idToken) throws Exception {
        GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
                new NetHttpTransport(),
                JacksonFactory.getDefaultInstance())
                .setAudience(Collections.singletonList(googleClientId))
                .build();

        GoogleIdToken googleIdToken = verifier.verify(idToken);
        if (googleIdToken != null) {
            GoogleIdToken.Payload payload = googleIdToken.getPayload();
            String email = payload.getEmail();
            String name = (String) payload.get("name");
            String picture = (String) payload.get("picture");

            // 🔹 Buscar si el usuario ya existe o registrarlo
            User user = userRepository.findByEmail(email)
                    .orElseGet(() -> userFactory.createNewUser(email, name, picture));

            // Generar JWT y Refresh Token
            String token = jwtTokenProvider.generateToken(user.getEmail());
            String refreshToken = jwtTokenProvider.generateRefreshToken(user.getEmail());

            return Map.of("token", token, "refreshToken", refreshToken);
        } else {
            throw new Exception("Invalid Google token");
        }
    }
}