package com.telecom.simactivation.publisher;

import com.telecom.simactivation.events.RechargeEvents;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;


/*
This class is responsible for publishing recharge events to Kafka.
It helps decouple the recharge service from downstream systems like billing and
notifications. By using Kafka, we achieve asynchronous communication, better scalability,
and fault tolerance.
 */
@Slf4j
@Component
public class RechargeEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;


    public RechargeEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void publish(RechargeEvents events){
        log.info("Publishing recharge event: {}", events);
        kafkaTemplate.send("recharge-topic", events);

    }
}
