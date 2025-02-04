package com.nelson_ruiz.screen_time.usage_info.persistence.repositories;

import com.nelson_ruiz.screen_time.usage_info.persistence.entities.UsageRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageRecordRepository extends JpaRepository<UsageRecord, Long> {

}
