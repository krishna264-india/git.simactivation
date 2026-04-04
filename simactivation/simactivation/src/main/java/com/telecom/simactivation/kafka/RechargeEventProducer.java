package com.telecom.simactivation.kafka;

import com.telecom.simactivation.events.RechargeEvents;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RechargeEventProducer {

    private final KafkaTemplate<String,Object> kafkaTemplate;

    public RechargeEventProducer(KafkaTemplate<String,Object> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishRechargeEvent(RechargeEvents event) {
        kafkaTemplate.send("recharge-topic", event);
    }
}
