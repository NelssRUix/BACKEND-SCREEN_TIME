package com.nelson_ruiz.screen_time.security.oauth2.service.interfaces;

import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;

public interface OAuth2UserServiceCustom {
    OAuth2User processOAuthUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException;
}
