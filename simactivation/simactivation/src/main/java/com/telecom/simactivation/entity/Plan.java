package com.telecom.simactivation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "plans")
@Data
@Setter @Getter
public class Plan {

    @Id
    private String planId;

    private String planName;

    private double price;

    private int validityDays;
}
