package com.nelson_ruiz.screen_time.alert.persistence.repositories;


import com.nelson_ruiz.screen_time.alert.persistence.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends JpaRepository<Notification, Long> {

}


