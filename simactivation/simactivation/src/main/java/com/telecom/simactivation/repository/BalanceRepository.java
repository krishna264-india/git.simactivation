package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance,String> {

    Optional<Balance> findByMobileNumber(String mobileNumber);
}
