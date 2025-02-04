package com.nelson_ruiz.screen_time.user.persistence.entities;

import com.nelson_ruiz.screen_time.common.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_settings")
@AllArgsConstructor
@NoArgsConstructor
public class UserSettings extends BaseEntity {

    private int dailyScreenTimeLimit;  // Límite de uso diario en minutos

    private boolean notificationsEnabled;  // Activar o desactivar alertas

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
