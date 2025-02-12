package com.nelson_ruiz.screen_time.user;

import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import com.nelson_ruiz.screen_time.user.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final UserRepository userRepository;
    public User createNewUser(String email, String name, String picture) {
        User newUser = new User();
        newUser.setEmail(email);
        newUser.setName(name);
        newUser.setPicture(picture);
        return userRepository.save(newUser);
    }
}
