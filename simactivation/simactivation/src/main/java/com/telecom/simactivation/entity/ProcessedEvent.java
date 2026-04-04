package com.telecom.simactivation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter @Getter
public class ProcessedEvent {

    @Id
    private String transactionId;
}
