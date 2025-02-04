package com.nelson_ruiz.screen_time.common.base;

import com.nelson_ruiz.screen_time.common.enums.StatusEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDate;

    @Enumerated(EnumType.STRING)
    private StatusEntity statusEntity = StatusEntity.ACTIVE;

    @PreUpdate
    public  void preUpdate(){
        updateDate = new Date();
    }

}
