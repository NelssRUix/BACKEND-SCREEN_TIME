package com.nelson_ruiz.screen_time.user.persistence.entities;

import com.nelson_ruiz.screen_time.common.base.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
