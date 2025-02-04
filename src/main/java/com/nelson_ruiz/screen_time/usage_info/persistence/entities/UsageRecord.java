package com.nelson_ruiz.screen_time.usage_info.persistence.entities;

import com.nelson_ruiz.screen_time.common.base.BaseEntity;
import com.nelson_ruiz.screen_time.user.persistence.entities.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "usage_records")
@AllArgsConstructor
@NoArgsConstructor
public class UsageRecord extends BaseEntity {

    private String appName;

    private String category;

    private int durationMinutes;  // Minutos de uso

    private LocalDateTime dateTime;  // Fecha del registro

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
