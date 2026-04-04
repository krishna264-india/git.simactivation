package com.telecom.simactivation.service.impl;

import com.telecom.simactivation.dto.RechargeRequest;
import com.telecom.simactivation.entity.RechargeTransaction;
import com.telecom.simactivation.events.RechargeEvents;
import com.telecom.simactivation.kafka.RechargeEventProducer;
import com.telecom.simactivation.repository.RechargeTransactionRepository;
import com.telecom.simactivation.service.RechargeService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RechargeServiceImpl implements RechargeService {

    private final RechargeTransactionRepository rechargeRepository;
    private final RechargeEventProducer rechargeEventProducer;

    public RechargeServiceImpl(RechargeTransactionRepository rechargeRepository, RechargeEventProducer rechargeEventProducer) {
        this.rechargeRepository = rechargeRepository;
        this.rechargeEventProducer = rechargeEventProducer;
    }
    private static final Logger log =
            LoggerFactory.getLogger(RechargeServiceImpl.class);

    @Override
    @CacheEvict(value = "balanceCache",key = "#request.mobileNumber")
    @CircuitBreaker(name = "rechargeService" ,fallbackMethod = "rechargeService")
    public String recharge(RechargeRequest request){
        log.info("Recharge started for mobile: {}", request.getMobileNumber());
        // business logic
        log.info("Recharge successful for mobile: {}",request.getMobileNumber());
        RechargeTransaction tx= new RechargeTransaction();

        // simulate external call
        if (request.getAmount() > 1000) {
            throw new RuntimeException("External service failure");
        }


        tx.setMobileNumber(request.getMobileNumber());
        tx.setAmount(request.getAmount());
        tx.setStatus("SUCCESS");
        tx.setTransactionId(UUID.randomUUID().toString());
        tx.setCreatedTime(LocalDateTime.now());
        rechargeRepository.save(tx);

        //kafka event
        RechargeEvents event=new RechargeEvents();
        event.setMobileNumber(request.getMobileNumber());
        event.setAmount(request.getAmount());
        event.setTransactionId(tx.getTransactionId());
        event.setStatus("getTransactionId()");
        rechargeEventProducer.publishRechargeEvent(event);
        return "Recharge successful";
    }
    // fallback method
    public String rechargeFallback(RechargeRequest request, Exception ex) {
        return "Recharge failed. Please try again later.";
    }
}
