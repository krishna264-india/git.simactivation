package com.telecom.simactivation.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "billing_transactions")
@Data @Setter @Getter
public class BillingTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mobileNumber;

    private double amount;
    private String type;

    private LocalDateTime createdTime;
}
