package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.SimInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SimInventoryRepository extends JpaRepository<SimInventory,String> {

    Optional<SimInventory> findByStatus (String status);
}
