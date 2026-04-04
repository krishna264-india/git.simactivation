package com.telecom.simactivation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "balance")
@Data @Setter @Getter
public class Balance {

    @Id
    private String mobileNumber;

    private double balanceAmount;
}
