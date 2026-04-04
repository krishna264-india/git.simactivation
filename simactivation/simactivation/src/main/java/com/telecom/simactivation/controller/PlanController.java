package com.telecom.simactivation.controller;

import com.telecom.simactivation.entity.Plan;
import com.telecom.simactivation.service.impl.PlanServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {

    private final PlanServiceImpl planService;

    public PlanController(PlanServiceImpl planService) {
        this.planService = planService;
    }

    @GetMapping
    public List<Plan> getPlans(){
        return planService.getPlans();
    }
}
