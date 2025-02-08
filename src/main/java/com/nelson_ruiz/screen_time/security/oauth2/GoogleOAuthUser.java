package com.nelson_ruiz.screen_time.security.oauth2;

import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;


public class GoogleOAuthUser implements OAuth2User {
    private final OAuth2User oAuth2User;
    private final User user;

    public GoogleOAuthUser(User user, Map<String, Object> attributes) {
        this.user = user;
        this.oAuth2User = new DefaultOAuth2User(List.of(new SimpleGrantedAuthority("ROLE_USER")),attributes,"email");
    }

    @Override
    public Map<String, Object> getAttributes() {
        return oAuth2User.getAttributes();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getName() {
        return user.getEmail();
    }
}
