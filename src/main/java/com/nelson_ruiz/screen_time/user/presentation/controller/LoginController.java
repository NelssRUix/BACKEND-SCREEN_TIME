package com.nelson_ruiz.screen_time.user.presentation.controller;

import com.nelson_ruiz.screen_time.security.oauth2.service.interfaces.OAuth2UserServiceCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class LoginController {

    private final OAuth2UserServiceCustom oAuth2UserServiceCustom;

    @GetMapping("/login")
    public OAuth2User login(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        return oAuth2UserServiceCustom.processOAuthUser(userRequest);
    }
}
