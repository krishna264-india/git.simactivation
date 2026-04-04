package com.telecom.simactivation.service.impl;

import com.telecom.simactivation.entity.Balance;
import com.telecom.simactivation.exception.CustomException;
import com.telecom.simactivation.repository.BalanceRepository;
import com.telecom.simactivation.service.BalanceService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceServiceImpl(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }
//Instead of hitting DB every time instead using redis for fast
    @Override
    @Cacheable(value = "balanceCache", key = "#mobileNumber")
    public double getBalance(String mobileNumber){

        System.out.println("Fetching from DB...");

        Balance balance=balanceRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(()-> new CustomException("Balance not found"));

        return balance.getBalanceAmount();
    }

}
