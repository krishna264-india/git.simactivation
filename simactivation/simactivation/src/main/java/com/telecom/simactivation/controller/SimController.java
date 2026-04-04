package com.telecom.simactivation.controller;

import com.telecom.simactivation.dto.SimActivationRequest;
import com.telecom.simactivation.service.impl.SimActivationServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sim")
public class SimController {

    private final SimActivationServiceImpl simService;


    public SimController(SimActivationServiceImpl simService) {
        this.simService = simService;
    }

    @PostMapping("/activate")
    public String activateSim(@RequestBody SimActivationRequest request){

        return simService.activateSim(request);
    }

}
