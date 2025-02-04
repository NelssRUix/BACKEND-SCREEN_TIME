package com.nelson_ruiz.screen_time.alert.persistence.entities;

import com.nelson_ruiz.screen_time.common.base.BaseEntity;
import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "notifications")
@AllArgsConstructor
@NoArgsConstructor
public class Notification extends BaseEntity {

    private String message;

    private boolean read;

    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}

