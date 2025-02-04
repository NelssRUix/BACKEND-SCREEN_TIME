package com.nelson_ruiz.screen_time.usage_info.persistence.repositories;

import com.nelson_ruiz.screen_time.usage_info.persistence.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

}

