package com.telecom.simactivation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data@Setter@Getter@AllArgsConstructor@NoArgsConstructor
public class SimActivationRequest {

    @NotBlank
    private String customerName;

    @NotBlank
    private String mobileNumber;

    @NotBlank
    private String simNumber;
}
