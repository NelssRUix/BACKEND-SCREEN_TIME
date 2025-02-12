package com.nelson_ruiz.screen_time.security.controller;

import com.nelson_ruiz.screen_time.security.jwt.JwtTokenProvider;
import com.nelson_ruiz.screen_time.security.oauth2.service.AuthService;
import com.nelson_ruiz.screen_time.user.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthService authService;
    private final UserRepository userRepository;

    //endpoint que reciba el idToken, lo valide con Google y genere un JWT.
    @PostMapping("/google")
    public ResponseEntity<?> authenticateWithGoogle(@RequestBody Map<String, String> request) {
        String idToken = request.get("idToken");

        try {
            Map<String, String> tokens = authService.authenticateWithGoogle(idToken);
            return ResponseEntity.ok(tokens);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Google token");
        }
    }


    @PostMapping("/refresh")
    public ResponseEntity<Map<String, String>> refreshToken(@RequestBody Map<String, String> request) {
        String refreshToken = request.get("refreshToken");

        if (refreshToken == null || refreshToken.isBlank()) {
            return ResponseEntity.badRequest().body(Map.of("error", "Refresh token is required"));
        }

        if (!jwtTokenProvider.validateToken(refreshToken)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "Invalid refresh token"));
        }

        String email = jwtTokenProvider.extractEmail(refreshToken);
        return userRepository.findByEmail(email)
                .map(user -> {
                    String newToken = jwtTokenProvider.generateToken(email);
                    return ResponseEntity.ok(Map.of("token", newToken));
                })
                .orElseGet(() -> ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(Map.of("error", "User not found")));
    }


}


