package com.nelson_ruiz.screen_time.security.oauth2.service.implementation;

import com.nelson_ruiz.screen_time.security.oauth2.service.interfaces.OAuth2UserServiceCustom;
import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import com.nelson_ruiz.screen_time.user.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomOAuth2UserService implements OAuth2UserServiceCustom {

    private final UserRepository userRepository;

    @Override
    public OAuth2User processOAuthUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = new DefaultOAuth2UserService().loadUser(userRequest);
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        String picture = oAuth2User.getAttribute("picture");

        User user =  userRepository.findByEmail(email)
                .orElseGet(() -> registerNewUser(email, name, picture));

        return oAuth2User;
    }

    //create new user
    private User registerNewUser(String email, String name, String picture) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPicture(picture);
        return userRepository.save(newUser);
    }
}
