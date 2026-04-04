package com.telecom.simactivation.events;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data @Setter @Getter
public class SimActivatedEvent {

    private String mobileNumber;
    private String simNumber;
    private String status;
}
