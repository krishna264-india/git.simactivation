package com.telecom.simactivation.service.impl;

import com.telecom.simactivation.dto.SimActivationRequest;
import com.telecom.simactivation.entity.Customer;
import com.telecom.simactivation.entity.SimInventory;
import com.telecom.simactivation.exception.CustomException;
import com.telecom.simactivation.repository.CustomerRepository;
import com.telecom.simactivation.repository.SimInventoryRepository;
import com.telecom.simactivation.service.SimActivationService;
import org.springframework.stereotype.Service;

@Service
public class SimActivationServiceImpl implements SimActivationService {

    private final CustomerRepository customerRepository;
    private  final SimInventoryRepository simInventoryRepository;

    public SimActivationServiceImpl(CustomerRepository customerRepository, SimInventoryRepository simInventoryRepository) {
        this.customerRepository = customerRepository;
        this.simInventoryRepository = simInventoryRepository;
    }


    @Override
    public String activateSim(SimActivationRequest request) {
        SimInventory sim=simInventoryRepository.findById(request.getSimNumber())
                .orElseThrow(()->new RuntimeException("SIM not found"));

        if(!sim.getStatus().equals("AVAILABLE")){
            throw new CustomException("SIM already used");
        }

        Customer customer=new Customer();
        customer.setName(request.getCustomerName());
        customer.setMobileNumber(request.getMobileNumber());
        customer.setSimNumber(request.getSimNumber());
        customer.setStatus("ACTIVE");

        customerRepository.save(customer);

        sim.setStatus("ALLOCATED");
        simInventoryRepository.save(sim);



        return "SIM activated successfully";
    }
}
