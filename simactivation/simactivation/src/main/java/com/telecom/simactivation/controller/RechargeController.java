package com.telecom.simactivation.controller;

import com.telecom.simactivation.dto.ApiResponse;
import com.telecom.simactivation.dto.RechargeRequest;
import com.telecom.simactivation.service.impl.RechargeServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recharge")
public class RechargeController {

    private final RechargeServiceImpl rechargeService;

    public RechargeController(RechargeServiceImpl rechargeService) {
        this.rechargeService = rechargeService;
    }
    @PostMapping("/recharges")
    public ApiResponse recharge(@RequestBody RechargeRequest request){
        String result=rechargeService.recharge(request);

        return new ApiResponse(result,"Balance not found");
    }

}
