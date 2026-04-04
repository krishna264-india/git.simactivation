package com.telecom.simactivation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class RechargeRequest {

    private String mobileNumber;

    @NotNull
    private double amount;

}
