package com.telecom.simactivation.service;

import com.telecom.simactivation.dto.SimActivationRequest;

public interface SimActivationService {

    String activateSim(SimActivationRequest request);
}
