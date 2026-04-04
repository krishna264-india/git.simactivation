package com.telecom.simactivation.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "customers")
@Data @Setter @Getter @AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String mobileNumber;

    private String simNumber;
    private String status;

    public Customer() {

    }
}
