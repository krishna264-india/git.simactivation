package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.RechargeTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeTransactionRepository extends JpaRepository<RechargeTransaction,Long> {

    List<RechargeTransaction> findByMobileNumber (String mobileNumber);
}
