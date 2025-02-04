package com.nelson_ruiz.screen_time.user.persistence.entities;

import com.nelson_ruiz.screen_time.common.base.BaseEntity;
import com.nelson_ruiz.screen_time.usage_info.persistence.entities.UsageRecord;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {

    private String email;

    private String name;

    private String picture;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UsageRecord> usageRecords;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSettings settings;

}
