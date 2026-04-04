package com.telecom.simactivation.dto;

import lombok.Getter;
import lombok.Setter;

@Setter@Getter
public class BalanceResponse {

    private String mobileNumber;

    private double balance;
}
