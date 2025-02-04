package com.nelson_ruiz.screen_time.usage_info.persistence.entities;


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

@Entity
@Getter
@Setter
@Table(name = "usage_goals")
@AllArgsConstructor
@NoArgsConstructor
public class UsageGoal extends BaseEntity {

    private String appName;

    private int dailyLimitMinutes;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
