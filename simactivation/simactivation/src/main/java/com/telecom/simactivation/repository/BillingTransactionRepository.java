package com.telecom.simactivation.repository;

import com.telecom.simactivation.entity.BillingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillingTransactionRepository extends JpaRepository<BillingTransaction,Long> {
    List<BillingTransaction> findByMobileNumber (String mobileNumber);
}
