package com.nelson_ruiz.screen_time.user.persistence.repositories;

import com.nelson_ruiz.screen_time.user.persistence.entities.UserSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSettingsRepository extends JpaRepository<UserSettings, Long> {

}
