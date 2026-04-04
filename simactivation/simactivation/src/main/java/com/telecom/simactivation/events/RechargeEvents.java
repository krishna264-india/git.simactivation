package com.telecom.simactivation.events;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter @Getter
public class RechargeEvents {

    private String mobileNumber;
    private double amount;
    private String transactionId;
    private String status;

    public RechargeEvents() {
    }
}
