package com.telecom.simactivation.service.impl;

import com.telecom.simactivation.entity.Plan;
import com.telecom.simactivation.repository.PlanRepository;
import com.telecom.simactivation.service.PlanService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {

    private final PlanRepository planRepository;

    public PlanServiceImpl(PlanRepository planRepository) {

        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> getPlans(){

        return planRepository.findAll();
    }
}
