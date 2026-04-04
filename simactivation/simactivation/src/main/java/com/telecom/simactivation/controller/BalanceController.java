package com.telecom.simactivation.controller;

import com.telecom.simactivation.service.BalanceService;
import com.telecom.simactivation.service.impl.BalanceServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService balanceService;

    public BalanceController(BalanceServiceImpl balanceService, BalanceService balanceService1) {
        this.balanceService = balanceService1;
    }

    @GetMapping("/{mobileNumber}")
    public double getBalance(@PathVariable String mobileNumber){
        return balanceService.getBalance(mobileNumber);
    }
}
