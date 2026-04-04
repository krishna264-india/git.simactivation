package com.telecom.simactivation.kafka;

import com.telecom.simactivation.entity.Balance;
import com.telecom.simactivation.entity.ProcessedEvent;
import com.telecom.simactivation.events.RechargeEvents;
import com.telecom.simactivation.repository.BalanceRepository;
import com.telecom.simactivation.repository.ProcessedEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RechargeEventConsumer {

    private final BalanceRepository balanceRepository;
    private final ProcessedEventRepository processedRepo;

    private static final Logger log =
            LoggerFactory.getLogger(RechargeEventConsumer.class);

    public RechargeEventConsumer(BalanceRepository balanceRepository, ProcessedEventRepository processedRepo) {
        this.balanceRepository = balanceRepository;
        this.processedRepo = processedRepo;
    }

    @KafkaListener(topics="recharge-topic",groupId="telecom-group")
    public void consumeRechargeEvent(RechargeEvents event){

        System.out.println("Recharge processed for mobile: "
                + event.getMobileNumber());

    }

    @KafkaListener(topics = "recharge-topic",
            groupId = "telecom-group")
    public void consume(RechargeEvents events){

        if (events.getAmount() < 0) {
            throw new RuntimeException("Invalid recharge amount");
        }


        //check if already proceesed
        if(processedRepo.existsById(events.getTransactionId())){
            System.out.println("Duplicate event skipped: "+ events.getTransactionId());
            return;
        }
        Balance balance= balanceRepository.findByMobileNumber(events.getMobileNumber())
                .orElse(null);

        if(balance == null){
            balance =new Balance();
            balance.setMobileNumber(events.getMobileNumber());
            balance.setBalanceAmount(events.getAmount());
        } else{
            balance.setBalanceAmount(
                    balance.getBalanceAmount() + events.getAmount());
        }
        balanceRepository.save(balance);

        ProcessedEvent processed=new ProcessedEvent();
        processed.setTransactionId(events.getTransactionId());
        processedRepo.save(processed);
        System.out.println("Balance updated for " + events.getTransactionId());
        System.out.println("Balance updated for " + events.getMobileNumber());
        try {
            log.info("Received recharge for mobile: {}", events.getMobileNumber());

            // Business logic
            processRecharge(events);

        } catch (Exception e) {
            log.error("Error processing recharge event", e);
        }

//        System.out.println("Received Recharge Event:");
//        System.out.println("Mobile: " + events.getMobileNumber());
//        System.out.println("Amount: " + events.getAmount());
    }

    @KafkaListener(topics = "recharge-dlt-topic", groupId = "telecom-group")
    public void consumeDLT(RechargeEvents event) {

        System.out.println("DLT Event received: " + event.getTransactionId());

        // store in DB or alert team
    }
    private void processRecharge(RechargeEvents events){
        log.info("Recharge processed successfully for {}",
                events.getMobileNumber());
    }

}
