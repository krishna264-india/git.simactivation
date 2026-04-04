package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.ProcessedEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedEventRepository extends JpaRepository<ProcessedEvent,String> {



}
