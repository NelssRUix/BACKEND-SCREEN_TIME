package com.nelson_ruiz.screen_time.usage_info.persistence.repositories;

import com.nelson_ruiz.screen_time.usage_info.persistence.entities.UsageGoal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsageGoalRepository extends JpaRepository<UsageGoal, Long> {

}


