package com.krishna.accounts.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data @Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class Customer extends BaseEntity {

    @SuppressWarnings("deprecation")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;

    private String name;

    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

}
