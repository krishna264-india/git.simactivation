package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan,String> {

}
